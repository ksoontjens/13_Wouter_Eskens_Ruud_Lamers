/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hellotvxlet;

import java.awt.Color;
import java.awt.Graphics;
import org.havi.ui.HComponent;
import org.havi.ui.HText;
import org.havi.ui.HVisible;

/**
 *
 * @author student
 */
public class Player extends HComponent {

    boolean active;
    int score = 0, x=0, y=0,width=0,height=0;
    String text;

    public Player(String text, int x, int y, int width, int height) {
        this.setBounds(x, y, width, height);
        this.x = x;
        this.y = y;
        this.width=width;
        this.height=height;
        this.text = text;
        deactive();
    }

    public void paint(Graphics g) {
        if (active==true) {
            g.setColor(Color.RED);
        } else {
            g.setColor(Color.BLUE);
        }
        g.fillRect(0, 0, width, height);
        g.setColor(Color.WHITE);
        g.drawString(text, 10, 40);
        g.drawString(Integer.toString(score), 10, 70);
    }

    public void scored() {
        score += 1;
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
