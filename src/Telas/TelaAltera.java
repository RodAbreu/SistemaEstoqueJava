
package Telas;

import DAO.IDincrement;
import DAO.ItemDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static java.lang.Integer.parseInt;

public class TelaAltera extends javax.swing.JFrame {


    public TelaAltera() throws SQLException, ClassNotFoundException {
        initComponents();
        bdTable();
        setLocationRelativeTo(this);
    }

    public void bdTable() throws SQLException, ClassNotFoundException{
        setLocationRelativeTo(this);
        ItemDAO test = new ItemDAO();
        ResultSet resultado = test.listaItens();
        DefaultTableModel produtos = (DefaultTableModel) TabelaItensAltera.getModel();
        while (resultado.next()) {
            String nome = resultado.getString("nome");
            String valor = resultado.getString("valor");
            String quantidade = resultado.getString("quantidade");
            String id = resultado.getString("id_item");
            Object[] dados = {id, nome, valor, quantidade};
            produtos.addRow(dados);
        }
    }
    
    public void bdAltera() throws ClassNotFoundException, SQLException{
        setLocationRelativeTo(this);
        ItemDAO test = new ItemDAO();
        ResultSet resultado = test.listaItens();
        DefaultTableModel produtos = (DefaultTableModel) TabelaItensAltera.getModel();
        
        int quantAux;
        String nomeAux;
        //float valorAux;
        int quantUsuario = parseInt(TxtQuant.getText());
        int idUsuario = parseInt(TxtID.getText());
        float valorUsuario = parseInt(TxtValor.getText());
        
        while(resultado.next()){
            nomeAux = resultado.getString("nome");    
            quantAux = resultado.getInt("quantidade");
            //  valorAux = resultado.getFloat("valor");
            if(TxtID.getText()==null || TxtQuant.getText().trim().equals("")){
                JOptionPane.showMessageDialog(null,"Digite um ID!");
            }else{
                if(idUsuario==resultado.getInt("id_item")){
                    if(quantUsuario<0){
                        JOptionPane.showMessageDialog(null,"Quantidade inválida!");
                    }else{
                        test.remover(nomeAux);
                        new IDincrement().reorganizaGeral();
                    }
                    if(valorUsuario<0){
                        JOptionPane.showMessageDialog(null,"Valor inválido!");
                    }else{
                        test.alteraValor(idUsuario, valorUsuario);
                    }
                    break;
                }              
            }

        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        retornaAltera = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaItensAltera = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        TxtID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TxtQuant = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        TxtValor = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        retornaAltera.setText("Voltar");
        retornaAltera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retornaAlteraActionPerformed(evt);
            }
        });

        TabelaItensAltera.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Valor", "Quantidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TabelaItensAltera);

        jLabel1.setText("ID");

        TxtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtIDActionPerformed(evt);
            }
        });

        jLabel2.setText("Quantidade");

        TxtQuant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtQuantActionPerformed(evt);
            }
        });

        jButton1.setText("Remove");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Valor");

        TxtValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtValorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(retornaAltera)
                .addContainerGap(508, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(TxtID, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TxtQuant))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TxtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(28, 28, 28))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtQuant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(TxtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(retornaAltera)
                .addGap(9, 9, 9))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            bdAltera();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TelaAltera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TxtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtIDActionPerformed

    private void retornaAlteraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retornaAlteraActionPerformed
        new TelaPrincipal().setVisible(true);
        dispose();
    }//GEN-LAST:event_retornaAlteraActionPerformed

    private void TxtValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtValorActionPerformed

    private void TxtQuantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtQuantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtQuantActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelaItensAltera;
    private javax.swing.JTextField TxtID;
    private javax.swing.JTextField TxtQuant;
    private javax.swing.JTextField TxtValor;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton retornaAltera;
    // End of variables declaration//GEN-END:variables
}
