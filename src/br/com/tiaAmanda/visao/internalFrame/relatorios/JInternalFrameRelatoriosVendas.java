package br.com.tiaAmanda.visao.internalFrame.relatorios;

import br.com.tiaAmanda.controle.JInternalFrameRelatoriosVendasControl;
import br.com.tiaAmanda.visao.internalFrame.cadastro.JInternalFramePattern;
import javax.swing.JTextArea;

public class JInternalFrameRelatoriosVendas extends JInternalFramePattern {

    private JInternalFrameRelatoriosVendasControl control;
    
    public JInternalFrameRelatoriosVendas() {
        initComponents();
        control = new JInternalFrameRelatoriosVendasControl(this);
        jTextArea_vendas.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_vendas = new javax.swing.JTextArea();

        setTitle("Vendas por Mês");

        jTextArea_vendas.setColumns(20);
        jTextArea_vendas.setRows(5);
        jScrollPane1.setViewportView(jTextArea_vendas);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea_vendas;
    // End of variables declaration//GEN-END:variables

    public JTextArea getjTextArea_vendas() {
        return jTextArea_vendas;
    }

    public void setjTextArea_vendas(JTextArea jTextArea_vendas) {
        this.jTextArea_vendas = jTextArea_vendas;
    }

}
