package br.com.tiaAmanda.controle;

import br.com.tiaAmanda.modelo.bean.PessoaFisica;
import br.com.tiaAmanda.modelo.bean.dao.PessoaFisicaDAO;
import br.com.tiaAmanda.modelo.bean.dao.factory.PostgresConnectionFactory;
import br.com.tiaAmanda.modelo.bean.exception.CamposObrigatoriosNaoPreenchidosException;
import br.com.tiaAmanda.modelo.tableModels.TableModelPessoaFisica;
import br.com.tiaAmanda.visao.dialog.JDialogEscolhaCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

public class JDialogEscolhaClienteControl extends Control implements ActionListener, MouseListener, WindowListener {

    private final JDialogEscolhaCliente dialog;
    private final PessoaFisicaDAO dao;
    private final ListSelectionModel lsm;
    private final TableModelPessoaFisica tmCliente;
    private List<PessoaFisica> clientes;
    private final JIFrameSaidaVendaControl jIFrameSaidaVendaControl;

    public JDialogEscolhaClienteControl(JDialogEscolhaCliente dialog, JIFrameSaidaVendaControl jIFrameSaidaVendaControl) {
        this.dialog = dialog;
        connectionFactory = new PostgresConnectionFactory();
        dao = new PessoaFisicaDAO();
        lsm = dialog.getjTable_clientes().getSelectionModel();
        dialog.getjTable_clientes().setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tmCliente = new TableModelPessoaFisica();
        dialog.getjTable_clientes().setModel(tmCliente);
        addActions();
        listarAll();
        setTamanhoColunas();
        this.jIFrameSaidaVendaControl = jIFrameSaidaVendaControl;
    }

    private void listarAll() {
        try {
            if (dialog.getjTable_clientes().getRowCount() > 0) {
                tmCliente.limpar();
            }
            beginTransaction();
            clientes = dao.getAll(connection);
            endTransaction();
            if (!clientes.isEmpty()) {
                tmCliente.addListaDePessoas(clientes);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    "Erro ao listar clientes", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addActions() {
        dialog.getjButton_pesquisa().addActionListener(this);
        dialog.addWindowListener(this);
        dialog.getjTable_clientes().addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == dialog.getjButton_pesquisa()) {
            btnPesquisaAction();
        }
    }

    private void btnPesquisaAction() {
        try {
            if (dialog.getjTable_clientes().getRowCount() > 0) {
                tmCliente.limpar();
            }
            beginTransaction();
            clientes = dao.getAllWithName(connection, dialog.getjTextField_pesquisa().getText());
            System.out.println(dialog.getjTable_clientes().getRowCount());
            endTransaction();
            tmCliente.addListaDePessoas(clientes);
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    "Erro ao tentar realizar pesquisa",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == dialog.getjTable_clientes() && e.getClickCount() > 1) {
            setCliente();
            dialog.dispose();
        }

    }

    private void setCliente() {
        PessoaFisica cliente = tmCliente.getPessoaFisica(dialog.getjTable_clientes().getSelectedRow());
        jIFrameSaidaVendaControl.setCliente(cliente);
    }

    @Override
    public void windowClosing(WindowEvent e) {
        if (dialog.getjTable_clientes().getSelectedRow() > -1) {
            setCliente();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    @Override
    protected void validarCampos() throws CamposObrigatoriosNaoPreenchidosException {
    }

    private void setTamanhoColunas() {
        int i = 0;
        dialog.getjTable_clientes().getColumnModel().getColumn(i++).setPreferredWidth(50);
        dialog.getjTable_clientes().getColumnModel().getColumn(i++).setPreferredWidth(200);
        dialog.getjTable_clientes().getColumnModel().getColumn(i++).setPreferredWidth(110);
        dialog.getjTable_clientes().getColumnModel().getColumn(i++).setPreferredWidth(70);
        dialog.getjTable_clientes().getColumnModel().getColumn(i++).setPreferredWidth(200);
        dialog.getjTable_clientes().getColumnModel().getColumn(i++).setPreferredWidth(70);
        dialog.getjTable_clientes().getColumnModel().getColumn(i++).setPreferredWidth(200);
        dialog.getjTable_clientes().getColumnModel().getColumn(i++).setPreferredWidth(200);
        dialog.getjTable_clientes().getColumnModel().getColumn(i++).setPreferredWidth(500);
    }
    
}
