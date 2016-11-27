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
public class ValidateCurso {
    
    public boolean Validate(String nome, int materias){
        boolean validado = true;
        
        if(nome == null || nome.equals("")){
            JOptionPane.showMessageDialog(null, "É necessário informar o nome do Curso!");
            validado = false;
        }
        if(materias == 0){
            JOptionPane.showMessageDialog(null, "É necessário informar pelo menos uma matéria.");
            validado = false;
        }
        return validado;
    }   
}
            
        

