package hellotvxlet;

import java.awt.Color;
import java.awt.MediaTracker;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.Collections;
import javax.tv.xlet.Xlet;
import javax.tv.xlet.XletContext;
import javax.tv.xlet.XletStateChangeException;
import org.havi.ui.HComponent;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HVisible;
import org.havi.ui.event.HActionListener;

/**
 *
 * @author Ruud Lamers, Wouter Eskens
 */
public class HelloTVXlet extends HComponent implements Xlet, HActionListener {

    HScene scene;
    Combo[] combos = {
        new Combo(1, "amazon.jpg"), new Combo(2, "android.jpg"),
        new Combo(3, "apple.jpg"), new Combo(4, "bing.jpg"),
        new Combo(5, "dropbox.jpg"), new Combo(6, "evernote.jpg"),
        new Combo(7, "facebook.jpg"), new Combo(8, "googleplus.jpg"),
        new Combo(9, "imdb.jpg"), new Combo(10, "instagram.jpg"),
        new Combo(11, "linkedin.jpg"), new Combo(12, "pinterest.jpg"),
        new Combo(13, "skype.jpg"), new Combo(14, "snapchat.jpg"),
        new Combo(15, "soundcloud.jpg"), new Combo(16, "tumbler.jpg"),
        new Combo(17, "twitter.jpg"), new Combo(18, "vimeo.jpg"),
        new Combo(19, "whatsapp.jpg"), new Combo(20, "windows.jpg"),
        new Combo(21, "wordpress.jpg"), new Combo(22, "xbox.jpg"),
        new Combo(23, "yahoo.jpg"), new Combo(24, "youtube.jpg"),
        new Combo(1, "amazon.jpg"), new Combo(2, "android.jpg"),
        new Combo(3, "apple.jpg"), new Combo(4, "bing.jpg"),
        new Combo(5, "dropbox.jpg"), new Combo(6, "evernote.jpg"),
        new Combo(7, "facebook.jpg"), new Combo(8, "googleplus.jpg"),
        new Combo(9, "imdb.jpg"), new Combo(10, "instagram.jpg"),
        new Combo(11, "linkedin.jpg"), new Combo(12, "pinterest.jpg"),
        new Combo(13, "skype.jpg"), new Combo(14, "snapchat.jpg"),
        new Combo(15, "soundcloud.jpg"), new Combo(16, "tumbler.jpg"),
        new Combo(17, "twitter.jpg"), new Combo(18, "vimeo.jpg"),
        new Combo(19, "whatsapp.jpg"), new Combo(20, "windows.jpg"),
        new Combo(21, "wordpress.jpg"), new Combo(22, "xbox.jpg"),
        new Combo(23, "yahoo.jpg"), new Combo(24, "youtube.jpg")
    };
    Card[] cards = new Card[combos.length];
    int countTurned = -1;
    Card[] turnedCards = new Card[2];
    MediaTracker mt;
    Player[] players = new Player[2];
    int activePlayer = 0;

    class Combo {
        int match;
        String bg;

        public Combo(int match, String bg) {
            this.match = match;
            this.bg = bg;
        }
    }

    public void initXlet(XletContext ctx) throws XletStateChangeException {
        scene = HSceneFactory.getInstance().getDefaultHScene();
        // BACKGROUND COLOR
        scene.setBackground(Color.BLACK);
        scene.setBackgroundMode(HVisible.BACKGROUND_FILL);
        // kaartjes shuffelen en grid opbouwen
        Collections.shuffle(Arrays.asList(combos));
        int x = 145, y = 10;
        for (int i = 0; i < combos.length; i++) {
            x += 70;
            if (i % 8 == 0) {
                x = 145;
                y += 70;
            }
            cards[i] = new Card(x, y, combos[i].bg, combos[i].match);
            cards[i].setActionCommand(Integer.toString(i));
            cards[i].addHActionListener(this);
        }
        // navigatie op orde brengen
        int[] nextArray = {7, 15, 23, 31, 39, 47};
        for (int i = 0; i < cards.length; i++) {
            int prev = i - 1;
            if (i % 8 == 0) {
                prev = i + 7;
            } else {
                if (prev < 0) {
                    prev = cards.length - 1;
                }
            }
            boolean foundIndex = false;
            int next = i + 1;
            for (int j = 0; j < nextArray.length; j++) {
                if (nextArray[j] == i) {
                    foundIndex = true;
                    next = i - 7;
                }
            }
            if (!foundIndex) {
                if (next > cards.length - 1) {
                    next = 0;
                }
            }
            int down = i + 8;
            if (down >= cards.length) {
                down -= 48;
            }
            int up = i - 8;
            if (up < 0) {
                up += 48;
            }
            cards[i].setFocusTraversal(cards[up], cards[down], cards[prev], cards[next]);
            scene.add(cards[i]);
        }
        // spelers aanmaken
        players[0] = new Player("Speler 1", 20, 80, 105, 100);
        players[1] = new Player("Speler 2", 20, y - 40, 105, 100);
        //spelers aan scene toevoegen
        scene.add(players[0]);
        scene.add(players[1]);
        scene.validate();
        scene.setVisible(true);
        // eerste kaart focus geven
        cards[0].requestFocus();
        // speler actief zetten
        players[activePlayer].active();
    }

    public void pauseXlet() {
    }

    public void startXlet() throws XletStateChangeException {
    }

    public void destroyXlet(boolean unconditional) throws XletStateChangeException {
    }

    public void actionPerformed(ActionEvent event) {
        int cardId = Integer.parseInt(event.getActionCommand());
        if (!cards[cardId].blocked && !cards[cardId].turned) {
            cards[Integer.parseInt(event.getActionCommand())].click();
            countTurned++;
            turnedCards[countTurned] = cards[cardId];
            if (countTurned == 1) {
                countTurned = -1;
                if (turnedCards[0].match == turnedCards[1].match) {
                    players[activePlayer].scored();
                    turnedCards[0].block();
                    turnedCards[1].block();
                } else {
                    players[activePlayer].deactive();
                    activePlayer++;
                    if (activePlayer >= players.length) {
                        activePlayer = 0;
                    }
                    players[activePlayer].active();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                    turnedCards[0].reset();
                    turnedCards[1].reset();

                }
            }
        }
    }
}