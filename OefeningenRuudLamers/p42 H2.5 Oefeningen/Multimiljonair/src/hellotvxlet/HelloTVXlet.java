package hellotvxlet;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.tv.xlet.*;
import org.dvb.ui.DVBColor;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;
import org.havi.ui.HStaticText;
import org.havi.ui.HTextButton;
import org.havi.ui.HVisible;
import org.havi.ui.event.HActionListener;

public class HelloTVXlet implements Xlet, HActionListener {

    HScene scene;
    HTextButton gw, bc, bo, rr, hulp;
    HStaticText goedfout;

    public HelloTVXlet() {
    }

    public void initXlet(XletContext context) throws XletStateChangeException {
        System.out.println("initXlet");
        scene = HSceneFactory.getInstance().getDefaultHScene();
    }

    public void startXlet() {
        System.out.println("startXlet");
        HStaticText label = new HStaticText("Wie was de eerste president\nvan de VS?", 150, 175, 400, 100);
        label.setBackgroundMode(HVisible.BACKGROUND_FILL);
        label.setBackground(Color.BLACK);

        goedfout = new HStaticText("Fout", 150, 50, 400, 100);
        goedfout.setBackgroundMode(HVisible.BACKGROUND_FILL);
        goedfout.setVisible(false);

        hulp = new HTextButton("Hulplijn aanvragen", 50, 325, 300, 50);
        hulp.setBackgroundMode(HVisible.BACKGROUND_FILL);
        hulp.setBackground(new DVBColor(255, 0, 0, 50));
        hulp.setActionCommand("hulp");
        hulp.addHActionListener(this);

        gw = new HTextButton("George Washinton", 50, 400, 300, 50);
        gw.setBackgroundMode(HVisible.BACKGROUND_FILL);
        gw.setBackground(new DVBColor(255, 0, 0, 50));
        gw.setActionCommand("goed");
        gw.addHActionListener(this);

        bc = new HTextButton("Bill Clinton", 50, 500, 300, 50);
        bc.setBackgroundMode(HVisible.BACKGROUND_FILL);
        bc.setBackground(new DVBColor(255, 0, 0, 50));
        bc.setActionCommand("fout");
        bc.addHActionListener(this);

        bo = new HTextButton("Barak Obama", 375, 400, 300, 50);
        bo.setBackgroundMode(HVisible.BACKGROUND_FILL);
        bo.setBackground(new DVBColor(255, 0, 0, 50));
        bo.setActionCommand("fout");
        bo.addHActionListener(this);

        rr = new HTextButton("Ronald Reagan", 375, 500, 300, 50);
        rr.setBackgroundMode(HVisible.BACKGROUND_FILL);
        rr.setBackground(new DVBColor(255, 0, 0, 50));
        rr.setActionCommand("fout");
        rr.addHActionListener(this);

        scene.add(gw);
        scene.add(bc);
        scene.add(bo);
        scene.add(rr);
        scene.add(goedfout);
        scene.add(hulp);

        rr.setFocusTraversal(bo, null, bc, null);
        bo.setFocusTraversal(hulp, rr, gw, null);
        bc.setFocusTraversal(gw, null, null, rr);
        gw.setFocusTraversal(hulp, bc, null, bo);
        hulp.setFocusTraversal(null, gw, null, null);

        scene.add(label);
        scene.validate();
        scene.setVisible(true);
        gw.requestFocus();
    }

    public void actionPerformed(ActionEvent event) {
        System.out.println(event.getActionCommand());
        if (event.getActionCommand().equals("goed")) {
            goedfout.setVisible(true);
            goedfout.setBackground(new DVBColor(0, 255, 0, 150));
            goedfout.setTextContent("Goed", HVisible.ALL_STATES);
        } else if (event.getActionCommand().equals("hulp")) {
            scene.remove(bo);
            scene.remove(bc);
            scene.remove(hulp);
            gw.setFocusTraversal(rr, rr, rr, rr);
            rr.setFocusTraversal(gw, gw, gw, gw);
            scene.repaint();

        } else if (event.getActionCommand().equals("fout")){
            goedfout.setVisible(true);
            goedfout.setBackground(new DVBColor(255, 0, 0, 150));
            goedfout.setTextContent("Fout", HVisible.ALL_STATES);
        }
    }

    public void pauseXlet() {
    }

    public void destroyXlet(boolean unconditional) {
    }
}
