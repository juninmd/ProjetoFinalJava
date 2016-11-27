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
public class ValidateAluno {

    public boolean Validate(String nome, String endereco, String cidade, String estado,
            boolean sexo, String cpf, String rg, boolean documentos) {
        boolean validado = true;

        if (nome == null || nome.equals("")) {
            JOptionPane.showMessageDialog(null, "É necessário informar o nome!");
            validado = false;
        }
        if (endereco == null || endereco.equals("")) {
            JOptionPane.showMessageDialog(null, "É necessário informar o endereço!");
            validado = false;
        }
        if (cidade == null || cidade.equals("")) {
            JOptionPane.showMessageDialog(null, "É necessário informar a cidade!");
            validado = false;
        }
        if (estado == null || estado.equals("")) {
            JOptionPane.showMessageDialog(null, "É necessário informar o estado!");
            validado = false;
        }
        if (sexo == false) {
            JOptionPane.showMessageDialog(null, "É necessário informar o sexo!");
            validado = false;
        }
        if (cpf == null || cpf.equals("")) {
            JOptionPane.showMessageDialog(null, "É necessário informar o CPF!");
            validado = false;
        }
        if (cpf != null && cpf.length() != 14) {
            JOptionPane.showMessageDialog(null, "Preencha um cpf válido.");
            validado = false;
        }
        if (rg == null || rg.equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha um rg.");
            validado = false;
        }
        if (rg != null && rg.length() != 12) {
            JOptionPane.showMessageDialog(null, "Preencha um rg válido.");
            validado = false;
        }
        if (documentos == false) {
            JOptionPane.showMessageDialog(null, "É necessário informar o documento!");
            validado = false;
        }
        return validado;
    }
}
