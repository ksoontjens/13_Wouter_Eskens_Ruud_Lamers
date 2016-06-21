package hellotvxlet;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.tv.xlet.*;
import javax.tv.xlet.XletContext;
import javax.tv.xlet.XletStateChangeException;
import org.dvb.ui.DVBColor;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HStaticText;
import org.havi.ui.HTextButton;
import org.havi.ui.HVisible;
import org.havi.ui.event.HActionListener;


public class HelloTVXlet implements Xlet, HActionListener {

    HScene scene;
    HTextButton button1;
    HTextButton button2;
    HTextButton button3;
    HTextButton button4;
    HTextButton button5;
    
    public HelloTVXlet(){
        
    }

    public void initXlet(XletContext arg0) throws XletStateChangeException {
      System.out.println("initXlet");
      scene = HSceneFactory.getInstance().getDefaultHScene();     
    }

    public void startXlet() throws XletStateChangeException{
    System.out.println("startXlet");
    
    HStaticText label = new HStaticText("Wie was de eerste president\nvan de Verenigde Staten", (720/2)-150, 250, 300, 150);
                                              // x, y, breedte, hoogte
    label.setBackgroundMode(HVisible.BACKGROUND_FILL);
    label.setBackground(Color.BLUE);
    
    button1 = new HTextButton("George Washington", 50, 300+100+20, (720/2)-100, 50);
    button2 = new HTextButton("Bill Clinton", 720/2 + 50, 300+100+20, (720/2)-100, 50);
    button3 = new HTextButton("Barack Obama", 50, 300+100+20+20+50, (720/2)-100, 50);
    button4 = new HTextButton("Ronald Reagan", 720/2 + 50, 300+100+20+20+50, (720/2)-100, 50);
    button5 = new HTextButton("Hulplijn", 50, 350, 100, 50);
    
    button1.setBackgroundMode(HVisible.BACKGROUND_FILL);
    button2.setBackgroundMode(HVisible.BACKGROUND_FILL);
    button3.setBackgroundMode(HVisible.BACKGROUND_FILL);
    button4.setBackgroundMode(HVisible.BACKGROUND_FILL);
    button5.setBackgroundMode(HVisible.BACKGROUND_FILL);
    button5.setBackground(Color.MAGENTA);
    
    scene.add(button1);
    scene.add(button2);
    scene.add(button3);
    scene.add(button4);
    scene.add(button5);
    
    button1.setFocusTraversal(button5, button3, null, button2);
    button2.setFocusTraversal(null, button4, button1, null);
    button3.setFocusTraversal(button1, null, null, button4);
    button4.setFocusTraversal(button2, null, button3, null);
    button5.setFocusTraversal(null, button1, null, null);
    
    button1.setActionCommand("CORRECT");
    button2.setActionCommand("FOUT");
    button3.setActionCommand("FOUT");
    button4.setActionCommand("FOUT");
    button5.setActionCommand("HULPLIJN");
    button1.addHActionListener(this);
    button2.addHActionListener(this);
    button3.addHActionListener(this);
    button4.addHActionListener(this);
    button5.addHActionListener(this);
    
    scene.add(label);
    
    scene.validate();
    scene.setVisible(true);
    button1.requestFocus();
    }

    public void actionPerformed(ActionEvent event) {
        System.out.println(event.getActionCommand());
        if(event.getActionCommand().equals("HULPLIJN")){
            button5.setBackground(Color.GRAY);
            scene.remove(button3);
            scene.remove(button4);
            /*button3.removeHActionListener(this);
            button3.removeHActionListener(this);*/
            scene.repaint();
        }
    }
    
    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
     
    }

    
}
