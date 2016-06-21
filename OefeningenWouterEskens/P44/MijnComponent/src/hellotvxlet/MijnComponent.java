/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.net.URL;
import org.dvb.ui.DVBColor;
import org.havi.ui.HComponent;

/**
 *
 * @author student
 */
public class MijnComponent extends HComponent
{
    int br, ho;
    Image schipimg;
    
    //oef1
    /*public MijnComponent(int x, int y, int w, int h)
    {
        this.setBounds(x,y,w,h); //x,y,breedte,hoogte
    }*/
    //oef2/oef3
    public MijnComponent(int x, int y, int w, int h)
    {
        this.setBounds(x,y,w,h); //x,y,breedte,hoogte
        br=w;
        ho=h;
        this.getToolkit().getImage("schip.png");
        //schip.png zetten in c:\program files\technotrend\tt-mhp-broweser\filio\dsmcc\0.0.3
        MediaTracker mt = new MediaTracker(null);
        mt.addImage(schipimg, 0); //image, volgnr
//        try{
//            mt.waitForAll();
//        }
//        catch(InterruptException ex){
//            ex.print
//        }
    }
    //start
    /*
    public void paint(Graphics g)
    {
        g.drawLine(0, 0, 100, 100);
        g.drawString("hello", 50, 50);
    }*/
    //oef2/oef3
    public void paint(Graphics g){
        g.setColor(new DVBColor(0,0,63,179));
        g.fillRoundRect(10, 10, br-10, ho-10, 15, 15);
        g.setColor(new DVBColor(0,0,179,179));
        g.fillRoundRect(0, 0, br-10, ho-10, 15, 15);
        g.setColor(new DVBColor(255,255,0,255));
        g.drawString("MijnComponent", 50, 50);
    }
}
