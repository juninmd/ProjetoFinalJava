package br.fatecfranca.view;

import br.fatecfranca.controller.MatriculaController;
import br.fatecfranca.dao.fatec_alunoDao;
import br.fatecfranca.dao.fatec_cursoDao;
import br.fatecfranca.dao.fatec_disciplina_professorDao;
import br.fatecfranca.model.fatec_aluno;
import br.fatecfranca.model.fatec_curso;
import br.fatecfranca.model.fatec_disciplina_professor;
import br.fatecfranca.model.fatec_matricula;
import br.fatecfranca.validate.ValidateMatricula;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author aluno
 */
public class CadastroMatricula extends javax.swing.JFrame {

    fatec_matricula matricula = new fatec_matricula();
    private List<fatec_aluno> alunos;
    private List<fatec_curso> cursos;

    private int retornaIndiceAluno(int idAluno) {
        int retorno = 0;
        for (int i = 0; i < ddlAlunos.getModel().getSize(); i++) {

            if (ddlAlunos.getModel().getElementAt(i).toString().split("-")[0].trim().equals("")) {
                continue;
            }

            int oi = Integer.parseInt(ddlAlunos.getModel().getElementAt(i).toString().split("-")[0].trim());
            if (oi == idAluno) {
                return i;
            }
        }
        return retorno;
    }

    private int retornaIndiceCurso(int idCurso) {
        int retorno = 0;
        for (int i = 0; i < ddlCurso.getModel().getSize(); i++) {

            if (ddlCurso.getModel().getElementAt(i).toString().split("-")[0].trim().equals("")) {
                continue;
            }

            int oi = Integer.parseInt(ddlCurso.getModel().getElementAt(i).toString().split("-")[0].trim());
            if (oi == idCurso) {
                return i;
            }
        }
        return retorno;
    }

    public void setMatricula(fatec_matricula matricula) {
        this.matricula = matricula;
        Alimenta();
    }

    private void Alimenta() {
        dtMatricula.setText(matricula.getDtmatricula());

        ddlCurso.setSelectedIndex(retornaIndiceCurso(matricula.getIdcurso()));
        ddlAlunos.setSelectedIndex(retornaIndiceAluno(matricula.getIdaluno()));
        ddlperiodo.setSelectedItem(matricula.getPeriodo());

        jButton1.setText("Atualizar");
        jLabel5.setText("Atualizar Professor");
    }

    /**
     * Creates new form CadastroAluno
     */
    public CadastroMatricula() throws Exception {
        initComponents();
        alunos = new fatec_alunoDao().GetAll();
        cursos = new fatec_cursoDao().GetAll();

        if (alunos.size() <= 0) {
            JOptionPane.showMessageDialog(null, "Cadastre primeiro alguns alunos!!");
            this.hide();
            return;
        }

        if (cursos.size() <= 0) {
            JOptionPane.showMessageDialog(null, "Cadastre primeiro alguns curso!!");
            this.hide();
            return;
        }

        for (int i = 0; i < alunos.size(); i++) {
            ddlAlunos.addItem(alunos.get(i).getCodigo() + " - " + alunos.get(i).getNome());
        }

        for (int i = 0; i < cursos.size(); i++) {
            ddlCurso.addItem(cursos.get(i).getCodigo() + " - " + cursos.get(i).getNome());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ddlAlunos = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        ddlCurso = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        dtMatricula = new javax.swing.JFormattedTextField();
        ddlperiodo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Aluno");

        jLabel4.setText("Curso");

        ddlAlunos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        ddlAlunos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ddlAlunosActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 255));
        jLabel5.setText("Tela de Cadastro de Matricula");

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

        ddlCurso.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));

        jLabel2.setText("Data da Matrícula:");

        jLabel7.setText("Período:");

        try {
            dtMatricula.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        // Código que adiciona o componente ao contêiner pai - não mostrado aqui
        dtMatricula.setText("##/##/####");

        ddlperiodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Matutino", "Noturno" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(jLabel5)
                .addGap(0, 175, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ddlAlunos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ddlCurso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(63, 63, 63)
                                .addComponent(jButton1))
                            .addComponent(ddlperiodo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ddlAlunos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ddlCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(dtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ddlperiodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
    if (!new ValidateMatricula().Validate(ddlAlunos.getSelectedItem().toString().trim().equals(""), ddlCurso.getSelectedItem().toString().trim().equals(""), dtMatricula.getText(), ddlperiodo.getSelectedItem().toString().trim().equals(""))) {
        return;
    }
    matricula.setDtmatricula(dtMatricula.getText());
    matricula.setIdaluno(Integer.parseInt(ddlAlunos.getSelectedItem().toString().split("-")[0].trim()));
    matricula.setIdcurso(Integer.parseInt(ddlCurso.getSelectedItem().toString().split("-")[0].trim()));
    matricula.setPeriodo(ddlperiodo.getSelectedItem().toString());

    // atribui os valores do usuário
    // view acessa o controller e recebe o resultado
    MatriculaController matriculaController = new MatriculaController();
    try {
        if (matricula.getCodigo() == 0) {
            matriculaController.Add(matricula);
            JOptionPane.showMessageDialog(null, "Inserção com sucesso");
        } else {
            matriculaController.Update(matricula);
            JOptionPane.showMessageDialog(null, "Atualização com sucesso");
        }

        this.hide();
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Erro ao inserir aluno");
    }
}//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.hide();              // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void ddlAlunosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ddlAlunosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ddlAlunosActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroMatricula.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroMatricula.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroMatricula.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroMatricula.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    new CadastroMatricula().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(CadastroMatricula.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox ddlAlunos;
    private javax.swing.JComboBox ddlCurso;
    private javax.swing.JComboBox<String> ddlperiodo;
    private javax.swing.JFormattedTextField dtMatricula;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
