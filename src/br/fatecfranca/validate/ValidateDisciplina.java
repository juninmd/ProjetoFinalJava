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
public class ValidateDisciplina {
    
    public boolean Validate(String nome, boolean professor){
        boolean validado = true;
        
        if(nome == null || nome.equals("")){
            JOptionPane.showMessageDialog(null, "É necessário informar o nome da Disciplina!");
            validado = false;
        }
        if(professor){
            JOptionPane.showMessageDialog(null, "É necessário informar o professor da Disciplina.");
            validado = false;
        }
        return validado;
    }
}
