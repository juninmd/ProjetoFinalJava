package br.fatecfranca.view;

import br.fatecfranca.controller.AlunoController;
import br.fatecfranca.model.fatec_aluno;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author aluno
 */
public class CadastroAluno extends javax.swing.JFrame {

    /**
     * Creates new form CadastroAluno
     */
    public CadastroAluno() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        nome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        endereco = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cidade = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        estado = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        masculino = new javax.swing.JRadioButton();
        feminino = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        rg = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        cpf = new javax.swing.JFormattedTextField();
        em = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        militar = new javax.swing.JCheckBox();
        contrato = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Nome");

        jLabel2.setText("Endereço");

        jLabel3.setText("Cidade");

        jLabel4.setText("Estado");

        estado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "São Paulo", "Minas Gerais", "Rio de Janeiro", "Espírito Santo" }));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLabel5.setForeground(new java.awt.Color(0, 51, 255));
        jLabel5.setText("Tela de Cadastro de Alunos");

        jLabel6.setText("Sexo");

        buttonGroup1.add(masculino);
        masculino.setText("Masculino");

        buttonGroup1.add(feminino);
        feminino.setText("Feminino");

        jLabel7.setText("RG");

        jLabel8.setText("CPF");

        try {
            cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        em.setText("Conclusão EM");

        jLabel9.setText("Documentos");

        militar.setText("Militar");

        contrato.setText("Contrato");

        jButton1.setBackground(new java.awt.Color(255, 0, 51));
        jButton1.setForeground(new java.awt.Color(255, 0, 102));
        jButton1.setText("Cadastrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cpf, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(masculino)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                        .addComponent(feminino))
                    .addComponent(estado, 0, 263, Short.MAX_VALUE)
                    .addComponent(cidade, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                    .addComponent(endereco, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                    .addComponent(nome, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                    .addComponent(rg, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(em)
                        .addGap(18, 18, 18)
                        .addComponent(militar)
                        .addGap(18, 18, 18)
                        .addComponent(contrato)))
                .addGap(102, 102, 102))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(104, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(87, 87, 87)
                .addComponent(jButton1)
                .addGap(158, 158, 158))
            .addGroup(layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(jLabel5)
                .addContainerGap(164, Short.MAX_VALUE))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(masculino)
                    .addComponent(feminino))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(rg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(em)
                    .addComponent(jLabel9)
                    .addComponent(militar)
                    .addComponent(contrato))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
    // cria um objeto da classe Aluno
    fatec_aluno aluno = new fatec_aluno();
    // atribui os valores do usuário
    aluno.setcidade(cidade.getText());
    aluno.setcpf(cpf.getText());
    String doc = "";
    if (em.isSelected()) {
        doc = doc + " ensino médio";
    }
    if (militar.isSelected()) {
        doc = doc + " militar";
    }
    if (contrato.isSelected()) {
        doc = doc + " contrato";
    }
    aluno.setdocumentos(doc);
    aluno.setendereco(endereco.getText());
    aluno.setestado(estado.getSelectedItem().toString());
    aluno.setnome(nome.getText());
    aluno.setrg(rg.getText());
    String sexo = "";
    if (masculino.isSelected()) {
        sexo = "masculino";
    } else {
        sexo = "feminino";
    }
    aluno.setsexo(sexo);

    // view acessa o controller e recebe o resultado
    AlunoController alunoController = new AlunoController();
    try {
        alunoController.insere(aluno);
        JOptionPane.showMessageDialog(null, "Inserção com sucesso");
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Erro ao inserir aluno");
    }
}//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new CadastroAluno().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField cidade;
    private javax.swing.JCheckBox contrato;
    private javax.swing.JFormattedTextField cpf;
    private javax.swing.JCheckBox em;
    private javax.swing.JTextField endereco;
    private javax.swing.JComboBox estado;
    private javax.swing.JRadioButton feminino;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton masculino;
    private javax.swing.JCheckBox militar;
    private javax.swing.JTextField nome;
    private javax.swing.JFormattedTextField rg;
    // End of variables declaration//GEN-END:variables
}
