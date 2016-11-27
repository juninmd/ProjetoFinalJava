package br.fatecfranca.view;

import br.fatecfranca.controller.AlunoController;
import br.fatecfranca.controller.DisciplinaController;
import br.fatecfranca.dao.fatec_disciplinaDao;
import br.fatecfranca.dao.fatec_disciplina_professorDao;
import br.fatecfranca.dao.fatec_professorDao;
import br.fatecfranca.model.fatec_curso;
import br.fatecfranca.model.fatec_disciplina;
import br.fatecfranca.model.fatec_disciplina_professor;
import br.fatecfranca.model.fatec_professor;
import br.fatecfranca.validate.ValidateDisciplina;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author disciplina
 */
public class CadastroDisciplina extends javax.swing.JFrame {

    private List<fatec_professor> professores;
    fatec_disciplina disciplina = new fatec_disciplina();

    private int retornaIndiceProfessor(int idProfessor) {
        int retorno = 0;
        for (int i = 0; i < ddlProfessor.getModel().getSize(); i++) {

            if (ddlProfessor.getModel().getElementAt(i).split("-")[0].trim().equals("")) {
                continue;
            }

            int oi = Integer.parseInt(ddlProfessor.getModel().getElementAt(i).split("-")[0].trim());
            if (oi == idProfessor) {
                return i;
            }
        }
        return retorno;
    }

    public void setDisciplina(fatec_disciplina disciplina) throws Exception {
        this.disciplina = disciplina;
        Alimenta();
    }

    private void Alimenta() throws Exception {
        nome.setText(disciplina.getNome());

        fatec_disciplina_professor idProfessor = new fatec_disciplina_professorDao().GetById(disciplina.getCodigo());
        ddlProfessor.setSelectedIndex(retornaIndiceProfessor(idProfessor.getIdprofessor()));

        jButton1.setText("Atualizar");
        jLabel5.setText("Atualizar Curso");
    }

    /**
     * Creates new form CadastroAluno
     */
    public CadastroDisciplina() throws Exception {
        initComponents();
        professores = new fatec_professorDao().GetAll();

        if (professores.size() <= 0) {
            JOptionPane.showMessageDialog(null, "Cadastre primeiro disciplinas!!");
            this.hide();
        } else {
            for (int i = 0; i < professores.size(); i++) {
                ddlProfessor.addItem(professores.get(i).getCodigo() + " - " + professores.get(i).getNome());
            }

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        nome = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        ddlProfessor = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Nome");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 255));
        jLabel5.setText("Tela de Cadastro de Disciplina");

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setForeground(new java.awt.Color(255, 0, 102));
        jButton1.setText("Cadastrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        ddlProfessor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        jLabel2.setText("Professor");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ddlProfessor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nome))
                        .addGap(102, 102, 102))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(100, 100, 100))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(125, 125, 125))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ddlProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
    // cria um objeto da classe Aluno
    if (!new ValidateDisciplina().Validate(nome.getText(), ddlProfessor.getSelectedItem().toString().trim().equals(""))) {
        return;
    }
    // atribui os valores do usuário
    disciplina.setNome(nome.getText());

    // view acessa o controller e recebe o resultado
    DisciplinaController disciplinaController = new DisciplinaController();
    try {
        if (disciplina.getCodigo() == 0) {
            disciplinaController.Add(disciplina, Integer.parseInt(ddlProfessor.getSelectedItem().toString().split("-")[0].trim()));
            JOptionPane.showMessageDialog(null, "Inserção com sucesso");
        } else {
            disciplinaController.Update(disciplina, Integer.parseInt(ddlProfessor.getSelectedItem().toString().split("-")[0].trim()));
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
        }

        this.hide();
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Erro ao inserir disciplina");
    }
}//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.hide();              // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroDisciplina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroDisciplina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroDisciplina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroDisciplina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    new CadastroDisciplina().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(CadastroDisciplina.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> ddlProfessor;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField nome;
    // End of variables declaration//GEN-END:variables
}
