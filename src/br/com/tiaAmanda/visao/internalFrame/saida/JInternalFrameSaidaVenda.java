package br.com.tiaAmanda.visao.internalFrame.saida;

import br.com.tiaAmanda.controle.JIFrameSaidaVendaControl;
import br.com.tiaAmanda.visao.internalFrame.cadastro.JInternalFramePattern;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class JInternalFrameSaidaVenda extends JInternalFramePattern {

    private final JIFrameSaidaVendaControl control;
    
    public JInternalFrameSaidaVenda() {
        initComponents();
        desabilitarComponentes();
        adicionarCursorComponentes();
        jScrollPane_vendas.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jTable_vendas.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTable_vendas.getTableHeader().setReorderingAllowed(false);
        control = new JIFrameSaidaVendaControl(this);
        setTamanhoColunas();
    }

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
        jScrollPane_vendas = new javax.swing.JScrollPane();
        jTable_vendas = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jlbl_cdBarras = new javax.swing.JLabel();
        jTextField_cd_barras = new javax.swing.JTextField();
        jTextField_ds_produto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField_dsCliente = new javax.swing.JTextField();
        jFormattedTextField_data = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jComboBox_formaPagamento = new javax.swing.JComboBox<>();
        jTextField_valor = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField_nr_venda = new javax.swing.JTextField();

        jPanel_principal.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.BorderLayout());

        jToolBar_botoes.setRollover(true);

        jButton_novo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/tiaAmanda/modelo/resources/img/jButton/novo-64px.png"))); // NOI18N
        jButton_novo.setText("Novo");
        jButton_novo.setFocusable(false);
        jButton_novo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_novo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar_botoes.add(jButton_novo);

        jButton_salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/tiaAmanda/modelo/resources/img/jButton/save-64px.png"))); // NOI18N
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

        jTable_vendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane_vendas.setViewportView(jTable_vendas);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane_vendas, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane_vendas, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel_principal.add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jlbl_cdBarras.setText("CD Barras");

        jTextField_ds_produto.setBackground(new java.awt.Color(204, 255, 255));

        jLabel1.setText("Data");

        jLabel2.setText("Produto");

        jLabel3.setText("Cliente");

        jTextField_dsCliente.setBackground(new java.awt.Color(204, 255, 255));

        jLabel4.setText("Forma de pagamento");

        jLabel6.setText("Valor");

        jLabel5.setText("Nr Venda");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFormattedTextField_data, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jComboBox_formaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField_nr_venda))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jlbl_cdBarras)
                                .addComponent(jTextField_cd_barras, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jTextField_ds_produto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextField_dsCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addComponent(jTextField_valor))
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField_nr_venda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbl_cdBarras)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_cd_barras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_ds_produto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_dsCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextField_data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_formaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_principal.add(jPanel3, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel_principal, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_desfazer;
    private javax.swing.JButton jButton_excluir;
    private javax.swing.JButton jButton_novo;
    private javax.swing.JButton jButton_salvar;
    private javax.swing.JComboBox<String> jComboBox_formaPagamento;
    private javax.swing.JFormattedTextField jFormattedTextField_data;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel_principal;
    private javax.swing.JScrollPane jScrollPane_vendas;
    private javax.swing.JTable jTable_vendas;
    private javax.swing.JTextField jTextField_cd_barras;
    private javax.swing.JTextField jTextField_dsCliente;
    private javax.swing.JTextField jTextField_ds_produto;
    private javax.swing.JTextField jTextField_nr_venda;
    private javax.swing.JTextField jTextField_valor;
    private javax.swing.JToolBar jToolBar_botoes;
    private javax.swing.JLabel jlbl_cdBarras;
    // End of variables declaration//GEN-END:variables

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

    public JComboBox<String> getjComboBox_formaPagamento() {
        return jComboBox_formaPagamento;
    }

    public JFormattedTextField getjFormattedTextField_data() {
        return jFormattedTextField_data;
    }

    public JScrollPane getjScrollPane_vendas() {
        return jScrollPane_vendas;
    }

    public JTable getjTable_vendas() {
        return jTable_vendas;
    }

    public JTextField getjTextField_cd_barras() {
        return jTextField_cd_barras;
    }

    public JTextField getjTextField_dsCliente() {
        return jTextField_dsCliente;
    }

    public JTextField getjTextField_ds_produto() {
        return jTextField_ds_produto;
    }

    public JTextField getjTextField_nr_venda() {
        return jTextField_nr_venda;
    }

    public JTextField getjTextField_valor() {
        return jTextField_valor;
    }

    private void desabilitarComponentes() {
        jTextField_dsCliente.setEditable(false);
        jTextField_ds_produto.setEditable(false);
        jTextField_nr_venda.setEditable(false);
        jTextField_cd_barras.setEnabled(false);
        jTextField_dsCliente.setEnabled(false);
        jTextField_ds_produto.setEnabled(false);
        jTextField_nr_venda.setEnabled(false);
        jTextField_valor.setEnabled(false);
        jFormattedTextField_data.setEnabled(false);
        jComboBox_formaPagamento.setEnabled(false);
        jButton_salvar.setEnabled(false);
        jButton_desfazer.setEnabled(false);
        jButton_excluir.setEnabled(false);
    }

    private void adicionarCursorComponentes() {
        jButton_novo.setCursor(handCursor);
        jButton_salvar.setCursor(handCursor);
        jButton_desfazer.setCursor(handCursor);
        jButton_excluir.setCursor(handCursor);
        jTextField_dsCliente.setCursor(handCursor);
        jTextField_ds_produto.setCursor(handCursor);
        jComboBox_formaPagamento.setCursor(handCursor);
        jScrollPane_vendas.setCursor(handCursor);
    }

    private void setTamanhoColunas() {
        int i = 0;
        jTable_vendas.getColumnModel().getColumn(i++).setPreferredWidth(70);
        jTable_vendas.getColumnModel().getColumn(i++).setPreferredWidth(150);
        jTable_vendas.getColumnModel().getColumn(i++).setPreferredWidth(200);
        jTable_vendas.getColumnModel().getColumn(i++).setPreferredWidth(100);
        jTable_vendas.getColumnModel().getColumn(i++).setPreferredWidth(150);
        jTable_vendas.getColumnModel().getColumn(i++).setPreferredWidth(100);
    }
    
}
