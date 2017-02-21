package br.com.tiaAmanda.visao.frame;

import br.com.tiaAmanda.controle.JFramePrincipalControl;
import br.com.tiaAmanda.modelo.gui.DecoratedDesktopPane;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenuItem;

public class JFramePrincipal extends JFrame implements ActionListener {

    public JFramePrincipal() {
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setSize(1024,728);
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        int height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        int width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        setSize(width, height - 50);
        //setLocationRelativeTo(null);
        setLocation(0, 0);
        decoratedDesktopPane = new DecoratedDesktopPane();
        cursorPadrao = new Cursor(Cursor.HAND_CURSOR);
        getContentPane().add(decoratedDesktopPane, BorderLayout.CENTER);
        setCursorPadrao();
        control = new JFramePrincipalControl(this);
        addActions();
    }

    private void addActions() {
        jMenuItem_arquivo_sair.addActionListener(this);
        jMenuItem_cadastro_pessoaFisica.addActionListener(this);
        jMenuItem_cadastro_produto.addActionListener(this);
        jMenuItem_entrada_compra.addActionListener(this);
        jMenuItem_saida_venda.addActionListener(this);
        jMenuItem_ajuda_sobre.addActionListener(this);
    }
    
    private void setCursorPadrao() {
        jMenu_ajuda.setCursor(cursorPadrao);
        jMenu_arquivo.setCursor(cursorPadrao);
        jMenu_cadastro.setCursor(cursorPadrao);
        jMenu_entrada.setCursor(cursorPadrao);
        jMenu_saida.setCursor(cursorPadrao);

        jMenuItem_ajuda_sobre.setCursor(cursorPadrao);
        jMenuItem_cadastro_pessoaFisica.setCursor(cursorPadrao);
        jMenuItem_cadastro_produto.setCursor(cursorPadrao);
        jMenuItem_entrada_compra.setCursor(cursorPadrao);
        jMenuItem_saida_venda.setCursor(cursorPadrao);
        jMenuItem_arquivo_sair.setCursor(cursorPadrao);
    }

    //<editor-fold defaultstate="collapsed" desc=" Generated Code ">
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar_principal = new javax.swing.JMenuBar();
        jMenu_arquivo = new javax.swing.JMenu();
        jMenuItem_arquivo_sair = new javax.swing.JMenuItem();
        jMenu_cadastro = new javax.swing.JMenu();
        jMenuItem_cadastro_pessoaFisica = new javax.swing.JMenuItem();
        jMenuItem_cadastro_produto = new javax.swing.JMenuItem();
        jMenu_entrada = new javax.swing.JMenu();
        jMenuItem_entrada_compra = new javax.swing.JMenuItem();
        jMenu_saida = new javax.swing.JMenu();
        jMenuItem_saida_venda = new javax.swing.JMenuItem();
        jMenu_ajuda = new javax.swing.JMenu();
        jMenuItem_ajuda_sobre = new javax.swing.JMenuItem();

        jMenu_arquivo.setText("Arquivo");

        jMenuItem_arquivo_sair.setText("Sair");
        jMenu_arquivo.add(jMenuItem_arquivo_sair);

        jMenuBar_principal.add(jMenu_arquivo);

        jMenu_cadastro.setText("Cadastro");

        jMenuItem_cadastro_pessoaFisica.setText("Pessoa Física");
        jMenu_cadastro.add(jMenuItem_cadastro_pessoaFisica);

        jMenuItem_cadastro_produto.setText("Produto");
        jMenu_cadastro.add(jMenuItem_cadastro_produto);

        jMenuBar_principal.add(jMenu_cadastro);

        jMenu_entrada.setText("Entrada");

        jMenuItem_entrada_compra.setText("Compra");
        jMenu_entrada.add(jMenuItem_entrada_compra);

        jMenuBar_principal.add(jMenu_entrada);

        jMenu_saida.setText("Saída");

        jMenuItem_saida_venda.setText("Venda");
        jMenu_saida.add(jMenuItem_saida_venda);

        jMenuBar_principal.add(jMenu_saida);

        jMenu_ajuda.setText("Ajuda");

        jMenuItem_ajuda_sobre.setText("Sobre");
        jMenu_ajuda.add(jMenuItem_ajuda_sobre);

        jMenuBar_principal.add(jMenu_ajuda);

        setJMenuBar(jMenuBar_principal);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Variáveis ">
    private Cursor cursorPadrao;
    private final DecoratedDesktopPane decoratedDesktopPane;
    private final JFramePrincipalControl control;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar_principal;
    private javax.swing.JMenuItem jMenuItem_ajuda_sobre;
    private javax.swing.JMenuItem jMenuItem_arquivo_sair;
    private javax.swing.JMenuItem jMenuItem_cadastro_pessoaFisica;
    private javax.swing.JMenuItem jMenuItem_cadastro_produto;
    private javax.swing.JMenuItem jMenuItem_entrada_compra;
    private javax.swing.JMenuItem jMenuItem_saida_venda;
    private javax.swing.JMenu jMenu_ajuda;
    private javax.swing.JMenu jMenu_arquivo;
    private javax.swing.JMenu jMenu_cadastro;
    private javax.swing.JMenu jMenu_entrada;
    private javax.swing.JMenu jMenu_saida;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>
    
    public DecoratedDesktopPane getDecoratedDesktopPane() {
        return decoratedDesktopPane;
    }

    public JMenuItem getjMenuItem_ajuda_sobre() {
        return jMenuItem_ajuda_sobre;
    }

    public JMenuItem getjMenuItem_cadastro_pessoaFisica() {
        return jMenuItem_cadastro_pessoaFisica;
    }

    public JMenuItem getjMenuItem_cadastro_produto() {
        return jMenuItem_cadastro_produto;
    }

    public JMenuItem getjMenuItem_entrada_compra() {
        return jMenuItem_entrada_compra;
    }

    public JMenuItem getjMenuItem_saida_venda() {
        return jMenuItem_saida_venda;
    }

    public JMenuItem getjMenuItem_arquivo_sair() {
        return jMenuItem_arquivo_sair;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        control.arquivo_sair(e);
        control.cadastro_pessoaFisica(e);
        control.cadastro_produto(e);
        control.entrada_compra(e);
        control.saida_venda(e);
        control.ajuda_sobre(e);
    }

}
