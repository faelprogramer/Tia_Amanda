package br.com.tiaAmanda.visao.internalFrame.cadastro;

import java.awt.Cursor;
import java.text.ParseException;
import javax.swing.JInternalFrame;
import javax.swing.text.MaskFormatter;

public abstract class JInternalFramePattern extends JInternalFrame {

    protected Cursor handCursor;

    public JInternalFramePattern() {
        setIconifiable(true);
        setClosable(true);
        handCursor = new Cursor(Cursor.HAND_CURSOR);
    }
    
    public JInternalFramePattern(int width, int heigth) {
        setIconifiable(true);
        setClosable(true);
        handCursor = new Cursor(Cursor.HAND_CURSOR);
        setSize(width, heigth);
    }
    
    protected MaskFormatter getMascaraTelefone() {
        return getMaskFormatter("(##) # ####-####");
    }
    
    protected MaskFormatter getMascaraData() {
        return getMaskFormatter("##/##/####");
    }
    
    private MaskFormatter getMaskFormatter(String mascara) {
        try {
            return new MaskFormatter(mascara);
        } catch (ParseException ex) {
        }
        return null;
    }
    
}
