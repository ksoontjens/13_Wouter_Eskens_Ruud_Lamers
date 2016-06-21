package hellotvxlet;

import java.awt.event.KeyEvent;
import javax.tv.xlet.Xlet;
import javax.tv.xlet.XletContext;
import javax.tv.xlet.XletStateChangeException;
import org.davic.resources.ResourceClient;
import org.davic.resources.ResourceProxy;
import org.dvb.event.EventManager;
import org.dvb.event.UserEvent;
import org.dvb.event.UserEventListener;
import org.dvb.event.UserEventRepository;
import org.havi.ui.HBackgroundConfigTemplate;
import org.havi.ui.HBackgroundDevice;
import org.havi.ui.HBackgroundImage;
import org.havi.ui.HConfigurationException;
import org.havi.ui.HPermissionDeniedException;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HScreen;
import org.havi.ui.HStaticText;
import org.havi.ui.HStillImageBackgroundConfiguration;
import org.havi.ui.event.HBackgroundImageEvent;
import org.havi.ui.event.HBackgroundImageListener;
import org.havi.ui.event.HRcEvent;

public class HelloTVXlet implements Xlet, ResourceClient, HBackgroundImageListener, UserEventListener {

    public HBackgroundDevice hBackgroundDev;
    public HBackgroundImage pizza1;
    public HBackgroundImage pizza2;
    public HBackgroundImage pizza3;
    public HBackgroundImage pizza4;
    int imageTeller=0;
    int cursor=1;
    HStaticText orderlist;
    String orderlijst="Orderlijst:\n";
    public HStillImageBackgroundConfiguration hstlbgc;

    public void destroyXlet(boolean unconditional) throws XletStateChangeException {
    }

    public void initXlet(XletContext ctx) throws XletStateChangeException {
        HScreen hScreen = HScreen.getDefaultHScreen();
        hBackgroundDev = hScreen.getDefaultHBackgroundDevice();

        hBackgroundDev.reserveDevice(this); //bovenaan inmpelments ResourceClient
        // toevoegen + imports

        HBackgroundConfigTemplate cfgTemplate = new HBackgroundConfigTemplate();
        cfgTemplate.setPreference(HBackgroundConfigTemplate.STILL_IMAGE, HBackgroundConfigTemplate.REQUIRED);
        hBackgroundDev.getBestConfiguration(cfgTemplate);
        hstlbgc = (HStillImageBackgroundConfiguration) hBackgroundDev.getBestConfiguration(cfgTemplate);

        try {
            if (hBackgroundDev.setBackgroundConfiguration(hstlbgc)) {
                System.out.println("Reservatie en configurateie gelukt!");
            }
        } catch (SecurityException ex) {
            ex.printStackTrace();
        } catch (HPermissionDeniedException ex) {
            ex.printStackTrace();
        } catch (HConfigurationException ex) {
            ex.printStackTrace();
        }
        pizza1 = new HBackgroundImage("pizza1.m2v");
        pizza1.load(this);
        pizza2 = new HBackgroundImage("pizza2.m2v");
        pizza2.load(this);
        pizza3 = new HBackgroundImage("pizza3.m2v");
        pizza3.load(this);
        pizza4 = new HBackgroundImage("pizza4.m2v");
        pizza4.load(this);
        UserEventRepository rep=new UserEventRepository("naam");
        rep.addAllArrowKeys();
        rep.addKey(HRcEvent.VK_ENTER);
        EventManager m=EventManager.getInstance();
        m.addUserEventListener(this, rep); // bij implementes UserEventListerner toevoegen
        HScene scene=HSceneFactory.getInstance().getDefaultHScene();
        orderlist=new HStaticText(orderlijst,400,50,300,400); // xywh
        orderlist.setVerticalAlignment(HStaticText.VALIGN_TOP);
        orderlist.setHorizontalAlignment(HStaticText.HALIGN_LEFT);
        scene.add(orderlist);
        scene.validate();
        scene.setVisible(true);
    }

    public void imageLoaded(HBackgroundImageEvent e) {
        imageTeller++;
        if (imageTeller == 4) {
            System.out.println("imges geladen");
            try {
                hstlbgc.displayImage(pizza1);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void userEventReceived(UserEvent e) {
        if(e.getType()==KeyEvent.KEY_PRESSED){
            if(e.getCode()==HRcEvent.VK_LEFT){
                cursor--; if(cursor==0)cursor=4;
            }
            if(e.getCode()==HRcEvent.VK_RIGHT){
                cursor++; if(cursor==5)cursor=1;
            }
            if(e.getCode()==HRcEvent.VK_ENTER){
                if(cursor==1)orderlijst=orderlijst+"Meat\n";
                if(cursor==2)orderlijst=orderlijst+"Pepperoni\n";
                if(cursor==3)orderlijst=orderlijst+"Cheese\n";
                if(cursor==4)orderlijst=orderlijst+"Vegi\n";
            }
            orderlist.setTextContent(orderlijst, HStaticText.NORMAL_STATE);
        }
        try {
                if(cursor==1)hstlbgc.displayImage(pizza1);
                if(cursor==2)hstlbgc.displayImage(pizza2);
                if(cursor==3)hstlbgc.displayImage(pizza3);
                if(cursor==4)hstlbgc.displayImage(pizza4);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
    }

    public void pauseXlet() {
    }

    public void startXlet() throws XletStateChangeException {
    }

    public boolean requestRelease(ResourceProxy proxy, Object requestData) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void release(ResourceProxy proxy) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void notifyRelease(ResourceProxy proxy) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void imageLoadFailed(HBackgroundImageEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
