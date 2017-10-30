package br.com.tiaAmanda.controle;

import br.com.tiaAmanda.modelo.bean.Produto;
import br.com.tiaAmanda.modelo.bean.Unidade;
import br.com.tiaAmanda.modelo.bean.dao.ProdutoDAO;
import br.com.tiaAmanda.modelo.bean.dao.factory.PostgresConnectionFactory;
import br.com.tiaAmanda.modelo.exception.CamposObrigatoriosNaoPreenchidosException;
import br.com.tiaAmanda.modelo.tableModels.TableModelProduto;
import br.com.tiaAmanda.visao.internalFrame.cadastro.JIFrameCadastroProduto;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

public class JIFrameCadastroProdutoControl extends Control implements KeyListener {

    private final JIFrameCadastroProduto frame;
    private final ProdutoDAO dao;
    private final ListSelectionModel lsm;
    private final TableModelProduto tmProduto;
    private List<Unidade> unidades;
    private List<Produto> produtos;
    private Produto produto;

    public JIFrameCadastroProdutoControl(JIFrameCadastroProduto jIFrame) {
        frame = jIFrame;
        connectionFactory = new PostgresConnectionFactory();
        dao = new ProdutoDAO();
        lsm = frame.getjTable_produtos().getSelectionModel();
        frame.getjTable_produtos().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tmProduto = new TableModelProduto();
        frame.getjTable_produtos().setModel(tmProduto);
        addActions();
        //listarAllVendas();
        //listFormasPagamento();

    }

    @Override
    protected void validarCampos() throws CamposObrigatoriosNaoPreenchidosException {

    }

    private void addActions() {
        frame.getjButton_novo().addActionListener(e -> btnNovo());
        frame.getjButton_salvar().addActionListener(e -> btnSalvar());
        frame.getjButton_desfazer().addActionListener(e -> btnDesfazer());
        frame.getjButton_excluir().addActionListener(e -> btnExcluir());
        frame.getjTextField_cdBarras().addKeyListener(this);
    }

    private void btnNovo() {
        limparCampos();
        habilitarComponentesNovo();
        try {
            setNovoCdProduto();
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage(),
                    "Erro ao recuperar o próximo código do produto.",
                    JOptionPane.ERROR_MESSAGE);
        }
        frame.getjTextField_cdBarras().requestFocus();
        listarAllProdutos();
    }

    private void btnSalvar() {

    }

    private void btnDesfazer() {

    }

    private void btnExcluir() {

    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == frame.getjTextField_cdBarras()) {
            if (e.getKeyChar() == ' ') {
                frame.getjTextField_cdBarras().setText(frame.getjTextField_cdBarras().getText().trim().toUpperCase());
            } else {
                frame.getjTextField_cdBarras().setText(frame.getjTextField_cdBarras().getText().toUpperCase());
            }
        }
    }

    private void limparCampos() {
        limparJTextfields(frame.getjTextField_cdBarras(),
                frame.getjTextField_cd_produto(),
                frame.getjTextField_ds_produto(),
                frame.getjFormattedTextField_vl_aprazo(),
                frame.getjFormattedTextField_vl_avista());
        frame.getjComboBox_unidade().setSelectedIndex(-1);
        frame.getjCheckBox_situacao().setSelected(false);
    }

    private void habilitarComponentesNovo() {
        habilitarComponentes(false, frame.getjButton_novo());
        habilitarComponentes(true, frame.getjButton_salvar(),
                frame.getjButton_desfazer(),
                frame.getjTextField_cdBarras(), frame.getjTextField_cd_produto(),
                frame.getjTextField_ds_produto(),
                frame.getjFormattedTextField_vl_aprazo(),
                frame.getjFormattedTextField_vl_avista(),
                frame.getjComboBox_unidade(),
                frame.getjCheckBox_situacao());
    }

    private void setNovoCdProduto() throws SQLException, ClassNotFoundException {
        String proxCod;
        beginTransaction();
        proxCod = String.valueOf(dao.getProxSequence(connection));
        frame.getjTextField_cd_produto().setText(proxCod);
        endTransaction();
    }

    private void listarAllProdutos() {
        try {
            if (frame.getjTable_produtos().getRowCount() > 0) {
                tmProduto.limpar();
            }
            beginTransaction();
            produtos = dao.getAll(connection);
            endTransaction();
            if (!produtos.isEmpty()) {
                tmProduto.addListaDeProdutos(produtos);
            } else {
                System.err.println("Sem cadastros de produtos");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage(),
                    "Erro ao listar produtos", JOptionPane.ERROR_MESSAGE);
        }
    }

}
