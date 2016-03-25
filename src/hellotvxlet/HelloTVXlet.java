package hellotvxlet;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.tv.xlet.Xlet;
import javax.tv.xlet.XletContext;
import javax.tv.xlet.XletStateChangeException;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HText;
import org.havi.ui.HVisible;
import org.havi.ui.event.HActionListener;

public class HelloTVXlet implements Xlet, HActionListener {

    HScene scene;
    Card c1, c2;
    int[] match = {1, 2};
    String[] bg = {"android.jpg", "amazon.jpg"};
    Card[] cards=new Card[bg.length*2];
    int countTurned = -1;
    Card[] turnedCards = new Card[2];
    int score = 0;

    public void initXlet(XletContext ctx) throws XletStateChangeException {
        scene = HSceneFactory.getInstance().getDefaultHScene();
        // BACKGROUND COLOR
        scene.setBackground(Color.BLACK);
        scene.setBackgroundMode(HVisible.BACKGROUND_FILL);

        HText t = new HText("Speler 1", 10, 10, 85, 75);
        for (int j = 1; j <= 2; j++) {
            for (int i = 0; i < bg.length; i++) {
                cards[i*j] = new Card(105 + i * 60 * j, 10, bg[i], match[i]);
                cards[i*j].setActionCommand(Integer.toString(i*j));
                cards[i*j].addHActionListener(this);
            }
        }
        for (int i = 0; i < cards.length; i++) {
            int prev = i - 1;
            if (prev < 0) {
                prev = cards.length - 1;
            }
            int next = i + 1;
            if (next > cards.length - 1) {
                next = 0;
            }
            System.out.println("count="+cards.length+" i="+i+" p="+prev+" n="+next);
            cards[i].setFocusTraversal(null, null, cards[prev], cards[next]);
            scene.add(cards[i]);
        }
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
