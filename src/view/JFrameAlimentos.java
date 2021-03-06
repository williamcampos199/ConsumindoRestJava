/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Consumes.ConsumesAlimento;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Alimento;

/**
 *
 * @author William
 */
public class JFrameAlimentos extends javax.swing.JFrame {
    List<Alimento> alimentos ;
    Alimento alimentoEditado;
    ConsumesAlimento consumesAlimento;
    
    /**
     * Creates new form JFrameAlimentos
     */
    public JFrameAlimentos() {
        initComponents();
        
        showDados();
    }
    
    
    private void showDados(){
     try{       
       consumesAlimento = new ConsumesAlimento();
       alimentos = consumesAlimento.GetAlimentos();
       DefaultTableModel model = new DefaultTableModel();
       model.addColumn("id");
       model.addColumn("nome");
       model.addColumn("calorias");
       model.addColumn("gorduras");
       model.addColumn("carboidratos");
       model.addColumn("porcao");
     
       for(Alimento a : alimentos){
           String linha [] = new String[6];
           linha[0] = a.getIdAlimento()+"";
           linha[1] = a.getNome();
           linha[2] =a.getCalorias()+"";
           linha[3] = a.getGordura()+"";
           linha[4] = a.getCarboidratos()+"";
           linha[5] = a.getPorcao();
           model.addRow(linha);
       }

       jTableAlimentos.setModel(model);
            
        }catch(Exception ex){
          System.out.println("Erro ao Alimentar tabela de Alimentos");  
        }
                
                
                
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAlimentos = new javax.swing.JTable();
        jButtonNovo = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        JButtonExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTableAlimentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableAlimentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableAlimentosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableAlimentos);

        jButtonNovo.setText("Novo");
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });

        jButtonEditar.setText("Alterar");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        JButtonExcluir.setText("Excluir");
        JButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonNovo)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonEditar)
                        .addGap(18, 18, 18)
                        .addComponent(JButtonExcluir)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNovo)
                    .addComponent(jButtonEditar)
                    .addComponent(JButtonExcluir))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        JDialogCadastrarAlimentos cadastrarAlimentos = new JDialogCadastrarAlimentos(this,true);
        cadastrarAlimentos.setVisible(true);
        
        
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jTableAlimentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAlimentosMouseClicked
       int linhaTabela = jTableAlimentos.getSelectedRow();
        if(linhaTabela > -1){
           System.out.println("Item Selecionado" + jTableAlimentos.getSelectedRow() );
           
           if(alimentos != null){
            
            alimentoEditado = alimentos.get(linhaTabela);   
            
            jButtonNovo.setEnabled(false);
           }
           
           
          
       }
        
        
    }//GEN-LAST:event_jTableAlimentosMouseClicked

    private void JButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonExcluirActionPerformed
        // TODO add your handling code here:
        
        if(alimentoEditado != null){
          int resposta =  JOptionPane.showConfirmDialog(this, "Deseja excluir o alimento","Exclusão de Alimento", JOptionPane.YES_NO_OPTION);
          if(resposta == JOptionPane.YES_OPTION){
              consumesAlimento.DeleteAlimento(alimentoEditado.getIdAlimento());
              showDados();
              alimentoEditado = null;
              
          }else{
              alimentoEditado = null;
              jTableAlimentos.clearSelection();
              
          }
            jButtonNovo.setEnabled(true); 
            
           
            
        }else{
            JOptionPane.showMessageDialog(this, "Por favor selecione um item "
                    + "para ser excluido", "Exclusão de Alimento",JOptionPane.INFORMATION_MESSAGE);
        }
        
        
    }//GEN-LAST:event_JButtonExcluirActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        // TODO add your handling code here:
        if(alimentoEditado != null){
        JDialogCadastrarAlimentos cadastrarAlimentos = new JDialogCadastrarAlimentos(this,true,alimentoEditado);
        cadastrarAlimentos.setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(this, "Por favor selecione um item "
                    + "para ser Editado", "Edição de Alimento",JOptionPane.INFORMATION_MESSAGE);
            
        }
        
        jButtonNovo.setEnabled(true); 
        showDados();
    }//GEN-LAST:event_jButtonEditarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrameAlimentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameAlimentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameAlimentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameAlimentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameAlimentos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JButtonExcluir;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableAlimentos;
    // End of variables declaration//GEN-END:variables
}
