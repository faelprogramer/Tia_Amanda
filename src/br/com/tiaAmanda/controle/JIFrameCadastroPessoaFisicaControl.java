package br.com.tiaAmanda.controle;

import br.com.tiaAmanda.modelo.bean.PessoaFisica;
import br.com.tiaAmanda.modelo.tableModels.TableModelPessoaFisica;
import br.com.tiaAmanda.modelo.bean.dao.PessoaFisicaDAO;
import br.com.tiaAmanda.modelo.bean.dao.factory.PostgresConnectionFactory;
import br.com.tiaAmanda.modelo.exception.CamposObrigatoriosNaoPreenchidosException;
import br.com.tiaAmanda.visao.internalFrame.cadastro.JIFrameCadastroPessoaFisica;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JIFrameCadastroPessoaFisicaControl extends Control implements ActionListener, KeyListener, ListSelectionListener, InternalFrameListener {

    private final JIFrameCadastroPessoaFisica frame;
    private final PessoaFisicaDAO dao;
    private final ListSelectionModel lsm;
    private final TableModelPessoaFisica tmPessoaFisica;
    private List<PessoaFisica> pessoas;

    public JIFrameCadastroPessoaFisicaControl(JIFrameCadastroPessoaFisica jIFrame) {
        frame = jIFrame;
        connectionFactory = new PostgresConnectionFactory();
        dao = new PessoaFisicaDAO();
        lsm = frame.getjTable_pessoas().getSelectionModel();
        frame.getjTable_pessoas().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tmPessoaFisica = new TableModelPessoaFisica();
        frame.getjTable_pessoas().setModel(tmPessoaFisica);
        addActions();
    }

    private void addActions() {
        frame.getjButton_novo().addActionListener(this);
        frame.getjButton_salvar().addActionListener(this);
        frame.getjButton_desfazer().addActionListener(this);
        frame.getjButton_excluir().addActionListener(this);

        frame.getjTextField_bairro().addKeyListener(this);
        frame.getjTextField_cdPessoaFisica().addKeyListener(this);
        frame.getjTextField_complemento().addKeyListener(this);
        frame.getjTextField_endereco().addKeyListener(this);
        frame.getjTextField_nmPessoaFisica().addKeyListener(this);
        frame.getjTextField_numero().addKeyListener(this);
        frame.getjTextPane_observacao().addKeyListener(this);
        frame.getjFormattedTextField_dsTelefone().addKeyListener(this);
        frame.getjTextField_qtdItensCartaoFidelidade().addKeyListener(this);
        lsm.addListSelectionListener(this);
        frame.addInternalFrameListener(this);
        frame.getjButton_pesquisar().addActionListener(this);
        frame.getjTextField_pesquisa().addKeyListener(this);
    }

    public void btnNovoAction() {
        limparCampos();
        habilitarComponentesNovo();
        frame.getjTextField_qtdItensCartaoFidelidade().setText("0");
        frame.getjTextField_nmPessoaFisica().requestFocus();
        try {
            setNovoCdPessoaFisica();
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage(),
                    "Erro ao recuperar o próximo código da pessoa.",
                    JOptionPane.ERROR_MESSAGE);
        }
        listarAll();
    }

    public void btnSalvarAction() {
        try {
            validarCampos();
            beginTransaction();
            dao.save(connection, getPessoaFisicaFromView());
            endTransaction();
        } catch (SQLException | ClassNotFoundException | CamposObrigatoriosNaoPreenchidosException ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage(), "Erro ao salvar cadastro",
                    JOptionPane.ERROR_MESSAGE);
        }
        habilitarComponentesSalvar();
        listarAll();
    }

    public void btnDesfazerAction() {
        habilitarComponentesDesfazer();
        limparCampos();
        habilitarComponentes(false, frame.getjTextField_bairro(),
                frame.getjTextField_complemento(), frame.getjTextField_endereco(),
                frame.getjTextField_nmPessoaFisica(), frame.getjTextField_numero(),
                frame.getjFormattedTextField_dsTelefone(), frame.getjTextPane_observacao(),
                frame.getjTextField_qtdItensCartaoFidelidade());
    }

    public void btnExcluirAction() {
        int opcao = JOptionPane.showConfirmDialog(frame, "Confirma exclusão do cadastro?",
                "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (opcao == JOptionPane.OK_OPTION) {
            try {
                beginTransaction();
                dao.delete(connection, getPessoaFisicaFromView());
                endTransaction();
            } catch (SQLException | ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(frame, ex.getMessage(), "Erro ao excluir cadastro",
                        JOptionPane.ERROR_MESSAGE);
            }
            limparCampos();
            habilitarComponentesExcluir();
            frame.getjTable_pessoas().getSelectionModel().clearSelection();
            listarAll();
        }
        frame.getjTable_pessoas().clearSelection();
        habilitarComponentesExcluir();
    }

    private void btnPesquisarAction() {
        try {
            if (frame.getjTable_pessoas().getRowCount() > 0) {
                tmPessoaFisica.limpar();
            }
            beginTransaction();
            pessoas = dao.getPessoasPorNome(connection, frame.getjTextField_pesquisa().getText());
            endTransaction();
            if (!pessoas.isEmpty()) {
                tmPessoaFisica.addListaDePessoas(pessoas);
            } else {
                System.err.println("Sem cadastros de pessoas");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage(),
                    "Erro ao listar pessoas", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void listarAll() {
        try {
            if (frame.getjTable_pessoas().getRowCount() > 0) {
                tmPessoaFisica.limpar();
            }
            beginTransaction();
            pessoas = dao.getAll(connection);
            endTransaction();
            if (!pessoas.isEmpty()) {
                tmPessoaFisica.addListaDePessoas(pessoas);
            } else {
                System.err.println("Sem cadastros de pessoas no banco");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage(),
                    "Erro ao listar pessoas", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setNovoCdPessoaFisica() throws SQLException, ClassNotFoundException {
        String proxCod;
        beginTransaction();
        proxCod = String.valueOf(dao.getProxSequence(connection));
        frame.getjTextField_cdPessoaFisica().setText(proxCod);
        endTransaction();
    }

    private PessoaFisica getPessoaFisicaFromView() {
        PessoaFisica p = new PessoaFisica();
        p.setCd_pessoa_fisica(Integer.valueOf(frame.getjTextField_cdPessoaFisica().getText()));
        p.setDs_bairro(frame.getjTextField_bairro().getText());
        p.setDs_complemento(frame.getjTextField_complemento().getText());
        p.setDs_endereco(frame.getjTextField_endereco().getText());
        p.setNr_endereco(frame.getjTextField_numero().getText());
        p.setDs_observacao(frame.getjTextPane_observacao().getText());
        p.setDs_telefone(frame.getjFormattedTextField_dsTelefone().getText());
        p.setNm_pessoa_fisica(frame.getjTextField_nmPessoaFisica().getText());
        p.setNr_compra_fidelidade(Integer.valueOf(frame.getjTextField_qtdItensCartaoFidelidade().getText()));
        return p;
    }

    private void limparCampos() {
        limparJTextfields(frame.getjTextField_bairro(),
                frame.getjTextField_cdPessoaFisica(),
                frame.getjTextField_complemento(),
                frame.getjTextField_endereco(),
                frame.getjTextField_nmPessoaFisica(),
                frame.getjTextField_numero(),
                frame.getjTextField_qtdItensCartaoFidelidade());
        frame.getjFormattedTextField_dsTelefone().setText("");
        frame.getjTextPane_observacao().setText("");
    }

    private void habilitarComponentesNovo() {
        habilitarComponentes(false, frame.getjButton_novo());
        habilitarComponentes(true, frame.getjButton_salvar(),
                frame.getjButton_desfazer(),
                frame.getjTextField_bairro(), frame.getjTextField_complemento(),
                frame.getjTextField_endereco(), frame.getjTextField_nmPessoaFisica(),
                frame.getjTextField_numero(),
                frame.getjFormattedTextField_dsTelefone(),
                frame.getjTextPane_observacao(),
                frame.getjTextField_qtdItensCartaoFidelidade());
    }

    private void habilitarComponentesSalvar() {
        habilitarComponentes(true, frame.getjButton_novo());
        habilitarComponentes(false, frame.getjButton_salvar(),
                frame.getjButton_desfazer(), frame.getjButton_excluir(),
                frame.getjTextField_bairro(), frame.getjTextField_complemento(),
                frame.getjTextField_endereco(), frame.getjTextField_nmPessoaFisica(),
                frame.getjTextField_numero(),
                frame.getjFormattedTextField_dsTelefone(),
                frame.getjTextPane_observacao(),
                frame.getjTextField_qtdItensCartaoFidelidade());
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
        if (!e.getValueIsAdjusting() && frame.getjTable_pessoas().getSelectedRow() >= 0) {
            instanciarPessoaNaTela();
            habilitarComponentesNovo();
            //frame.getjTextField_nmPessoaFisica().requestFocus();
        }
    }

    private void instanciarPessoaNaTela() {
        int linhaSelecionada = frame.getjTable_pessoas().getSelectedRow();
        if (linhaSelecionada >= 0) {
            PessoaFisica p = tmPessoaFisica.getPessoaFisica(linhaSelecionada);
            frame.getjTextField_cdPessoaFisica().setText(String.valueOf(p.getCd_pessoa_fisica()));
            frame.getjTextField_bairro().setText(p.getDs_bairro());
            frame.getjTextField_complemento().setText(p.getDs_complemento());
            frame.getjTextField_endereco().setText(p.getDs_endereco());
            frame.getjTextField_numero().setText(p.getNr_endereco());
            frame.getjTextPane_observacao().setText(p.getDs_observacao());
            frame.getjFormattedTextField_dsTelefone().setText(p.getDs_telefone());
            frame.getjTextField_nmPessoaFisica().setText(p.getNm_pessoa_fisica());
            frame.getjTextField_qtdItensCartaoFidelidade().setText(String.valueOf(p.getNr_compra_fidelidade()));
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
        if (e.getSource() != frame.getjTextField_pesquisa()) {
            habilitarComponentesNovo();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            btnPesquisarAction();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting() && frame.getjTable_pessoas().getSelectedRow() >= 0) {
            instanciarPessoaNaTela();
            habilitarComponentesSalvar();
            habilitarComponentes(true, frame.getjButton_excluir(),
                    frame.getjTextField_bairro(),
                    frame.getjTextField_complemento(),
                    frame.getjTextField_endereco(),
                    frame.getjTextField_nmPessoaFisica(),
                    frame.getjTextField_numero(),
                    frame.getjFormattedTextField_dsTelefone(),
                    frame.getjTextPane_observacao(),
                    frame.getjTextField_qtdItensCartaoFidelidade());
            frame.getjTextField_nmPessoaFisica().requestFocus();
        }
    }

    @Override
    protected void validarCampos() throws CamposObrigatoriosNaoPreenchidosException {
        if (frame.getjTextField_cdPessoaFisica().getText().trim().isEmpty()) {
            throw new CamposObrigatoriosNaoPreenchidosException();
        }
        if (frame.getjTextField_nmPessoaFisica().getText().trim().isEmpty()) {
            throw new CamposObrigatoriosNaoPreenchidosException();
        }
        if (frame.getjTextField_qtdItensCartaoFidelidade().getText().trim().isEmpty()) {
            throw new CamposObrigatoriosNaoPreenchidosException();
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
        listarAll();
    }

    @Override
    public void internalFrameDeactivated(InternalFrameEvent e) {

    }

}
