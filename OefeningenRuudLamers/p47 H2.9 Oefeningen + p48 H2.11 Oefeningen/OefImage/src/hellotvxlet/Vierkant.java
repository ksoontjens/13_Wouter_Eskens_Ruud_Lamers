/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import org.dvb.ui.DVBColor;
import org.havi.ui.HComponent;

/**
 *
 * @author student
 */
public class Vierkant extends HComponent {
int br, ho,x=300,sy=0;;
Image shiping,bg;
    
    public Vierkant(int x, int y, int width, int height) {
        this.setBounds(x, y, width, height);
        br=width;
        ho=height;
        shiping=this.getToolkit().getImage("spaceship.png");
        bg=this.getToolkit().getImage("sterren.png");
        //C:\Program Files\TechnoTrend\TT-MHP-Browser\fileio\DSMCC\0.0.3
        MediaTracker mt=new MediaTracker(this);
        mt.addImage(shiping, 0);
        mt.addImage(bg, 1);
        try{
            mt.waitForAll();
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }
    }

    public void paint(Graphics g) {
        g.drawImage(bg, 0, sy, null);
        g.drawImage(bg, 0, sy-570, null);
        g.drawImage(shiping, x, 500, null);
    }
    
    public void moveleft(){
        x-=5;
        this.repaint();
    }
    
    public void moveright(){
        x+=5;
        this.repaint();
    }
    
    public void scroll(){
        sy+=5;
        if(sy>=510){
            sy=0;
        }
        this.repaint();
    }

}
