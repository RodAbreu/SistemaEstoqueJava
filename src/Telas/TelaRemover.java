/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import DAO.IDincrement;
import DAO.ItemDAO;
import static java.lang.Integer.parseInt;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rodrigo
 */
public class TelaRemover extends javax.swing.JFrame {

    /**
     * Creates new form TelaRemover
     */
    public TelaRemover() throws SQLException, ClassNotFoundException {
        initComponents();
        bdTable();
    }

    public void bdTable() throws SQLException, ClassNotFoundException{
        setLocationRelativeTo(this);
        ItemDAO test = new ItemDAO();
        ResultSet resultado = test.listaItens();
        DefaultTableModel produtos = (DefaultTableModel) TabelaItensRemover.getModel();
        while (resultado.next()) {
            String nome = resultado.getString("nome");
            String valor = resultado.getString("valor");
            String quantidade = resultado.getString("quantidade");
            String id = resultado.getString("id_item");
            Object[] dados = {id, nome, valor, quantidade};
            produtos.addRow(dados);
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        TxtIDremove = new javax.swing.JTextField();
        ButtonRemover = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaItensRemover = new javax.swing.JTable();
        retornaRemover = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("ID");

        ButtonRemover.setText("Remover");
        ButtonRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRemoverActionPerformed(evt);
            }
        });

        TabelaItensRemover.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Valor", "Quantidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TabelaItensRemover);

        retornaRemover.setText("Voltar");
        retornaRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retornaRemoverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(TxtIDremove, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(ButtonRemover))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(retornaRemover)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtIDremove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonRemover))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(retornaRemover)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void retornaRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retornaRemoverActionPerformed
        new TelaPrincipal().setVisible(true);
        dispose();
    }//GEN-LAST:event_retornaRemoverActionPerformed

    private void ButtonRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRemoverActionPerformed
        try {
            remover();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(TelaRemover.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_ButtonRemoverActionPerformed

    public void remover() throws SQLException, ClassNotFoundException{
        IDincrement intervalo = new IDincrement();
        DefaultTableModel produtos = (DefaultTableModel) TabelaItensRemover.getModel();
        
        int IDusuario = parseInt(TxtIDremove.getText());
        if(TxtIDremove.getText()==null || TxtIDremove.getText().trim().equals("") || IDusuario>intervalo.maxID() || IDusuario<=0){
                JOptionPane.showMessageDialog(null,"Digite um ID válido!");
        }else{
            new ItemDAO().remover(IDusuario);
            intervalo.reorganizaGeral();
            produtos.removeRow(IDusuario-1);
        }
    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonRemover;
    private javax.swing.JTable TabelaItensRemover;
    private javax.swing.JTextField TxtIDremove;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton retornaRemover;
    // End of variables declaration//GEN-END:variables
}
