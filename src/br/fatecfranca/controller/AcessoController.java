package br.fatecfranca.controller;

import br.fatecfranca.dao.fatec_acessoDao;

public class AcessoController {

    public void Add(int id, String senha) throws Exception {
        fatec_acessoDao fatec_acesso = new fatec_acessoDao();
        fatec_acesso.Add(id, senha);
    }

    public boolean Login(int id, String senha) throws Exception {
        fatec_acessoDao fatec_acesso = new fatec_acessoDao();
        return fatec_acesso.Login(id, senha);
    }

}
