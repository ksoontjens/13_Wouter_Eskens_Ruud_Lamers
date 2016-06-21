package hellotvxlet;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.Timer;
import javax.tv.xlet.Xlet;
import javax.tv.xlet.XletContext;
import javax.tv.xlet.XletStateChangeException;
import org.bluray.ui.event.HRcEvent;
import org.dvb.event.EventManager;
import org.dvb.event.UserEvent;
import org.dvb.event.UserEventListener;
import org.dvb.event.UserEventRepository;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;

public class HelloTVXlet implements Xlet, UserEventListener{

    HScene scene;
    Vierkant comp1;
    public void destroyXlet(boolean unconditional) throws XletStateChangeException {
        
    }

    public void initXlet(XletContext ctx) throws XletStateChangeException {
        scene=HSceneFactory.getInstance().getDefaultHScene();
        comp1=new Vierkant(0,0,720,576);
        scene.add(comp1);
        scene.validate();
        scene.setVisible(true);
    }

    public void pauseXlet() {
        
    }

    public void startXlet() throws XletStateChangeException {
        UserEventRepository rep=new UserEventRepository("naam");
        rep.addAllArrowKeys();
        EventManager m=EventManager.getInstance();
        m.addUserEventListener(this, rep);
        MijnTimerTask objMijnTimerTask=new MijnTimerTask(this);
        Timer t=new Timer();
        t.scheduleAtFixedRate(objMijnTimerTask, 0, 50);
    }
    
    public void callback(){
        comp1.scroll();
    }

    public void userEventReceived(UserEvent e) {
        if(e.getType()==KeyEvent.KEY_PRESSED&&e.getCode()==HRcEvent.VK_LEFT){
            comp1.moveleft();
        }
        if(e.getType()==KeyEvent.KEY_PRESSED&&e.getCode()==HRcEvent.VK_RIGHT){
            comp1.moveright();
        }
    }

  
    
}
