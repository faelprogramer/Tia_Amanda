package br.com.tiaAmanda;

import br.com.tiaAmanda.visao.frame.JFramePrincipal;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import static javax.swing.UIManager.getInstalledLookAndFeels;
import javax.swing.UnsupportedLookAndFeelException;

public class Program implements Runnable {

    private JFrame framePrincipal;

    @Override
    public void run() {
        setLookAndFeelSystem();
        //com.alee.laf.WebLookAndFeel.install();
        framePrincipal = new JFramePrincipal();
        framePrincipal.setVisible(true);
    }

    private void setNativeLookAndFeel(String laf) {
        setNimbusCustomized();
        for (LookAndFeelInfo info : getInstalledLookAndFeels()) {
            if (laf.equalsIgnoreCase(info.getName())) {
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }
                break;
            }
        }
    }

    private void setNimbusCustomized() {
        UIManager.put("nimbusBase", new Color(130, 130, 130));
        UIManager.put("nimbusBlueGrey", new Color(150, 150, 150));
        UIManager.put("control", new Color(200, 200, 200));
    }

    private void setNimbusGray() {
        UIManager.put("nimbusBase", new Color(81, 81, 81));
        UIManager.put("nimbusBlueGrey", new Color(190, 190, 190));
        UIManager.put("control", new Color(223, 223, 223));
    }

    private void setNimbusRed() {
        UIManager.put("nimbusBase", new Color(140, 42, 42));
        UIManager.put("nimbusBlueGrey", new Color(190, 167, 167));
        UIManager.put("control", new Color(223, 215, 214));
    }

    private void setNimbusOrange() {
        UIManager.put("nimbusBase", new Color(140, 103, 59));
        UIManager.put("nimbusBlueGrey", new Color(190, 189, 170));
        UIManager.put("control", new Color(221, 223, 212));
    }

    private void setNimbusGreen() {
        UIManager.put("nimbusBase", new Color(59, 140, 47));
        UIManager.put("nimbusBlueGrey", new Color(170, 190, 184));
        UIManager.put("control", new Color(214, 223, 220));
    }

    public static void main(String[] args) {
        new Program().run();
    }

    /*
    private void setLookAndFeelCustomized() {
        try {

            //com.jtattoo.plaf.acryl.AcrylLookAndFeel
            //com.jtattoo.plaf.texture.TextureLookAndFeel
            //com.jtattoo.plaf.smart.SmartLookAndFeel
            //com.jtattoo.plaf.noire.NoireLookAndFeel
            //com.jtattoo.plaf.mint.MintLookAndFeel
            //com.jtattoo.plaf.mcwin.McWinLookAndFeel
            //com.jtattoo.plaf.luna.LunaLookAndFeel
            //com.jtattoo.plaf.hifi.HiFiLookAndFeel
            //com.jtattoo.plaf.graphite.GraphiteLookAndFeel
            //com.jtattoo.plaf.fast.FastLookAndFeel
            //com.jtattoo.plaf.bernstein.BernsteinLookAndFeel
            //com.jtattoo.plaf.aluminium.AluminiumLookAndFeel
            //com.jtattoo.plaf.aero.AeroLookAndFeel
            //com.jtattoo.plaf.acryl.AcrylLookAndFeel
            UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
     */
    
    private void setLookAndFeelSystem() {
        if (System.getProperty("os.name").equals("Mac OS X")) {
            setQuaquaLookAndFeel();
            //setSeaglasslookandfeel();
        } else {
            setSeaglasslookandfeel();
        }
    }

    private void setSeaglasslookandfeel() {
        try {
            UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
    }
    
    private void setQuaquaLookAndFeel() {
        try {
            System.setProperty("apple.laf.useScreenMenuBar", "true");
            System.setProperty("apple.awt.brushMetalLook", "true");
            System.setProperty("Quaqua.selectionStyle", "dark");
            System.setProperty("apple.awt.brushMetalLook", "true");
            UIManager.setLookAndFeel("ch.randelshofer.quaqua.snow_leopard.Quaqua16SnowLeopardLookAndFeel");
            //UIManager.setLookAndFeel(ch.randelshofer.quaqua.QuaquaManager.getLookAndFeel());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
        
    }
    
}
