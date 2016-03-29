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
import org.havi.ui.HText;
import org.havi.ui.HVisible;
import org.havi.ui.event.HActionListener;

public class HelloTVXlet extends HComponent implements Xlet, HActionListener {

    HScene scene;
    Combo[] combos = {new Combo(1, "amazon.jpg"), new Combo(2, "android.jpg"), new Combo(3, "apple.jpg"), new Combo(4, "bing.jpg"), new Combo(5, "dropbox.jpg"), new Combo(6, "evernote.jpg"), new Combo(7, "facebook.jpg"), new Combo(8, "googleplus.jpg"), new Combo(9, "imdb.jpg"), new Combo(10, "instagram.jpg"), new Combo(11, "linkedin.jpg"), new Combo(12, "pinterest.jpg"), new Combo(13, "skype.jpg"), new Combo(14, "snapchat.jpg"), new Combo(15, "soundcloud.jpg"), new Combo(16, "tumbler.jpg"), new Combo(17, "twitter.jpg"), new Combo(18, "vimeo.jpg"), new Combo(19, "whatsapp.jpg"), new Combo(20, "windows.jpg"), new Combo(21, "wordpress.jpg"), new Combo(22, "xbox.jpg"), new Combo(23, "yahoo.jpg"), new Combo(24, "youtube.jpg"),new Combo(1, "amazon.jpg"), new Combo(2, "android.jpg"), new Combo(3, "apple.jpg"), new Combo(4, "bing.jpg"), new Combo(5, "dropbox.jpg"), new Combo(6, "evernote.jpg"), new Combo(7, "facebook.jpg"), new Combo(8, "googleplus.jpg"), new Combo(9, "imdb.jpg"), new Combo(10, "instagram.jpg"), new Combo(11, "linkedin.jpg"), new Combo(12, "pinterest.jpg"), new Combo(13, "skype.jpg"), new Combo(14, "snapchat.jpg"), new Combo(15, "soundcloud.jpg"), new Combo(16, "tumbler.jpg"), new Combo(17, "twitter.jpg"), new Combo(18, "vimeo.jpg"), new Combo(19, "whatsapp.jpg"), new Combo(20, "windows.jpg"), new Combo(21, "wordpress.jpg"), new Combo(22, "xbox.jpg"), new Combo(23, "yahoo.jpg"), new Combo(24, "youtube.jpg")};
    int[] match = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24};
    String[] bg = {"amazon.jpg", "android.jpg", "apple.jpg", "bing.jpg", "dropbox.jpg", "evernote.jpg", "facebook.jpg", "googleplus.jpg", "imdb.jpg", "instagram.jpg", "linkedin.jpg", "pinterest.jpg", "skype.jpg", "snapchat.jpg", "soundcloud.jpg", "tumbler.jpg", "twitter.jpg", "vimeo.jpg", "whatsapp.jpg", "windows.jpg", "wordpress.jpg", "xbox.jpg", "yahoo.jpg", "youtube.jpg", "amazon.jpg", "android.jpg", "apple.jpg", "bing.jpg", "dropbox.jpg", "evernote.jpg", "facebook.jpg", "googleplus.jpg", "imdb.jpg", "instagram.jpg", "linkedin.jpg", "pinterest.jpg", "skype.jpg", "snapchat.jpg", "soundcloud.jpg", "tumbler.jpg", "twitter.jpg", "vimeo.jpg", "whatsapp.jpg", "windows.jpg", "wordpress.jpg", "xbox.jpg", "yahoo.jpg", "youtube.jpg"};
    Card[] cards = new Card[combos.length];
    int countTurned = -1;
    Card[] turnedCards = new Card[2];
    int score = 0;
    MediaTracker mt;

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
        HText t = new HText("Speler 1", 10, 10, 85, 75);
        Collections.shuffle(Arrays.asList(combos));
        int x = 105 - 70, y = 10;
        for (int i = 0; i < combos.length; i++) {
            x += 70;
            if (i % 8 == 0) {
                x = 105;
                y += 70;
            }
            cards[i] = new Card(x, y, combos[i].bg, combos[i].match);
            cards[i].setActionCommand(Integer.toString(i));
            cards[i].addHActionListener(this);
        }
//        for (int i = 0; i < bg.length; i++) {
//            x += 70;
//            if (i % 8 == 0) {
//                x = 105;
//                y += 70;
//            }
//            cards[i] = new Card(x, y, bg[i], match[i]);
//            cards[i].setActionCommand(Integer.toString(i));
//            cards[i].addHActionListener(this);
//        }
        // enkel links en recht pijltjes...
        for (int i = 0; i < cards.length; i++) {
            int prev = i - 1;
            if (prev < 0) {
                prev = cards.length - 1;
            }
            int next = i + 1;
            if (next > cards.length - 1) {
                next = 0;
            }
            System.out.println("count=" + cards.length + " i=" + i + " p=" + prev + " n=" + next);
            cards[i].setFocusTraversal(null, null, cards[prev], cards[next]);
            scene.add(cards[i]);
        }
//        int row=1;
//        double procent=7.0;
//        for (int i = 0; i < 24; i++) {
//            if(i%8==0&&i!=0){
//                row++;
//                procent+=.5;
//            }
//            int prev = i - 1;
//            if (prev < 0||(prev==procent*row+1&&row>1)) {
//                prev = 7*row;
//            }
//            int next = i + 1;
//            if (next > procent*row) {
//                next = i-7;
//            }
//            System.out.println("count=" + cards.length + " i=" + i + " p=" + prev + " n=" + next+" row="+row+" pr="+procent*row);
//            cards[i].setFocusTraversal(null, null, cards[prev], cards[next]);
//            scene.add(cards[i]);
//        }
        scene.add(t);
        scene.validate();
        scene.setVisible(true);
        cards[0].requestFocus();
    }

    public void pauseXlet() {
    }

    public void startXlet() throws XletStateChangeException {
    }

    public void destroyXlet(boolean unconditional) throws XletStateChangeException {
    }

    public void actionPerformed(ActionEvent event) {
        int cardId = Integer.parseInt(event.getActionCommand());
        System.out.println(cardId);
        if (!cards[cardId].blocked && !cards[cardId].turned) {
            cards[Integer.parseInt(event.getActionCommand())].click();
            countTurned++;
            turnedCards[countTurned] = cards[cardId];
            if (countTurned == 1) {
                countTurned = -1;
                if (turnedCards[0].match == turnedCards[1].match) {
                    score++;
                    turnedCards[0].block();
                    turnedCards[1].block();
                } else {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                    turnedCards[0].reset();
                    turnedCards[1].reset();

                }
                System.out.println("score=" + score);
            }
        }
    }
}
