/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hellotvxlet;

import java.awt.Color;
import java.awt.Image;
import java.awt.MediaTracker;
import org.havi.ui.HGraphicButton;
import org.havi.ui.HState;
import org.havi.ui.HVisible;

/**
 *
 * @author student
 */
public class Card extends HGraphicButton {

    Image img, back;
    boolean blocked, turned = false;
    int match;

    public Card(int x, int y, String imgstring, int match) {
        this.match = match;
        this.setLocation(x, y);
        this.setSize(60, 60);
        this.setBackground(Color.WHITE);
        this.setBackgroundMode(HVisible.BACKGROUND_FILL);
        this.setForeground(Color.BLACK);
//        this.setTextContent("Card", HState.ALL_STATES);
        img = this.getToolkit().getImage(imgstring);
        back = this.getToolkit().getImage("background.jpg");
        MediaTracker mt = new MediaTracker(this);
        mt.addImage(img, 0);
        mt.addImage(back, 1);
        try {
            mt.waitForAll();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.setGraphicContent(back, HState.NORMAL_STATE);
        this.setGraphicContent(img, HState.ACTIONED_FOCUSED_STATE);
    }

    public void click() {
        this.setGraphicContent(img, HState.NORMAL_STATE);
        turned = true;
    }

    public void reset() {
        if (!blocked) {
            this.setGraphicContent(back, HState.NORMAL_STATE);
            turned = false;
        }
    }

    public void block() {
        this.blocked = true;
    }
}
