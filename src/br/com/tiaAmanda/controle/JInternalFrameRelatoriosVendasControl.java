package br.com.tiaAmanda.controle;

import br.com.tiaAmanda.modelo.bean.dao.factory.PostgresConnectionFactory;
import br.com.tiaAmanda.modelo.bean.dao.factory.RelatoriosDAO;
import br.com.tiaAmanda.modelo.exception.CamposObrigatoriosNaoPreenchidosException;
import br.com.tiaAmanda.visao.internalFrame.relatorios.JInternalFrameRelatoriosVendas;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

public class JInternalFrameRelatoriosVendasControl extends Control implements InternalFrameListener {

    private JInternalFrameRelatoriosVendas frame;
    private final RelatoriosDAO dao;
    
    public JInternalFrameRelatoriosVendasControl(JInternalFrameRelatoriosVendas jIFrame) {
        frame = jIFrame;
        connectionFactory = new PostgresConnectionFactory();
        dao = new RelatoriosDAO();
        frame.addInternalFrameListener(this);
    }

    @Override
    protected void validarCampos() throws CamposObrigatoriosNaoPreenchidosException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void atualizar() {
        try {
            beginTransaction();
            frame.getjTextArea_vendas().setText(dao.getResult(connection));
            endTransaction();
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage(),
                    "Erro ao consultar vendas", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @Override
    public void internalFrameOpened(InternalFrameEvent e) {
        atualizar();
    }

    @Override
    public void internalFrameClosing(InternalFrameEvent e) {
        
    }

    @Override
    public void internalFrameClosed(InternalFrameEvent e) {
        
    }

    @Override
    public void internalFrameIconified(InternalFrameEvent e) {
        
    }

    @Override
    public void internalFrameDeiconified(InternalFrameEvent e) {
        atualizar();
    }

    @Override
    public void internalFrameActivated(InternalFrameEvent e) {
        atualizar();
    }

    @Override
    public void internalFrameDeactivated(InternalFrameEvent e) {
        
    }
    
}
