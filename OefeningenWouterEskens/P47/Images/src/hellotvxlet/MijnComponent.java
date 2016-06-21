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
    Image schipimg, sterrenimg;
    int x = 300;
    int y = 500;
    int sy = 0;
    
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
        schipimg = this.getToolkit().getImage("schip.png");
        sterrenimg = this.getToolkit().getImage("sterren.png");
        //schip.png zetten in c:\program files\technotrend\tt-mhp-broweser\filio\dsmcc\0.0.3
        MediaTracker mt = new MediaTracker(this);
        mt.addImage(schipimg, 0); //image, volgnr
        mt.addImage(sterrenimg, 1);
        try{
            mt.waitForAll();
        }
        catch(InterruptedException ex){
            ex.printStackTrace();
        }
    }
    //start
    /*
    public void paint(Graphics g)
    {
        g.drawLine(0, 0, 100, 100);
        g.drawString("hello", 50, 50);
    }*/
   
    
    public void moveleft(){
        x-=5;
        this.repaint();
    }
    
    public void moveright(){
        x+=5;
        this.repaint();
    }
    
    public void moveup(){
        y-=5;
        this.repaint();
    }
    
    public void movedown(){
        y+=5;
        this.repaint();
    }
    
    public void scroll(){
        sy++;
        if(sy>= 570){
            sy = 0;
        }
        this.repaint();
    }
    
    //oef2/oef3
    public void paint(Graphics g){
        g.drawImage(sterrenimg, 0, sy, null);
        g.drawImage(sterrenimg, 0, sy-570, null);
        g.drawImage(schipimg, x, y, null);
    }
    
    
}
