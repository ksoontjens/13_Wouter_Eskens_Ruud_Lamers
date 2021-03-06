/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hellotvxlet;

import java.awt.Color;
import java.awt.Graphics;
import org.dvb.ui.DVBColor;
import org.havi.ui.HComponent;

/**
 *
 * @author Ruud Lamers, Wouter Eskens
 */
public class Player extends HComponent {

    boolean active;
    int x=0, y=0,width=0,height=0;
    String text;

    public Player(String text, int x, int y, int width, int height) {
        this.setBounds(x, y, width, height);
        this.x = x;
        this.y = y;
        this.width=width;
        this.height=height;
        this.text = text;
        deactive();
        Score.getInstance().AddPlayer(this);
    }

    public void paint(Graphics g) {
        if (active==true) {
            g.setColor(new DVBColor(0, 151, 0, 255));
        } else {
            g.setColor(Color.BLUE);
        }
        g.fillRect(0, 0, width, height);
        g.setColor(Color.WHITE);
        g.drawString(text, 10, 40);
        g.drawString(Integer.toString(Score.getInstance().getPlayerScore(this)), 10, 70);
    }

    public void scored() {
        Score.getInstance().setPlayerScore(this, Score.getInstance().getPlayerScore(this)+1);
        repaint();
    }

    public void active() {
        active = true;
        repaint();
    }

    public void deactive() {
        active = false;
        repaint();
    }
}
