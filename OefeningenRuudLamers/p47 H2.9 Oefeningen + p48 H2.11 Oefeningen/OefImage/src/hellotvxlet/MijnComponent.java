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
public class MijnComponent extends HComponent {

    public MijnComponent() {
        this.setBounds(10, 10, 200, 200);
    }
    
    public MijnComponent(int x, int y, int width, int height) {
        this.setBounds(x, y, width, height);
    }

    public void paint(Graphics g) {
        g.setColor(new DVBColor(255, 100, 100, 179));
        g.drawLine(0, 0, 100, 100);
        g.setColor(Color.ORANGE);
        g.drawString("Hallo, It's me", 20, 20);
    }
}
