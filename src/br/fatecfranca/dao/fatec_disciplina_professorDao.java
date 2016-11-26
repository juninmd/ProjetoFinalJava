package br.fatecfranca.dao;

import java.sql.ResultSet;
import java.util.List;
import br.fatecfranca.model.fatec_disciplina_professor;
import java.sql.PreparedStatement;

public class fatec_disciplina_professorDao extends ComumDao {

    public fatec_disciplina_professor GetById(int ID) throws Exception {
        try {
            PreparedStatement conn = BeginNewStatement("SELECT * FROM fatec_disciplina_professor WHERE idDisciplina =" + ID);
            ResultSet rs = conn.executeQuery();
            if (rs.next()) {
                fatec_disciplina_professor resposta = new fatec_disciplina_professor();
                resposta.setIddisciplina(rs.getInt("idDisciplina"));
                resposta.setIdprofessor(rs.getInt("idProfessor"));
                return resposta;
            }
            return null;
        } catch (Exception ex) {
            throw ex;
        } finally {
            desconecta();
        }
    }

    public List<fatec_disciplina_professor> GetAll() throws Exception {
        try {
            List<fatec_disciplina_professor> lista = new java.util.ArrayList<fatec_disciplina_professor>();

            PreparedStatement conn = BeginNewStatement("SELECT * FROM fatec_disciplina_professor");
            ResultSet rs = conn.executeQuery();
            while (rs.next()) {
                fatec_disciplina_professor resposta = new fatec_disciplina_professor();
                resposta.setIddisciplina(rs.getInt("idDisciplina"));
                resposta.setIdprofessor(rs.getInt("idProfessor"));
                lista.add(resposta);
            }
            return lista;
        } catch (Exception ex) {
            throw ex;
        } finally {
            desconecta();
        }
    }

    public void Add(fatec_disciplina_professor entidade) throws Exception {
        try {
            PreparedStatement conn = BeginNewStatement("INSERT INTO fatec_disciplina_professor (idDisciplina, idProfessor) values (?, ?)");
            conn.setInt(1, entidade.getIddisciplina());
            conn.setInt(2, entidade.getIdprofessor());

            conn.execute();
            commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            desconecta();
        }
    }

    public void Update(fatec_disciplina_professor entidade) throws Exception {
        try {
            PreparedStatement conn = BeginNewStatement("UPDATE fatec_disciplina_professor SET idProfessor = ? WHERE idDisciplina = " + entidade.getIddisciplina());
            conn.setInt(1, entidade.getIdprofessor());
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
            PreparedStatement conn = BeginNewStatement("DELETE FROM fatec_disciplina_professor WHERE idDisciplina = ?");
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
