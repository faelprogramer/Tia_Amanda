package br.com.tiaAmanda.controle;

import br.com.tiaAmanda.modelo.bean.Produto;
import br.com.tiaAmanda.modelo.bean.dao.ProdutoDAO;
import br.com.tiaAmanda.modelo.bean.dao.factory.PostgresConnectionFactory;
import br.com.tiaAmanda.modelo.bean.exception.CamposObrigatoriosNaoPreenchidosException;
import br.com.tiaAmanda.modelo.tableModels.TableModelProduto;
import br.com.tiaAmanda.visao.dialog.JDialogEscolhaProduto;
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

public class JDialogEscolhaProdutoControl extends Control implements ActionListener, MouseListener, WindowListener {

    private final JDialogEscolhaProduto dialog;
    private final ProdutoDAO dao;
    private final ListSelectionModel lsm;
    private final TableModelProduto tmProduto;
    private List<Produto> produtos;
    private final JIFrameSaidaVendaControl jIFrameSaidaVendaControl;

    public JDialogEscolhaProdutoControl(JDialogEscolhaProduto dialog, JIFrameSaidaVendaControl jIFrameSaidaVendaControl) {
        this.dialog = dialog;
        connectionFactory = new PostgresConnectionFactory();
        dao = new ProdutoDAO();
        lsm = dialog.getjTable_produtos().getSelectionModel();
        dialog.getjTable_produtos().setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tmProduto = new TableModelProduto();
        dialog.getjTable_produtos().setModel(tmProduto);
        addActions();
        listarAll();
        setTamanhoColunas();
        this.jIFrameSaidaVendaControl = jIFrameSaidaVendaControl;
    }

    private void listarAll() {
        try {
            if (dialog.getjTable_produtos().getRowCount() > 0) {
                tmProduto.limpar();
            }
            beginTransaction();
            produtos = dao.getAll(connection);
            endTransaction();
            if (!produtos.isEmpty()) {
                tmProduto.addListaDeProdutos(produtos);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    "Erro ao listar produtos", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addActions() {
        dialog.getjButton_pesquisa().addActionListener(this);
        dialog.addWindowListener(this);
        dialog.getjTable_produtos().addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == dialog.getjButton_pesquisa()) {
            btnPesquisaAction();
        }
    }

    private void btnPesquisaAction() {
        try {
            if (dialog.getjTable_produtos().getRowCount() > 0) {
                tmProduto.limpar();
            }
            beginTransaction();
            produtos = dao.getAllWithDesc(connection, dialog.getjTextField_pesquisa().getText());
            endTransaction();
            tmProduto.addListaDeProdutos(produtos);
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    "Erro ao tentar realizar pesquisa",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == dialog.getjTable_produtos() && e.getClickCount() > 1) {
            setProdutos();
            dialog.dispose();
        }

    }

    private void setProdutos() {
        Produto produto = tmProduto.getProduto(dialog.getjTable_produtos().getSelectedRow());
        jIFrameSaidaVendaControl.setProduto(produto);
    }

    @Override
    public void windowClosing(WindowEvent e) {
        if (dialog.getjTable_produtos().getSelectedRow() > -1) {
            setProdutos();
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
        dialog.getjTable_produtos().getColumnModel().getColumn(i++).setPreferredWidth(50);
        dialog.getjTable_produtos().getColumnModel().getColumn(i++).setPreferredWidth(85);
        dialog.getjTable_produtos().getColumnModel().getColumn(i++).setPreferredWidth(600);
        dialog.getjTable_produtos().getColumnModel().getColumn(i++).setPreferredWidth(60);
        dialog.getjTable_produtos().getColumnModel().getColumn(i++).setPreferredWidth(70);
        dialog.getjTable_produtos().getColumnModel().getColumn(i++).setPreferredWidth(70);
    }

}
