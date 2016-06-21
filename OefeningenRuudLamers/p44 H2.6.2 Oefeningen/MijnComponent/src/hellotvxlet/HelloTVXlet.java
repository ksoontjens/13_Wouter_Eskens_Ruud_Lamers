package hellotvxlet;

import java.awt.Color;
import javax.tv.xlet.Xlet;
import javax.tv.xlet.XletContext;
import javax.tv.xlet.XletStateChangeException;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;




public class HelloTVXlet implements Xlet{

    HScene scene;
    public void destroyXlet(boolean unconditional) throws XletStateChangeException {
        
    }

    public void initXlet(XletContext ctx) throws XletStateChangeException {
        scene=HSceneFactory.getInstance().getDefaultHScene();
        MijnComponent comp=new MijnComponent();
        scene.add(comp);
        MijnComponent comp2=new MijnComponent(20,20,200,200);
        scene.add(comp2);
        Vierkant comp1=new Vierkant(200,150,400,400);
        scene.add(comp1);
        scene.validate();
        scene.setVisible(true);
    }

    public void pauseXlet() {
        
    }

    public void startXlet() throws XletStateChangeException {
        
    }

  
    
}
