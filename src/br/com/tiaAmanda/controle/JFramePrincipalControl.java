package br.com.tiaAmanda.controle;

import br.com.tiaAmanda.visao.frame.JFramePrincipal;
import br.com.tiaAmanda.visao.internalFrame.cadastro.JIFrameCadastroPessoaFisica;
import br.com.tiaAmanda.visao.internalFrame.cadastro.JIFrameCadastroProduto;
import br.com.tiaAmanda.visao.internalFrame.entrada.JInternalFrameEntradaCompra;
import br.com.tiaAmanda.visao.dialog.JDialogAjudaSobre;
import br.com.tiaAmanda.visao.internalFrame.saida.JInternalFrameSaidaVenda;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;
import javax.swing.JMenuItem;

public class JFramePrincipalControl {

    private final JFramePrincipal framePrincipal;

    private JIFrameCadastroPessoaFisica cadastroPessoaFisica;
    private JIFrameCadastroProduto cadastroProduto;
    private JInternalFrameEntradaCompra entradaCompra;
    private JInternalFrameSaidaVenda saidaVenda;

    private JIFrameCadastroPessoaFisica getCadastroPessoaFisica() {
        if (cadastroPessoaFisica == null) {
            cadastroPessoaFisica = new JIFrameCadastroPessoaFisica();
            cadastroPessoaFisica.setSize(cadastroPessoaFisica.getWidth(), framePrincipal.getDecoratedDesktopPane().getHeight());
            int x = framePrincipal.getDecoratedDesktopPane().getWidth();
            int y = framePrincipal.getDecoratedDesktopPane().getHeight();
            cadastroPessoaFisica.setLocation((x-cadastroPessoaFisica.getWidth())/2, (y - cadastroPessoaFisica.getHeight())/2);
        }
        return cadastroPessoaFisica;
    }

    private JIFrameCadastroProduto getCadastroProduto() {
        if (cadastroProduto == null) {
            cadastroProduto = new JIFrameCadastroProduto();
        }
        return cadastroProduto;
    }

    private JInternalFrameEntradaCompra getEntradaCompra() {
        if (entradaCompra == null) {
            entradaCompra = new JInternalFrameEntradaCompra();
        }
        return entradaCompra;
    }

    private JInternalFrameSaidaVenda getSaidaVenda() {
        if (saidaVenda == null) {
            saidaVenda = new JInternalFrameSaidaVenda();
            saidaVenda.setSize(saidaVenda.getWidth(), framePrincipal.getDecoratedDesktopPane().getHeight());
            int x = framePrincipal.getDecoratedDesktopPane().getWidth();
            int y = framePrincipal.getDecoratedDesktopPane().getHeight();
            saidaVenda.setLocation((x-saidaVenda.getWidth())/2, (y - saidaVenda.getHeight())/2);
        }
        return saidaVenda;
    }

    public JFramePrincipalControl(JFramePrincipal jFramePrincipal) {
        this.framePrincipal = jFramePrincipal;
    }

    public void arquivo_sair(ActionEvent e) {
        if (e.getSource() == framePrincipal.getjMenuItem_arquivo_sair()) {
            System.exit(0);
        }
    }

    public void cadastro_pessoaFisica(ActionEvent e) {
        cadastroPessoaFisica = getCadastroPessoaFisica();
        addIFrame(e, cadastroPessoaFisica, framePrincipal.getjMenuItem_cadastro_pessoaFisica());
    }

    public void cadastro_produto(ActionEvent e) {
        cadastroProduto = getCadastroProduto();
        addIFrame(e, cadastroProduto, framePrincipal.getjMenuItem_cadastro_produto());
    }

    public void entrada_compra(ActionEvent e) {
        entradaCompra = getEntradaCompra();
        addIFrame(e, entradaCompra, framePrincipal.getjMenuItem_entrada_compra());
    }

    public void saida_venda(ActionEvent e) {
        saidaVenda = getSaidaVenda();
        addIFrame(e, saidaVenda, framePrincipal.getjMenuItem_saida_venda());
    }

    public void ajuda_sobre(ActionEvent e) {
        if (e.getSource() == framePrincipal.getjMenuItem_ajuda_sobre()) {
            new JDialogAjudaSobre(framePrincipal, true).setVisible(true);
        }
    }

    private void addIFrame(ActionEvent event, JInternalFrame iFrame, JMenuItem menuItem) {
        if (event.getSource() == menuItem) {
            framePrincipal.getDecoratedDesktopPane().remove(iFrame);
            framePrincipal.getDecoratedDesktopPane().add(iFrame);
            /*
            if (!haveIFrame(iFrame)) {
                framePrincipal.getDecoratedDesktopPane().add(iFrame);
            }
             */
            iFrame.setVisible(true);
        }
    }

}
