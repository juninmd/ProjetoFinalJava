/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fatecfranca.validate;

import javax.swing.JOptionPane;

/**
 *
 * @author jr_ac
 */
public class ValidateMatricula {

    public boolean Validate(boolean aluno, boolean curso, String dataMatricula, boolean periodo) {
        boolean validado = true;

        if (aluno) {
            JOptionPane.showMessageDialog(null, "Escolha um aluno para efetivar a matrícula.");
            validado = false;
        }
        if (curso) {
            JOptionPane.showMessageDialog(null, "Escolha um curso para efetivar a matrícula.");
            validado = false;
        }
        if (dataMatricula == null || dataMatricula.equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha a data da Matrícula");
            validado = false;
        }
        if (dataMatricula != null && dataMatricula.length() != 10) {
            JOptionPane.showMessageDialog(null, "Digite uma data válida.");
            validado = false;
        }

        if (periodo) {
            JOptionPane.showMessageDialog(null, "É necessário informar o período.");
            validado = false;
        }
        return validado;
    }
}
