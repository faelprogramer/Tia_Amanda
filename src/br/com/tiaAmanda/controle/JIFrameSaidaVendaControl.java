package br.com.tiaAmanda.controle;

import br.com.tiaAmanda.modelo.bean.FormaPagamento;
import br.com.tiaAmanda.modelo.bean.PessoaFisica;
import br.com.tiaAmanda.modelo.bean.Produto;
import br.com.tiaAmanda.modelo.bean.Venda;
import br.com.tiaAmanda.modelo.comboModels.ComboModelFormaPagamento;
import br.com.tiaAmanda.modelo.bean.dao.DAO;
import br.com.tiaAmanda.modelo.bean.dao.FormaPagamentoDAO;
import br.com.tiaAmanda.modelo.bean.dao.ProdutoDAO;
import br.com.tiaAmanda.modelo.bean.dao.VendaDAO;
import br.com.tiaAmanda.modelo.bean.dao.factory.PostgresConnectionFactory;
import br.com.tiaAmanda.modelo.bean.exception.CamposObrigatoriosNaoPreenchidosException;
import br.com.tiaAmanda.modelo.tableModels.TableModelVenda;
import br.com.tiaAmanda.visao.dialog.JDialogEscolhaCliente;
import br.com.tiaAmanda.visao.dialog.JDialogEscolhaProduto;
import br.com.tiaAmanda.visao.internalFrame.saida.JInternalFrameSaidaVenda;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JIFrameSaidaVendaControl extends Control implements ActionListener, KeyListener, ListSelectionListener, MouseListener, ItemListener, InternalFrameListener {

    private final JInternalFrameSaidaVenda frame;
    private final VendaDAO dao;
    private final ProdutoDAO pDAO;
    private final ListSelectionModel lsm;
    private final TableModelVenda tmVenda;
    private List<FormaPagamento> formasPagamento;
    private List<Venda> vendas;
    private PessoaFisica cliente;
    private Produto produto;
    private FormaPagamento formaPagamento;
    private JDialogEscolhaCliente jDialogEscolhaCliente;
    private JDialogEscolhaProduto jDialogEscolhaProduto;

    public JIFrameSaidaVendaControl(JInternalFrameSaidaVenda jIFrame) {
        frame = jIFrame;
        connectionFactory = new PostgresConnectionFactory();
        dao = new VendaDAO();
        pDAO = new ProdutoDAO();
        lsm = frame.getjTable_vendas().getSelectionModel();
        frame.getjTable_vendas().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tmVenda = new TableModelVenda();
        frame.getjTable_vendas().setModel(tmVenda);
        addActions();
        //listarAllVendas();
        //listFormasPagamento();
    }

    private void addActions() {
        frame.getjButton_novo().addActionListener(this);
        frame.getjButton_salvar().addActionListener(this);
        frame.getjButton_desfazer().addActionListener(this);
        frame.getjButton_excluir().addActionListener(this);
        frame.getjTextField_cd_barras().addKeyListener(this);
        frame.getjTextField_dsCliente().addMouseListener(this);
        frame.getjTextField_ds_produto().addMouseListener(this);
        frame.getjTextField_nr_venda().addKeyListener(this);
        frame.getjTextField_valor().addKeyListener(this);
        frame.getjComboBox_formaPagamento().addItemListener(this);
        frame.addInternalFrameListener(this);
        lsm.addListSelectionListener(this);
        frame.getjButton_pesquisar().addActionListener(this);
    }

    public void btnNovoAction() {
        limparCampos();
        habilitarComponentesNovo();
        try {
            setNovoNrVenda();
            frame.getjFormattedTextField_data().setText(DateToString(getDataAtual()));
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage(),
                    "Erro ao recuperar o próximo número da venda.",
                    JOptionPane.ERROR_MESSAGE);
        }
        frame.getjTextField_cd_barras().requestFocus();
        listarAllVendas();
    }

    public void btnSalvarAction() {
        try {
            validarCampos();
            beginTransaction();
            dao.save(connection, getVendaFromView());
            endTransaction();
        } catch (SQLException | ClassNotFoundException | ParseException | CamposObrigatoriosNaoPreenchidosException ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage(), "Erro ao salvar a venda",
                    JOptionPane.ERROR_MESSAGE);
        }
        habilitarComponentesSalvar();
        listarAllVendas();
    }

    public void btnDesfazerAction() {
        habilitarComponentesDesfazer();
        limparCampos();
        habilitarComponentes(false, frame.getjTextField_cd_barras(),
                frame.getjTextField_ds_produto(), frame.getjTextField_dsCliente(),
                frame.getjFormattedTextField_data(), frame.getjComboBox_formaPagamento(),
                frame.getjTextField_valor());
        frame.getjTable_vendas().clearSelection();
    }

    public void btnExcluirAction() {
        int opcao = JOptionPane.showConfirmDialog(frame, "Confirma exclusão da venda?",
                "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (opcao == JOptionPane.OK_OPTION) {
            try {
                beginTransaction();
                dao.delete(connection, getVendaFromView());
                endTransaction();
            } catch (SQLException | ClassNotFoundException | ParseException ex) {
                JOptionPane.showMessageDialog(frame, ex.getMessage(), "Erro ao excluir a venda",
                        JOptionPane.ERROR_MESSAGE);
            }
            limparCampos();
            habilitarComponentesExcluir();
            frame.getjTable_vendas().getSelectionModel().clearSelection();
            listarAllVendas();
        }
        frame.getjTable_vendas().clearSelection();
        habilitarComponentesExcluir();
    }
    
    private void btnPesquisarAction() {
        try {
            if (frame.getjTable_vendas().getRowCount() > 0) {
                tmVenda.limpar();
            }
            beginTransaction();
            vendas = dao.getVendasPorNomeCliente(connection, frame.getjTextField_pesquisa().getText());
            endTransaction();
            if (!vendas.isEmpty()) {
                tmVenda.addListaDeVendas(vendas);
            } else {
                System.err.println("Sem cadastros de vendas");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage(),
                    "Erro ao listar vendas", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void listarAllVendas() {
        try {
            if (frame.getjTable_vendas().getRowCount() > 0) {
                tmVenda.limpar();
            }
            beginTransaction();
            vendas = dao.getAll(connection);
            endTransaction();
            if (!vendas.isEmpty()) {
                tmVenda.addListaDeVendas(vendas);
            } else {
                System.err.println("Sem cadastros de vendas");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage(),
                    "Erro ao listar vendas", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setNovoNrVenda() throws SQLException, ClassNotFoundException {
        String proxCod;
        beginTransaction();
        proxCod = String.valueOf(dao.getProxSequence(connection));
        frame.getjTextField_nr_venda().setText(proxCod);
        endTransaction();
    }

    private Venda getVendaFromView() throws ParseException {
        Venda v = new Venda();
        v.setNr_sequencia(Integer.valueOf(frame.getjTextField_nr_venda().getText()));
        v.setProduto(produto);
        v.setPessoa_fisica(cliente);
        v.setDt_venda(StringToDate(frame.getjFormattedTextField_data().getText()));
        formaPagamento = getFormaPagamentoSelecionada();
        v.setFormaPagamento(formaPagamento);
        v.setVl_venda(new DecimalFormat("####,##").parse(frame.getjTextField_valor().getText()).floatValue());
        return v;
    }

    private void limparCampos() {
        limparJTextfields(frame.getjTextField_cd_barras(),
                frame.getjTextField_dsCliente(),
                frame.getjTextField_ds_produto(),
                frame.getjTextField_nr_venda(),
                frame.getjTextField_valor(),
                frame.getjFormattedTextField_data());
        frame.getjComboBox_formaPagamento().setSelectedIndex(-1);
    }

    private void habilitarComponentesNovo() {
        habilitarComponentes(false, frame.getjButton_novo());
        habilitarComponentes(true, frame.getjButton_salvar(),
                frame.getjButton_desfazer(),
                frame.getjTextField_cd_barras(), frame.getjTextField_dsCliente(),
                frame.getjTextField_ds_produto(), frame.getjTextField_valor(),
                frame.getjFormattedTextField_data(),
                frame.getjComboBox_formaPagamento());
    }

    private void habilitarComponentesSalvar() {
        habilitarComponentes(true, frame.getjButton_novo());
        habilitarComponentes(false, frame.getjButton_salvar(),
                frame.getjButton_desfazer(), frame.getjButton_excluir(),
                frame.getjTextField_cd_barras(), frame.getjTextField_dsCliente(),
                frame.getjTextField_ds_produto(), frame.getjTextField_valor(),
                frame.getjFormattedTextField_data(),
                frame.getjComboBox_formaPagamento());
    }

    private void habilitarComponentesDesfazer() {
        habilitarComponentes(true, frame.getjButton_novo());
        habilitarComponentes(false, frame.getjButton_salvar(),
                frame.getjButton_excluir(), frame.getjButton_desfazer());
    }

    private void habilitarComponentesExcluir() {
        habilitarComponentesSalvar();
    }

    public void tbSelecionada(ListSelectionEvent e) {
        Venda v = tmVenda.getVenda(frame.getjTable_vendas().getSelectedRow());
        instanciarVendaNaTela();
        habilitarComponentes(true, frame.getjButton_excluir(), frame.getjButton_novo(),
                frame.getjTextField_cd_barras(), frame.getjTextField_dsCliente(),
                frame.getjTextField_ds_produto(),
                frame.getjTextField_valor(),
                frame.getjFormattedTextField_data(),
                frame.getjComboBox_formaPagamento());
        frame.getjTextField_cd_barras().requestFocus();
        habilitarComponentes(false, frame.getjButton_desfazer(), frame.getjButton_salvar());
    }

    private void instanciarVendaNaTela() {
        int linhaSelecionada = frame.getjTable_vendas().getSelectedRow();
        if (linhaSelecionada >= 0) {
            Venda v = tmVenda.getVenda(linhaSelecionada);
            produto = v.getProduto();
            cliente = v.getPessoa_fisica();
            formaPagamento = v.getFormaPagamento();
            frame.getjTextField_nr_venda().setText(String.valueOf(v.getNr_sequencia()));
            frame.getjTextField_cd_barras().setText(produto.getCd_barras());
            frame.getjTextField_ds_produto().setText(produto.getDs_produto());
            frame.getjTextField_dsCliente().setText(cliente.getNm_pessoa_fisica());
            frame.getjFormattedTextField_data().setText(DateToString(v.getDt_venda()));
            frame.getjComboBox_formaPagamento().setSelectedItem(formaPagamento);
            frame.getjTextField_valor().setText(v.getTxtVl_venda());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o == frame.getjButton_novo()) {
            btnNovoAction();
        }
        if (o == frame.getjButton_salvar()) {
            btnSalvarAction();
        }
        if (o == frame.getjButton_desfazer()) {
            btnDesfazerAction();
        }
        if (o == frame.getjButton_excluir()) {
            btnExcluirAction();
        }
        if (o == frame.getjButton_pesquisar()) {
            btnPesquisarAction();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        habilitarComponentesNovo();
        if (e.getSource() == frame.getjTextField_valor()) {
            String caracteresPermitidos = "0987654321.";
            if (!caracteresPermitidos.contains(e.getKeyChar() + "") || false) {
                e.consume();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == frame.getjTextField_cd_barras()) {
            if (e.getKeyChar() == ' ') {
                frame.getjTextField_cd_barras().setText(frame.getjTextField_cd_barras().getText().trim().toUpperCase());
            } else {
                frame.getjTextField_cd_barras().setText(frame.getjTextField_cd_barras().getText().toUpperCase());
                setProdutoPorBarras();
            }
        }
    }

    private void setProdutoPorBarras() throws HeadlessException {
        try {
            beginTransaction();
            Produto p = pDAO.getProdutoByCdBarras(connection, frame.getjTextField_cd_barras().getText());
            endTransaction();
            if (p != null) {
                produto = p;
                frame.getjTextField_ds_produto().setText(produto.getDs_produto());
                frame.getjTextField_valor().setText(p.getTxtVl_avista());
            } else {
                p = null;
                frame.getjTextField_ds_produto().setText("");
                frame.getjTextField_valor().setText("");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage(),
                    "Erro ao buscar profuto por CD Barras", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting() && frame.getjTable_vendas().getSelectedRow() >= 0) {
            tbSelecionada(e);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == frame.getjTextField_dsCliente() && e.getClickCount() == 2 && frame.getjTextField_dsCliente().isEnabled()) {
            jDialogEscolhaCliente = new JDialogEscolhaCliente(null, true, frame, this);
            jDialogEscolhaCliente.setVisible(true);
        }
        if (e.getSource() == frame.getjTextField_ds_produto() && e.getClickCount() == 2 && frame.getjTextField_ds_produto().isEnabled()) {
            jDialogEscolhaProduto = new JDialogEscolhaProduto(null, true, frame, this);
            jDialogEscolhaProduto.setVisible(true);
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

    private Date getDataAtual() throws SQLException, ClassNotFoundException {
        Date dt;
        beginTransaction();
        dt = DAO.getDataServidor(connection);
        endTransaction();
        return dt;
    }

    private String DateToString(Date dt) {
        return new SimpleDateFormat("dd/MM/yyyy").format(dt);
    }

    private Date StringToDate(String dt) throws ParseException {
        return new SimpleDateFormat("dd/MM/yyyy").parse(dt);
    }

    private void listFormasPagamento() {
        try {
            beginTransaction();
            formasPagamento = new FormaPagamentoDAO().getAll(connection);
            endTransaction();
            ComboModelFormaPagamento f = new ComboModelFormaPagamento(formasPagamento);
            frame.getjComboBox_formaPagamento().setModel(f);
            frame.getjComboBox_formaPagamento().setSelectedIndex(-1);
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage(),
                    "Erro ao listar formas de pagamento", JOptionPane.ERROR_MESSAGE);
        }
    }

    private FormaPagamento getFormaPagamentoSelecionada() {
        return formasPagamento.get(frame.getjComboBox_formaPagamento().getSelectedIndex());
    }

    public void setCliente(PessoaFisica cliente) {
        this.cliente = cliente;
        frame.getjTextField_dsCliente().setText(this.cliente.getNm_pessoa_fisica());
        habilitarComponentesNovo();
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
        frame.getjTextField_ds_produto().setText(this.produto.getDs_produto());
        frame.getjTextField_cd_barras().setText(this.produto.getCd_barras());
        frame.getjTextField_valor().setText(String.valueOf(this.produto.getVl_avista()));
        habilitarComponentesNovo();
    }

    @Override
    protected void validarCampos() throws CamposObrigatoriosNaoPreenchidosException {
        if (frame.getjTextField_nr_venda().getText().trim().isEmpty()) {
            throw new CamposObrigatoriosNaoPreenchidosException();
        }
        if (produto == null || frame.getjTextField_cd_barras().getText().trim().isEmpty() || frame.getjTextField_ds_produto().getText().trim().isEmpty()) {
            throw new CamposObrigatoriosNaoPreenchidosException();
        }
        if (cliente == null || frame.getjTextField_dsCliente().getText().trim().isEmpty()) {
            throw new CamposObrigatoriosNaoPreenchidosException();
        }
        if (formaPagamento == null || frame.getjComboBox_formaPagamento().getSelectedIndex() < 0) {
            throw new CamposObrigatoriosNaoPreenchidosException();
        }
        if (frame.getjFormattedTextField_data().getText().trim().isEmpty()) {
            throw new CamposObrigatoriosNaoPreenchidosException();
        }
        if (frame.getjTextField_valor().getText().trim().equals(",")) {
            throw new CamposObrigatoriosNaoPreenchidosException();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == frame.getjComboBox_formaPagamento() && frame.getjComboBox_formaPagamento().getSelectedIndex() > -1) {
            habilitarComponentesNovo();
            formaPagamento = formasPagamento.get(frame.getjComboBox_formaPagamento().getSelectedIndex());
        }
    }

    @Override
    public void internalFrameOpened(InternalFrameEvent e) {
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
    }

    @Override
    public void internalFrameActivated(InternalFrameEvent e) {
        listarAllVendas();
        listFormasPagamento();
        frame.getjTextField_pesquisa().requestFocus();
    }

    @Override
    public void internalFrameDeactivated(InternalFrameEvent e) {
    }

}
