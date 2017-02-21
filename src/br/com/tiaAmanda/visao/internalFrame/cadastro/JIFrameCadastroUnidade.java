package br.com.tiaAmanda.visao.internalFrame.cadastro;

public class JIFrameCadastroUnidade extends JInternalFramePattern {

    public JIFrameCadastroUnidade() {
        initComponents();
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
        jScrollPane_produtos = new javax.swing.JScrollPane();
        jTable_produtos = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jlbl_produto = new javax.swing.JLabel();
        jTextField_cd_unidade = new javax.swing.JTextField();
        jTextField_ds_unidade = new javax.swing.JTextField();
        jLabel_descrição = new javax.swing.JLabel();
        jCheckBox_situacao = new javax.swing.JCheckBox();

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

        jScrollPane_produtos.setViewportView(jTable_produtos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane_produtos, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane_produtos, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel_principal.add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jlbl_produto.setText("CD Unidade");

        jLabel_descrição.setText("Descrição");

        jCheckBox_situacao.setText("Situação");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField_cd_unidade, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbl_produto, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_descrição)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jTextField_ds_unidade, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBox_situacao)))
                .addContainerGap(157, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbl_produto)
                    .addComponent(jLabel_descrição))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_cd_unidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_ds_unidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox_situacao))
                .addContainerGap(20, Short.MAX_VALUE))
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
    private javax.swing.JCheckBox jCheckBox_situacao;
    private javax.swing.JLabel jLabel_descrição;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel_principal;
    private javax.swing.JScrollPane jScrollPane_produtos;
    private javax.swing.JTable jTable_produtos;
    private javax.swing.JTextField jTextField_cd_unidade;
    private javax.swing.JTextField jTextField_ds_unidade;
    private javax.swing.JToolBar jToolBar_botoes;
    private javax.swing.JLabel jlbl_produto;
    // End of variables declaration//GEN-END:variables

}
