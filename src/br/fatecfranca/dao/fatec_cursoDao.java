package br.fatecfranca.dao;

import java.sql.ResultSet;
import java.util.List;
import br.fatecfranca.model.fatec_curso;
import java.sql.PreparedStatement;

public class fatec_cursoDao extends ComumDao {

    public fatec_curso GetById(int ID) throws Exception {
        try {
            PreparedStatement conn = BeginNewStatement("SELECT * FROM fatec_curso WHERE codigo =" + ID);
            ResultSet rs = conn.executeQuery();
            if (rs.next()) {
                fatec_curso resposta = new fatec_curso();
                resposta.setCodigo(rs.getInt("codigo"));
                resposta.setNome(rs.getString("nome"));
                return resposta;
            }
            return null;
        } catch (Exception ex) {
            throw ex;
        } finally {
            desconecta();
        }
    }

    public List<fatec_curso> GetAll() throws Exception {
        try {
            List<fatec_curso> lista = new java.util.ArrayList<fatec_curso>();

            PreparedStatement conn = BeginNewStatement("SELECT * FROM fatec_curso");
            ResultSet rs = conn.executeQuery();
            while (rs.next()) {
                fatec_curso resposta = new fatec_curso();
                resposta.setCodigo(rs.getInt("codigo"));
                resposta.setNome(rs.getString("nome"));
                lista.add(resposta);
            }
            return lista;
        } catch (Exception ex) {
            throw ex;
        } finally {
            desconecta();
        }
    }

    public int Add(fatec_curso entidade) throws Exception {
        try {
            int retorno = 0;
            PreparedStatement conn = BeginNewStatement("INSERT INTO fatec_curso (nome) values (?)");
            conn.setString(1, entidade.getNome());
            conn.execute();
            ResultSet rs = conn.getGeneratedKeys();

            if (rs.next()) {
                retorno = rs.getInt(1);
            }
            commit();
            return retorno;
        } catch (Exception ex) {
            throw ex;
        } finally {
            desconecta();
        }
    }

    public void Update(fatec_curso entidade) throws Exception {
        try {
            PreparedStatement conn = BeginNewStatement("UPDATE fatec_curso SET nome = ? WHERE codigo = " + entidade.getCodigo());
            conn.setString(1, entidade.getNome());
            conn.execute();
            commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            desconecta();
        }
    }

    public void Delete(int ID) throws Exception {
        try {
            PreparedStatement conn = BeginNewStatement("DELETE FROM fatec_curso WHERE codigo = ?");
            conn.setInt(1, ID);
            conn.execute();
            commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            desconecta();
        }
    }
}
