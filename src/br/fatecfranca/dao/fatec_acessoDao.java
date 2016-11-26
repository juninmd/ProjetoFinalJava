package br.fatecfranca.dao;

import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class fatec_acessoDao extends ComumDao implements Ifatec_acessoDao {

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

    public void Add(int id, String senha) throws Exception {
        try {
            PreparedStatement conn = BeginNewStatement("INSERT INTO fatec_acesso (iduser, senha) values (?, ?)");
            conn.setInt(1, id);
            conn.setString(2, senha);
            conn.execute();
            commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            desconecta();
        }
    }
}
