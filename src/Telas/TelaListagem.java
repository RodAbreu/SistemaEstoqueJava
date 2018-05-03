package Telas;

import DAO.ItemDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rodrigo
 */
public class TelaListagem extends javax.swing.JFrame {

    public TelaListagem() throws SQLException, ClassNotFoundException {
        initComponents();
        lista();
        setLocationRelativeTo(this);
        
    }

    
    public void lista() throws SQLException, ClassNotFoundException{
        ItemDAO test = new ItemDAO();
        ResultSet resultado = test.listaItens();
        DefaultTableModel produtos = (DefaultTableModel) TabelaItens.getModel();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaItens = new javax.swing.JTable();
        voltarListagem = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TabelaItens.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TabelaItens);

        voltarListagem.setText("Voltar");
        voltarListagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarListagemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(voltarListagem)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(voltarListagem)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void voltarListagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarListagemActionPerformed
        setVisible(false);
        new TelaPrincipal().setVisible(true);
    }//GEN-LAST:event_voltarListagemActionPerformed

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelaItens;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton voltarListagem;
    // End of variables declaration//GEN-END:variables
}
