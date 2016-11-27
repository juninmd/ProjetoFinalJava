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
public class ValidateAcesso {
    
    public boolean Validate (String usuario, String senha){
        boolean validado = true;
     
        if (usuario == null || usuario.equals("")){
            JOptionPane.showMessageDialog(null, "É necessário informar o usuário!");
            validado = false;
        }
        if(senha == null || senha.equals("")){
            JOptionPane.showMessageDialog(null, "É necessário informar a senha!");
            validado = false;
        }
        return validado;
    }
}
