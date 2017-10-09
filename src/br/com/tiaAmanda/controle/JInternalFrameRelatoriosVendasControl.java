package br.com.tiaAmanda.controle;

import br.com.tiaAmanda.modelo.bean.dao.factory.PostgresConnectionFactory;
import br.com.tiaAmanda.modelo.bean.dao.factory.RelatoriosDAO;
import br.com.tiaAmanda.modelo.exception.CamposObrigatoriosNaoPreenchidosException;
import br.com.tiaAmanda.visao.internalFrame.relatorios.JInternalFrameRelatoriosVendas;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class JInternalFrameRelatoriosVendasControl extends Control {

    private JInternalFrameRelatoriosVendas frame;
    private final RelatoriosDAO dao;
    
    public JInternalFrameRelatoriosVendasControl(JInternalFrameRelatoriosVendas jIFrame) {
        frame = jIFrame;
        connectionFactory = new PostgresConnectionFactory();
        dao = new RelatoriosDAO();
        atualizar();
        
    }

    @Override
    protected void validarCampos() throws CamposObrigatoriosNaoPreenchidosException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void atualizar() {
        try {
            beginTransaction();
            frame.getjTextArea_vendas().setText(dao.getResult(connection));
            endTransaction();
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage(),
                    "Erro ao consultar vendas", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
