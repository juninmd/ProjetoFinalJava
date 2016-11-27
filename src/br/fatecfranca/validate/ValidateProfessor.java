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
public class ValidateProfessor {

    public boolean Validate(String nome, String endereco, String cidade, boolean estado,
            boolean sexo, String cpf, String rg) {
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
        if (estado) {
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
            JOptionPane.showMessageDialog(null, "É necessário um cpf válido.");
            validado = false;
        }
        if (rg == null || rg.equals("")) {
            JOptionPane.showMessageDialog(null, "É necessário informar o RG!");
            validado = false;
        }
        if (rg != null && rg.length() != 12) {
            JOptionPane.showMessageDialog(null, "É necessário informar um RG válido.");
            validado = false;
        }
        return validado;
    }
}
