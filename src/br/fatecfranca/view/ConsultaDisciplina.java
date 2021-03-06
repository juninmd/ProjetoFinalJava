package br.fatecfranca.view;

import br.fatecfranca.controller.DisciplinaController;
import br.fatecfranca.dao.fatec_disciplinaDao;
import br.fatecfranca.model.fatec_disciplina;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ConsultaDisciplina extends javax.swing.JFrame {

    private DefaultTableModel modeloTabela;
    private ArrayList<fatec_disciplina> disciplinas;

    /**
     * Creates new form ConsultaAluno
     */
    public ConsultaDisciplina() throws Exception {
        initComponents();
        // recupera modelo da tabela
        modeloTabela = (DefaultTableModel) tabela.getModel();
        btnRemove.setEnabled(false);
        btnAtualiza.setEnabled(false);
        atualizaTabela();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btnAtualiza = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Consulta Disciplina");

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);

        jButton1.setText("Consulta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnAtualiza.setText("Atualiza");
        btnAtualiza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizaActionPerformed(evt);
            }
        });

        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        jButton2.setText("Fechar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 824, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(35, 35, 35)
                                .addComponent(jButton1)
                                .addGap(40, 40, 40)
                                .addComponent(btnAtualiza)
                                .addGap(43, 43, 43)
                                .addComponent(btnRemove)
                                .addGap(234, 234, 234))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(308, 308, 308))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnAtualiza)
                    .addComponent(btnRemove)
                    .addComponent(jButton2))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void atualizaTabela() throws Exception {
        btnRemove.setEnabled(false);
        btnAtualiza.setEnabled(false);
        DisciplinaController disciplinaController = new DisciplinaController();
        disciplinas = (ArrayList) disciplinaController.GetAll();
        // limpa a tabela
        modeloTabela.setRowCount(0);
        // alimenta tabela
        if (disciplinas == null) {
            JOptionPane.showMessageDialog(null,
                    "Problema na consulta");
        } else if (disciplinas.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Não foram encontradas disciplinas");
        } else {
            Object objetos[] = new Object[9];
            for (fatec_disciplina disciplina : disciplinas) { // para cada disciplina
                objetos[0] = disciplina.getCodigo();
                objetos[1] = disciplina.getNome();
                modeloTabela.addRow(objetos);
            }
        }
    }
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    try {
        // TODO add your handling code here:
        atualizaTabela();
    } catch (Exception ex) {
        Logger.getLogger(ConsultaDisciplina.class.getName()).log(Level.SEVERE, null, ex);
    }
}//GEN-LAST:event_jButton1ActionPerformed

private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
// TODO add your handling code here:
    btnRemove.setEnabled(true);
    btnAtualiza.setEnabled(true);
}//GEN-LAST:event_tabelaMouseClicked

private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
// TODO add your handling code here:
    int resposta
            = JOptionPane.showConfirmDialog(null, "Confirma exclusão?");

    if (resposta == JOptionPane.YES_OPTION) {
        try {
            // recupera a linha selecionada
            int linha = tabela.getSelectedRow();
            int codigo = Integer.parseInt(modeloTabela.getValueAt(linha, 0).toString());
            fatec_disciplina disciplina = new fatec_disciplina();
            disciplina.setCodigo(codigo);
            DisciplinaController disciplinaController = new DisciplinaController();
            disciplinaController.Delete(disciplina);
            JOptionPane.showMessageDialog(null, "Removeu");
            atualizaTabela();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não Removeu");
        }
    }
}//GEN-LAST:event_btnRemoveActionPerformed

private void btnAtualizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizaActionPerformed
// TODO add your handling code here:
    try {
        int linha = tabela.getSelectedRow();
        int codigo = Integer.parseInt(modeloTabela.getValueAt(linha, 0).toString());

        fatec_disciplina disciplina = new fatec_disciplinaDao().GetById(codigo);
        CadastroDisciplina form = new CadastroDisciplina();
        form.setDisciplina(disciplina);
        form.show();
    } catch (Exception ex) {
        Logger.getLogger(ConsultaAluno.class.getName()).log(Level.SEVERE, null, ex);
    }
}//GEN-LAST:event_btnAtualizaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.hide();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultaDisciplina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaDisciplina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaDisciplina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaDisciplina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    new ConsultaDisciplina().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(ConsultaDisciplina.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualiza;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
