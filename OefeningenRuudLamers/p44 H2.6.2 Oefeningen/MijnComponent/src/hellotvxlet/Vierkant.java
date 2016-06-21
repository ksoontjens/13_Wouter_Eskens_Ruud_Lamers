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
 * @author student
 */
public class Vierkant extends HComponent {
int br, ho;

    
    public Vierkant(int x, int y, int width, int height) {
        this.setBounds(x, y, width, height);
        br=width;
        ho=height;
        
    }

    public void paint(Graphics g) {
        g.setColor(new DVBColor(255, 100, 100, 179));
        g.fillRoundRect(10, 10, br- 10, ho-10, 15,15);
        g.setColor(new DVBColor(0, 0, 179, 179));
        g.fillRoundRect(0, 0, br-10, ho-10, 15, 15);
        g.setColor(new DVBColor(255, 255, 0, 255));
        g.drawString("Hallo Wereld", 50, 50);
    }

}
