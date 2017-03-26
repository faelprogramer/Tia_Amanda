package br.com.tiaAmanda.visao.internalFrame.cadastro;

import br.com.tiaAmanda.controle.JIFrameCadastroPessoaFisicaControl;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class JIFrameCadastroPessoaFisica extends JInternalFramePattern {

    private final JIFrameCadastroPessoaFisicaControl control;

    public JIFrameCadastroPessoaFisica() {
        initComponents();
        setTitle("Cadastro de pessoa física");
        desabilitarComponentes();
        adicionarCursorComponentes();
        jScrollPane_tbPessoas.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jTable_pessoas.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTable_pessoas.getTableHeader().setReorderingAllowed(false);
        control = new JIFrameCadastroPessoaFisicaControl(this);
        setTamanhoColunas();
    }

    private void desabilitarComponentes() {
        jTextField_bairro.setEnabled(false);
        jTextField_cdPessoaFisica.setEnabled(false);
        jTextField_complemento.setEnabled(false);
        jTextField_endereco.setEnabled(false);
        jTextField_nmPessoaFisica.setEnabled(false);
        jTextField_numeroEndereco.setEnabled(false);
        jTextField_qtdItensCartaoFidelidade.setEnabled(false);
        jFormattedTextField_dsTelefone.setEnabled(false);
        jTextPane_observacao.setEnabled(false);
        jButton_salvar.setEnabled(false);
        jButton_desfazer.setEnabled(false);
        jButton_excluir.setEnabled(false);
    }

    private void adicionarCursorComponentes() {
        jButton_novo.setCursor(handCursor);
        jButton_salvar.setCursor(handCursor);
        jButton_desfazer.setCursor(handCursor);
        jButton_excluir.setCursor(handCursor);
        jTable_pessoas.setCursor(handCursor);
    }

    //<editor-fold defaultstate="collapsed" desc="Generated Code">
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_botoes = new javax.swing.JPanel();
        jToolBar_botoes = new javax.swing.JToolBar();
        jButton_novo = new javax.swing.JButton();
        jButton_salvar = new javax.swing.JButton();
        jButton_desfazer = new javax.swing.JButton();
        jButton_excluir = new javax.swing.JButton();
        jPanel_pessoas = new javax.swing.JPanel();
        jScrollPane_tbPessoas = new javax.swing.JScrollPane();
        jTable_pessoas = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField_cdPessoaFisica = new javax.swing.JTextField();
        jFormattedTextField_dsTelefone = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField_qtdItensCartaoFidelidade = new javax.swing.JTextField();
        jTextField_nmPessoaFisica = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField_endereco = new javax.swing.JTextField();
        jTextField_numeroEndereco = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField_bairro = new javax.swing.JTextField();
        jTextField_complemento = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane_observacao = new javax.swing.JTextPane();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jComboBox_pesquisa = new javax.swing.JComboBox<>();
        jTextField_pesquisa = new javax.swing.JTextField();
        jButton_pesquisar = new javax.swing.JButton();

        jPanel_botoes.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        jToolBar_botoes.setRollover(true);

        jButton_novo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/tiaAmanda/modelo/resources/img/jButton/novo-64px.png"))); // NOI18N
        jButton_novo.setText("Novo");
        jButton_novo.setBorder(null);
        jButton_novo.setFocusable(false);
        jButton_novo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_novo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar_botoes.add(jButton_novo);

        jButton_salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/tiaAmanda/modelo/resources/img/jButton/save-64px.png"))); // NOI18N
        jButton_salvar.setText("Salvar");
        jButton_salvar.setBorder(null);
        jButton_salvar.setFocusable(false);
        jButton_salvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_salvar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar_botoes.add(jButton_salvar);

        jButton_desfazer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/tiaAmanda/modelo/resources/img/jButton/desfazer-64px.png"))); // NOI18N
        jButton_desfazer.setText("Desfazer");
        jButton_desfazer.setBorder(null);
        jButton_desfazer.setFocusable(false);
        jButton_desfazer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_desfazer.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar_botoes.add(jButton_desfazer);

        jButton_excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/tiaAmanda/modelo/resources/img/jButton/excluir-64px.png"))); // NOI18N
        jButton_excluir.setText("Excluir");
        jButton_excluir.setBorder(null);
        jButton_excluir.setFocusable(false);
        jButton_excluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_excluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar_botoes.add(jButton_excluir);

        jPanel_botoes.add(jToolBar_botoes);

        jPanel_pessoas.setBorder(javax.swing.BorderFactory.createTitledBorder("Clientes"));

        jTable_pessoas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane_tbPessoas.setViewportView(jTable_pessoas);

        javax.swing.GroupLayout jPanel_pessoasLayout = new javax.swing.GroupLayout(jPanel_pessoas);
        jPanel_pessoas.setLayout(jPanel_pessoasLayout);
        jPanel_pessoasLayout.setHorizontalGroup(
            jPanel_pessoasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_pessoasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane_tbPessoas)
                .addContainerGap())
        );
        jPanel_pessoasLayout.setVerticalGroup(
            jPanel_pessoasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_pessoasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane_tbPessoas, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente"));

        jLabel1.setText("CD Pessoa");

        jLabel2.setText("Nome*");

        jLabel7.setText("Cartão Fidelidade");

        jLabel8.setText("Telefone");

        jLabel3.setText("Endereço");

        jLabel4.setText("Número");

        jLabel6.setText("Bairro");

        jLabel5.setText("Complemento");

        jScrollPane1.setViewportView(jTextPane_observacao);

        jLabel9.setText("Observação");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField_numeroEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_bairro, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_complemento, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jTextField_qtdItensCartaoFidelidade, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jTextField_cdPessoaFisica, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_nmPessoaFisica, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jFormattedTextField_dsTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jTextField_endereco, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel9)
                    .addComponent(jScrollPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_cdPessoaFisica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_nmPessoaFisica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextField_dsTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_numeroEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_bairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_complemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_qtdItensCartaoFidelidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisa"));

        jComboBox_pesquisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Por nome" }));

        jButton_pesquisar.setText("Pesquisar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField_pesquisa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_pesquisar)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_pesquisar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel_botoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel_pessoas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel_botoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_pessoas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Variáveis">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_desfazer;
    private javax.swing.JButton jButton_excluir;
    private javax.swing.JButton jButton_novo;
    private javax.swing.JButton jButton_pesquisar;
    private javax.swing.JButton jButton_salvar;
    private javax.swing.JComboBox<String> jComboBox_pesquisa;
    private javax.swing.JFormattedTextField jFormattedTextField_dsTelefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel_botoes;
    private javax.swing.JPanel jPanel_pessoas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane_tbPessoas;
    private javax.swing.JTable jTable_pessoas;
    private javax.swing.JTextField jTextField_bairro;
    private javax.swing.JTextField jTextField_cdPessoaFisica;
    private javax.swing.JTextField jTextField_complemento;
    private javax.swing.JTextField jTextField_endereco;
    private javax.swing.JTextField jTextField_nmPessoaFisica;
    private javax.swing.JTextField jTextField_numeroEndereco;
    private javax.swing.JTextField jTextField_pesquisa;
    private javax.swing.JTextField jTextField_qtdItensCartaoFidelidade;
    private javax.swing.JTextPane jTextPane_observacao;
    private javax.swing.JToolBar jToolBar_botoes;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="gets">
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

    public JFormattedTextField getjFormattedTextField_dsTelefone() {
        return jFormattedTextField_dsTelefone;
    }

    public JTable getjTable_pessoas() {
        return jTable_pessoas;
    }

    public JTextField getjTextField_bairro() {
        return jTextField_bairro;
    }

    public JTextField getjTextField_cdPessoaFisica() {
        return jTextField_cdPessoaFisica;
    }

    public JTextField getjTextField_complemento() {
        return jTextField_complemento;
    }

    public JTextField getjTextField_endereco() {
        return jTextField_endereco;
    }

    public JTextField getjTextField_nmPessoaFisica() {
        return jTextField_nmPessoaFisica;
    }

    public JTextField getjTextField_numero() {
        return jTextField_numeroEndereco;
    }

    public JTextField getjTextField_qtdItensCartaoFidelidade() {
        return jTextField_qtdItensCartaoFidelidade;
    }

    public JTextPane getjTextPane_observacao() {
        return jTextPane_observacao;
    }

    public JButton getjButton_pesquisar() {
        return jButton_pesquisar;
    }

    public JComboBox<String> getjComboBox_pesquisa() {
        return jComboBox_pesquisa;
    }

    public JTextField getjTextField_pesquisa() {
        return jTextField_pesquisa;
    }

    //</editor-fold>
    
    private void setTamanhoColunas() {
        //String[] colunas = ((TableModelPessoaFisica)jTable_pessoas.getModel()).getColunas();
        int i = 0;
        jTable_pessoas.getColumnModel().getColumn(i++).setPreferredWidth(50);
        jTable_pessoas.getColumnModel().getColumn(i++).setPreferredWidth(200);
        jTable_pessoas.getColumnModel().getColumn(i++).setPreferredWidth(110);
        jTable_pessoas.getColumnModel().getColumn(i++).setPreferredWidth(70);
        jTable_pessoas.getColumnModel().getColumn(i++).setPreferredWidth(200);
        jTable_pessoas.getColumnModel().getColumn(i++).setPreferredWidth(70);
        jTable_pessoas.getColumnModel().getColumn(i++).setPreferredWidth(200);
        jTable_pessoas.getColumnModel().getColumn(i++).setPreferredWidth(200);
        jTable_pessoas.getColumnModel().getColumn(i++).setPreferredWidth(500);
    }

}
