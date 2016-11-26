package br.fatecfranca.dao;

import java.sql.ResultSet;
import java.util.List;
import br.fatecfranca.model.fatec_curso_disciplina;
import java.sql.PreparedStatement;

public class fatec_curso_disciplinaDao extends ComumDao {

    public fatec_curso_disciplina GetById(int idCurso, int idDisciplina) throws Exception {
        try {
            PreparedStatement conn = BeginNewStatement("SELECT * FROM fatec_curso_disciplina WHERE idCurso =" + idCurso + "and IdDisciplina =" + idDisciplina);
            ResultSet rs = conn.executeQuery();
            if (rs.next()) {
                fatec_curso_disciplina resposta = new fatec_curso_disciplina();
                resposta.setIdcurso(rs.getInt("idCurso"));
                resposta.setIddisciplina(rs.getInt("idDisciplina"));
                return resposta;
            }
            return null;
        } catch (Exception ex) {
            throw ex;
        } finally {
            desconecta();
        }
    }

    public List<fatec_curso_disciplina> GetAll() throws Exception {
        try {
            List<fatec_curso_disciplina> lista = new java.util.ArrayList<fatec_curso_disciplina>();

            PreparedStatement conn = BeginNewStatement("SELECT * FROM fatec_curso_disciplina");
            ResultSet rs = conn.executeQuery();
            while (rs.next()) {
                fatec_curso_disciplina resposta = new fatec_curso_disciplina();
                resposta.setIdcurso(rs.getInt("idCurso"));
                resposta.setIddisciplina(rs.getInt("idDisciplina"));
                lista.add(resposta);
            }
            return lista;
        } catch (Exception ex) {
            throw ex;
        } finally {
            desconecta();
        }
    }

    public void Add(fatec_curso_disciplina entidade) throws Exception {
        try {
            PreparedStatement conn = BeginNewStatement("INSERT INTO fatec_curso_disciplina (idCurso, idDisciplina) values (?,?)");
            conn.setInt(1, entidade.getIddisciplina());
            conn.setInt(2, entidade.getIdcurso());
            conn.execute();
            commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            desconecta();
        }
    }

    public void Update(fatec_curso_disciplina entidade) throws Exception {
        try {
            PreparedStatement conn = BeginNewStatement("UPDATE fatec_curso_disciplina SET idDisciplina = ? WHERE idCurso = " + entidade.getIdcurso());
            conn.setInt(1, entidade.getIddisciplina());
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
            PreparedStatement conn = BeginNewStatement("DELETE FROM fatec_curso_disciplina WHERE idCurso = ?");
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
