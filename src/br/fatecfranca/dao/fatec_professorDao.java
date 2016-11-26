package br.fatecfranca.dao;

import java.sql.ResultSet;
import java.util.List;
import br.fatecfranca.model.fatec_professor;
import java.sql.PreparedStatement;

public class fatec_professorDao extends ComumDao {

    public fatec_professor GetById(int ID) throws Exception {
        try {
            PreparedStatement conn = BeginNewStatement("SELECT * FROM fatec_professor WHERE codigo =" + ID);
            ResultSet rs = conn.executeQuery();
            if (rs.next()) {
                fatec_professor resposta = new fatec_professor();
                resposta.setCodigo(rs.getInt("codigo"));
                resposta.setCidade(rs.getString("cidade"));
                resposta.setCpf(rs.getString("cpf"));
                resposta.setEndereco(rs.getString("endereco"));
                resposta.setEstado(rs.getString("estado"));
                resposta.setNome(rs.getString("nome"));
                resposta.setRg(rs.getString("rg"));
                resposta.setSexo(rs.getString("sexo"));
                return resposta;
            }
            return null;
        } catch (Exception ex) {
            throw ex;
        } finally {
            desconecta();
        }
    }

    public List<fatec_professor> GetAll() throws Exception {
        try {
            List<fatec_professor> lista = new java.util.ArrayList<fatec_professor>();

            PreparedStatement conn = BeginNewStatement("SELECT * FROM fatec_professor");
            ResultSet rs = conn.executeQuery();
            while (rs.next()) {
                fatec_professor resposta = new fatec_professor();
                resposta.setCodigo(rs.getInt("codigo"));
                resposta.setCidade(rs.getString("cidade"));
                resposta.setCpf(rs.getString("cpf"));
                resposta.setEndereco(rs.getString("endereco"));
                resposta.setEstado(rs.getString("estado"));
                resposta.setNome(rs.getString("nome"));
                resposta.setRg(rs.getString("rg"));
                resposta.setSexo(rs.getString("sexo"));
                lista.add(resposta);
            }
            return lista;
        } catch (Exception ex) {
            throw ex;
        } finally {
            desconecta();
        }
    }

    public void Add(fatec_professor entidade) throws Exception {
        try {
            PreparedStatement conn = BeginNewStatement("INSERT INTO fatec_professor (cidade, cpf, endereco, estado, nome, rg, sexo) values (?, ?, ?, ?, ?, ?, ?)");
            conn.setString(1, entidade.getCidade());
            conn.setString(2, entidade.getCpf());
            conn.setString(3, entidade.getEndereco());
            conn.setString(4, entidade.getEstado());
            conn.setString(5, entidade.getNome());
            conn.setString(6, entidade.getRg());
            conn.setString(7, entidade.getSexo());
            conn.execute();
            commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            desconecta();
        }
    }

    public void Update(fatec_professor entidade) throws Exception {
        try {
            PreparedStatement conn = BeginNewStatement("UPDATE fatec_professor SET cidade = ?, cpf = ?, endereco = ?, estado = ?, nome = ?, rg = ?, sexo = ? WHERE codigo = " + entidade.getCodigo());
            conn.setString(1, entidade.getCidade());
            conn.setString(2, entidade.getCpf());
            conn.setString(3, entidade.getEndereco());
            conn.setString(4, entidade.getEstado());
            conn.setString(5, entidade.getNome());
            conn.setString(6, entidade.getRg());
            conn.setString(7, entidade.getSexo());
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
            PreparedStatement conn = BeginNewStatement("DELETE FROM fatec_professor WHERE codigo = ?");
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
