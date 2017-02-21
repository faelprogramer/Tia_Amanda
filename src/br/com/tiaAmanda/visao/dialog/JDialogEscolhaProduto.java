package br.com.tiaAmanda.visao.dialog;

import br.com.tiaAmanda.controle.JDialogEscolhaProdutoControl;
import br.com.tiaAmanda.controle.JIFrameSaidaVendaControl;
import java.awt.Frame;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JDialogEscolhaProduto extends JDialog {

    private final JDialogEscolhaProdutoControl control;
    
    public JDialogEscolhaProduto(Frame parent, boolean modal, JInternalFrame iFrame, JIFrameSaidaVendaControl iIFrameSaidaVendaControl) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(iFrame);
        jTextField_pesquisa.requestFocus();
        getRootPane().setDefaultButton(jButton_pesquisa);
        jScrollPane_produtos.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jTable_produtos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTable_produtos.getTableHeader().setReorderingAllowed(false);
        control = new JDialogEscolhaProdutoControl(this, iIFrameSaidaVendaControl);
    }

    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_principal = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jComboBox_pesquisa = new javax.swing.JComboBox<>();
        jTextField_pesquisa = new javax.swing.JTextField();
        jButton_pesquisa = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane_produtos = new javax.swing.JScrollPane();
        jTable_produtos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jComboBox_pesquisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pesquisar pelo nome do produto" }));

        jButton_pesquisa.setText("Pesquisar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField_pesquisa)
                .addGap(18, 18, 18)
                .addComponent(jButton_pesquisa)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_pesquisa))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane_produtos.setViewportView(jTable_produtos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane_produtos, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane_produtos, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel_principalLayout = new javax.swing.GroupLayout(jPanel_principal);
        jPanel_principal.setLayout(jPanel_principalLayout);
        jPanel_principalLayout.setHorizontalGroup(
            jPanel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_principalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel_principalLayout.setVerticalGroup(
            jPanel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_principalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel_principal, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

//                JDialogEscolhaProduto dialog = new JDialogEscolhaProduto(new javax.swing.JFrame(), true);
//                public void windowClosing(java.awt.event.WindowEvent e) {

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_pesquisa;
    private javax.swing.JComboBox<String> jComboBox_pesquisa;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel_principal;
    private javax.swing.JScrollPane jScrollPane_produtos;
    private javax.swing.JTable jTable_produtos;
    private javax.swing.JTextField jTextField_pesquisa;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JButton getjButton_pesquisa() {
        return jButton_pesquisa;
    }

    public javax.swing.JComboBox<String> getjComboBox_pesquisa() {
        return jComboBox_pesquisa;
    }

    public javax.swing.JScrollPane getjScrollPane_produtos() {
        return jScrollPane_produtos;
    }

    public javax.swing.JTable getjTable_produtos() {
        return jTable_produtos;
    }

    public javax.swing.JTextField getjTextField_pesquisa() {
        return jTextField_pesquisa;
    }

}
