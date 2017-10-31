package br.com.tiaAmanda.visao.internalFrame.cadastro;

import br.com.tiaAmanda.controle.JIFrameCadastroProdutoControl;
import br.com.tiaAmanda.modelo.util.JMoneyField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class JIFrameCadastroProduto extends JInternalFramePattern {

    private JIFrameCadastroProdutoControl control;
    
    public JIFrameCadastroProduto() {
        initComponents();
        setTitle("Cadastro de produtos");
        desabilitarComponentes();
        adicionarCursorComponentes();
        jScrollPane_produtos.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jTable_produtos.getTableHeader().setReorderingAllowed(false);
        control = new JIFrameCadastroProdutoControl(this);
        setTamanhoColunas();

    }

    //<editor-fold defaultstate="collapsed" desc="Generated Code">
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_principal = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jToolBar_botoes = new javax.swing.JToolBar();
        jButton_novo = new javax.swing.JButton();
        jButton_salvar = new javax.swing.JButton();
        jButton_desfazer = new javax.swing.JButton();
        jButton_excluir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane_produtos = new javax.swing.JScrollPane();
        jTable_produtos = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jlbl_produto = new javax.swing.JLabel();
        jTextField_cd_produto = new javax.swing.JTextField();
        jTextField_ds_produto = new javax.swing.JTextField();
        jComboBox_unidade = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField_cdBarras = new javax.swing.JTextField();
        jCheckBox_situacao = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jFormattedTextField_vl_avista = new javax.swing.JFormattedTextField();
        jFormattedTextField_vl_aprazo = new javax.swing.JFormattedTextField();

        jPanel_principal.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.BorderLayout());

        jToolBar_botoes.setRollover(true);

        jButton_novo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/tiaAmanda/modelo/resources/img/jButton/novo-64px.png"))); // NOI18N
        jButton_novo.setText("Novo");
        jButton_novo.setFocusable(false);
        jButton_novo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_novo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar_botoes.add(jButton_novo);

        jButton_salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/tiaAmanda/modelo/resources/img/jButton/salvar-64px.png"))); // NOI18N
        jButton_salvar.setText("Salvar");
        jButton_salvar.setFocusable(false);
        jButton_salvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_salvar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar_botoes.add(jButton_salvar);

        jButton_desfazer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/tiaAmanda/modelo/resources/img/jButton/desfazer-64px.png"))); // NOI18N
        jButton_desfazer.setText("Desfazer");
        jButton_desfazer.setFocusable(false);
        jButton_desfazer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_desfazer.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar_botoes.add(jButton_desfazer);

        jButton_excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/tiaAmanda/modelo/resources/img/jButton/excluir-64px.png"))); // NOI18N
        jButton_excluir.setText("Excluir");
        jButton_excluir.setFocusable(false);
        jButton_excluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_excluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar_botoes.add(jButton_excluir);

        jPanel2.add(jToolBar_botoes, java.awt.BorderLayout.CENTER);

        jPanel_principal.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jTable_produtos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane_produtos.setViewportView(jTable_produtos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane_produtos, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane_produtos, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel_principal.add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jlbl_produto.setText("CD Produto");

        jLabel1.setText("Unidade");

        jLabel2.setText("Descrição");

        jLabel3.setText("CD Barras");

        jCheckBox_situacao.setText("Ativo");

        jLabel4.setText("Vl a vista");

        jLabel5.setText("Vl a Prazo");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField_cdBarras)
                            .addComponent(jTextField_cd_produto, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(jlbl_produto)
                            .addComponent(jLabel4)
                            .addComponent(jFormattedTextField_vl_avista))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jFormattedTextField_vl_aprazo, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField_ds_produto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(jCheckBox_situacao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jComboBox_unidade, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbl_produto)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_cd_produto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_ds_produto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_unidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_cdBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox_situacao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextField_vl_avista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextField_vl_aprazo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_principal.add(jPanel3, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel_principal, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Variáveis">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_desfazer;
    private javax.swing.JButton jButton_excluir;
    private javax.swing.JButton jButton_novo;
    private javax.swing.JButton jButton_salvar;
    private javax.swing.JCheckBox jCheckBox_situacao;
    private javax.swing.JComboBox<String> jComboBox_unidade;
    private javax.swing.JFormattedTextField jFormattedTextField_vl_aprazo;
    private javax.swing.JFormattedTextField jFormattedTextField_vl_avista;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel_principal;
    private javax.swing.JScrollPane jScrollPane_produtos;
    private javax.swing.JTable jTable_produtos;
    private javax.swing.JTextField jTextField_cdBarras;
    private javax.swing.JTextField jTextField_cd_produto;
    private javax.swing.JTextField jTextField_ds_produto;
    private javax.swing.JToolBar jToolBar_botoes;
    private javax.swing.JLabel jlbl_produto;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>

    private void desabilitarComponentes() {
        jTextField_cdBarras.setEnabled(false);
        jTextField_cd_produto.setEnabled(false);
        jTextField_ds_produto.setEnabled(false);
        jFormattedTextField_vl_aprazo.setEnabled(false);
        jFormattedTextField_vl_avista.setEnabled(false);
        jComboBox_unidade.setEnabled(false);
        jCheckBox_situacao.setEnabled(false);
        jButton_salvar.setEnabled(false);
        jButton_desfazer.setEnabled(false);
        jButton_excluir.setEnabled(false);
    }

    private void adicionarCursorComponentes() {
        jButton_novo.setCursor(handCursor);
        jButton_salvar.setCursor(handCursor);
        jButton_desfazer.setCursor(handCursor);
        jButton_excluir.setCursor(handCursor);
        jTable_produtos.setCursor(handCursor);
    }

    private void setTamanhoColunas() {
        //String[] colunas = ((TableModelPessoaFisica)jTable_pessoas.getModel()).getColunas();
        int i = 0;
        /*
        jTable_pessoas.getColumnModel().getColumn(i++).setPreferredWidth(50);
        jTable_pessoas.getColumnModel().getColumn(i++).setPreferredWidth(200);
        jTable_pessoas.getColumnModel().getColumn(i++).setPreferredWidth(110);
        jTable_pessoas.getColumnModel().getColumn(i++).setPreferredWidth(70);
        jTable_pessoas.getColumnModel().getColumn(i++).setPreferredWidth(200);
        jTable_pessoas.getColumnModel().getColumn(i++).setPreferredWidth(70);
        jTable_pessoas.getColumnModel().getColumn(i++).setPreferredWidth(200);
        jTable_pessoas.getColumnModel().getColumn(i++).setPreferredWidth(200);
        jTable_pessoas.getColumnModel().getColumn(i++).setPreferredWidth(500);
        */
    }

    public JButton getjButton_desfazer() {
        return jButton_desfazer;
    }

    public JButton getjButton_excluir() {
        return jButton_excluir;
    }

    public JButton getjButton_novo() {
        return jButton_novo;
    }

    public JButton getjButton_salvar() {
        return jButton_salvar;
    }

    public JCheckBox getjCheckBox_situacao() {
        return jCheckBox_situacao;
    }

    public JComboBox<String> getjComboBox_unidade() {
        return jComboBox_unidade;
    }

    public JFormattedTextField getjFormattedTextField_vl_aprazo() {
        return jFormattedTextField_vl_aprazo;
    }

    public JFormattedTextField getjFormattedTextField_vl_avista() {
        return jFormattedTextField_vl_avista;
    }

    public JTable getjTable_produtos() {
        return jTable_produtos;
    }

    public JTextField getjTextField_cdBarras() {
        return jTextField_cdBarras;
    }

    public JTextField getjTextField_cd_produto() {
        return jTextField_cd_produto;
    }

    public JTextField getjTextField_ds_produto() {
        return jTextField_ds_produto;
    }

}
