package br.com.tiaAmanda.modelo.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

public class DecoratedDesktopPane extends JDesktopPane {

    private final String FILE_IMAGE_LIB = System.getProperty("user.dir") + "/lib/background/background.jpg";
    private final String FILE_IMAGE_PADRAO = "/br/com/tiaAmanda/modelo/resources/img/jDesktopPane/background.jpg";

    private BufferedImage bufferedImage = null;
    ImageIcon img = null;

    public DecoratedDesktopPane() {
        if (!carregarImagemLib()) {
            carregarImagemPadrao();
        }
    }

    private boolean carregarImagemLib() {
        try {
            this.bufferedImage = ImageIO.read(new File(FILE_IMAGE_LIB));
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    private void carregarImagemPadrao() {
        try {
            img = new ImageIcon(getClass().getResource(FILE_IMAGE_PADRAO));
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (bufferedImage != null) {
            setImageLib(g);
        } else {
            setImagePadrao(g);
        }
    }

    private void setImagePadrao(Graphics g) {
        BufferedImage bImg = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
        Dimension dimension = this.getSize();
        Image image = img.getImage();
        g.drawImage(img.getImage(), 0, 0, (int) dimension.getWidth(), (int) dimension.getHeight(), this);
    }

    private void setImageLib(Graphics g) {
        //BufferedImage bImg = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
        if (bufferedImage != null) {
            Dimension dimension = this.getSize();
            //int x = (int) (dimension.getWidth() - bufferedImage.getWidth(this)) / 2;
            //int y = (int) (dimension.getHeight() - bufferedImage.getHeight(this)) / 2;
            //g.drawImage(img, x, y, img.getWidth(this), img.getHeight(this), this);
            //g.drawImage(bImg, 0, 0, (int) dimension.getWidth(), (int) dimension.getHeight(), this);
            g.drawImage(bufferedImage, 0, 0, (int) dimension.getWidth(), (int) dimension.getHeight(), this);
        } else {
            g.drawString("Problema com a imagem em: " + FILE_IMAGE_LIB, 50, 50);
        }
    }

}
