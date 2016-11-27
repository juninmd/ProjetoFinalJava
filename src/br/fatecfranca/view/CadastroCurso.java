package br.fatecfranca.view;

import br.fatecfranca.controller.CursoController;
import br.fatecfranca.dao.fatec_curso_disciplinaDao;
import br.fatecfranca.dao.fatec_disciplinaDao;
import br.fatecfranca.model.fatec_curso;
import br.fatecfranca.model.fatec_curso_disciplina;
import br.fatecfranca.model.fatec_disciplina;
import br.fatecfranca.validate.ValidateCurso;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author curso
 */
public class CadastroCurso extends javax.swing.JFrame {

    private List<fatec_disciplina> disciplinas;
    fatec_curso curso = new fatec_curso();

    public void setCurso(fatec_curso curso) throws Exception {
        this.curso = curso;
        Alimenta();
    }

    private int retornaIndiceDisciplina(int idDisciplina) {
        int retorno = 0;
        for (int i = 0; i < jList2.getModel().getSize(); i++) {

            int oi = Integer.parseInt(jList2.getModel().getElementAt(i).split("-")[0].trim());
            if (oi == idDisciplina) {
                return i;
            }

        }
        return retorno;
    }

    private void Alimenta() throws Exception {
        nome.setText(curso.getNome());
        List<fatec_curso_disciplina> cursoDisciplina = new fatec_curso_disciplinaDao().GetAll(curso.getCodigo());

        List<Integer> arrayDisciplinas = new ArrayList<Integer>();
        for (int i = 0; i < cursoDisciplina.size(); i++) {
            arrayDisciplinas.add(retornaIndiceDisciplina(cursoDisciplina.get(i).getIddisciplina()));
        }
        jList2.setSelectedIndices(arrayDisciplinas.stream().mapToInt(i -> i).toArray());

        jButton1.setText("Atualizar");
        jLabel5.setText("Atualizar Curso");
    }

    /**
     * Creates new form CadastroAluno
     */
    public CadastroCurso() throws Exception {
        initComponents();
        disciplinas = new fatec_disciplinaDao().GetAll();

        if (disciplinas.size() <= 0) {
            JOptionPane.showMessageDialog(null, "Cadastre primeiro disciplinas!!");
            this.hide();
        } else {
            DefaultListModel listModel = new DefaultListModel();
            for (int i = 0; i < disciplinas.size(); i++) {
                listModel.addElement(disciplinas.get(i).getCodigo() + " - " + disciplinas.get(i).getNome());
            }
            jList2.setModel(listModel);
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
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Nome");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 255));
        jLabel5.setText("Tela de Cadastro de Curso");

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

        jLabel2.setText("Materias");

        jList2.setToolTipText("");
        jScrollPane2.setViewportView(jList2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 50, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(42, 42, 42))
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
    // cria um objeto da classe Aluno

    List<Integer> listaMaterias = new ArrayList<>();
    int[] selectedIx = this.jList2.getSelectedIndices();

    if (!new ValidateCurso().Validate(nome.getText(), selectedIx.length)) {
        return;
    }
    // atribui os valores do usuário
    curso.setNome(nome.getText());

    for (int i = 0; i < selectedIx.length; i++) {
        listaMaterias.add(Integer.parseInt(jList2.getModel().getElementAt(i).split("-")[0].trim()));
    }

    // view acessa o controller e recebe o resultado
    CursoController cursoController = new CursoController();
    try {
        if (curso.getCodigo() == 0) {
            cursoController.Add(curso, listaMaterias);
            JOptionPane.showMessageDialog(null, "Inserção com sucesso");
        } else {
            cursoController.Update(curso, listaMaterias);
            JOptionPane.showMessageDialog(null, "Atualização com sucesso");
        }

        this.hide();
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Erro ao inserir curso");
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
            java.util.logging.Logger.getLogger(CadastroCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    new CadastroCurso().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(CadastroCurso.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList<String> jList2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nome;
    // End of variables declaration//GEN-END:variables
}
