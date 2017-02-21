package br.com.tiaAmanda.visao.internalFrame.cadastro;

import java.awt.Cursor;
import javax.swing.JInternalFrame;

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
    
}
