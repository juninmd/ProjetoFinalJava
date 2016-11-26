package br.fatecfranca.dao;

public interface Ifatec_acessoDao {

    public void Add(int id, String senha) throws Exception;

    public boolean Login(int id, String senha) throws Exception;

}
