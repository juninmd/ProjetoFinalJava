package br.fatecfranca.dao;

import java.sql.ResultSet;
import java.util.List;
import br.fatecfranca.model.fatec_disciplina;
import java.sql.PreparedStatement;

public class fatec_disciplinaDao extends ComumDao {

    public fatec_disciplina GetById(int ID) throws Exception {
        try {
            PreparedStatement conn = BeginNewStatement("SELECT * FROM fatec_disciplina WHERE codigo =" + ID);
            ResultSet rs = conn.executeQuery();
            if (rs.next()) {
                fatec_disciplina resposta = new fatec_disciplina();
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

    public List<fatec_disciplina> GetAll() throws Exception {
        try {
            List<fatec_disciplina> lista = new java.util.ArrayList<fatec_disciplina>();

            PreparedStatement conn = BeginNewStatement("SELECT * FROM fatec_disciplina");
            ResultSet rs = conn.executeQuery();
            while (rs.next()) {
                fatec_disciplina resposta = new fatec_disciplina();
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

    public int Add(fatec_disciplina entidade) throws Exception {
        try {
            int retorno = 0;
            PreparedStatement conn = BeginNewStatement("INSERT INTO fatec_disciplina (nome) values (?)");
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

    public void Update(fatec_disciplina entidade) throws Exception {
        try {
            PreparedStatement conn = BeginNewStatement("UPDATE fatec_disciplina SET nome = ? WHERE codigo = " + entidade.getCodigo());
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
            PreparedStatement conn = BeginNewStatement("DELETE FROM fatec_disciplina WHERE codigo = ?");
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
