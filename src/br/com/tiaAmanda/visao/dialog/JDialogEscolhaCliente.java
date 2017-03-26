package br.com.tiaAmanda.visao.dialog;

import br.com.tiaAmanda.controle.JDialogEscolhaClienteControl;
import br.com.tiaAmanda.controle.JIFrameSaidaVendaControl;
import java.awt.Frame;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class JDialogEscolhaCliente extends JDialog {

    private final JDialogEscolhaClienteControl control;
    
    public JDialogEscolhaCliente(Frame parent, boolean modal, JInternalFrame iFrame, JIFrameSaidaVendaControl iIFrameSaidaVendaControl) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(iFrame);
        jTextField_pesquisa.requestFocus();
        getRootPane().setDefaultButton(jButton_pesquisa);
        jScrollPane_clientes.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jTable_clientes.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTable_clientes.getTableHeader().setReorderingAllowed(false);
        control = new JDialogEscolhaClienteControl(this, iIFrameSaidaVendaControl);
        setTamanhoColunas();
    }

    private void setTamanhoColunas() {
        int i = 0;
        getjTable_clientes().getColumnModel().getColumn(i++).setPreferredWidth(50);
        getjTable_clientes().getColumnModel().getColumn(i++).setPreferredWidth(200);
        getjTable_clientes().getColumnModel().getColumn(i++).setPreferredWidth(110);
        getjTable_clientes().getColumnModel().getColumn(i++).setPreferredWidth(70);
        getjTable_clientes().getColumnModel().getColumn(i++).setPreferredWidth(150);
        getjTable_clientes().getColumnModel().getColumn(i++).setPreferredWidth(70);
        getjTable_clientes().getColumnModel().getColumn(i++).setPreferredWidth(200);
        getjTable_clientes().getColumnModel().getColumn(i++).setPreferredWidth(200);
        getjTable_clientes().getColumnModel().getColumn(i++).setPreferredWidth(500);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_principal = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jComboBox1_tipoPesquisa = new javax.swing.JComboBox<>();
        jTextField_pesquisa = new javax.swing.JTextField();
        jButton_pesquisa = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane_clientes = new javax.swing.JScrollPane();
        jTable_clientes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jComboBox1_tipoPesquisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pesquisar pelo nome do cliente" }));

        jButton_pesquisa.setText("Pesquisar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox1_tipoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jComboBox1_tipoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_pesquisa))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable_clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane_clientes.setViewportView(jTable_clientes);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane_clientes, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane_clientes, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel_principalLayout = new javax.swing.GroupLayout(jPanel_principal);
        jPanel_principal.setLayout(jPanel_principalLayout);
        jPanel_principalLayout.setHorizontalGroup(
            jPanel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_principalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel_principalLayout.setVerticalGroup(
            jPanel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_principalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel_principal, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_pesquisa;
    private javax.swing.JComboBox<String> jComboBox1_tipoPesquisa;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel_principal;
    private javax.swing.JScrollPane jScrollPane_clientes;
    private javax.swing.JTable jTable_clientes;
    private javax.swing.JTextField jTextField_pesquisa;
    // End of variables declaration//GEN-END:variables

    public JButton getjButton_pesquisa() {
        return jButton_pesquisa;
    }

    public JComboBox<String> getjComboBox1_tipoPesquisa() {
        return jComboBox1_tipoPesquisa;
    }

    public JTable getjTable_clientes() {
        return jTable_clientes;
    }

    public JTextField getjTextField_pesquisa() {
        return jTextField_pesquisa;
    }
    
}
