package br.fatecfranca.dao;

import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class fatec_acessoDao extends ComumDao {

    public boolean Login(int id, String senha) throws Exception {
        try {
            PreparedStatement conn = BeginNewStatement("SELECT * FROM fatec_acesso WHERE iduser =" + id + " and senha = " + senha);
            ResultSet rs = conn.executeQuery();
            return rs.next();
        } catch (Exception ex) {
            throw ex;
        } finally {
            desconecta();
        }
    }
}
