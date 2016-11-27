package br.fatecfranca.dao;

import java.sql.ResultSet;
import java.util.List;
import br.fatecfranca.model.fatec_matricula;
import java.sql.PreparedStatement;

public class fatec_matriculaDao extends ComumDao {

    public fatec_matricula GetById(int ID) throws Exception {
        try {
            PreparedStatement conn = BeginNewStatement("SELECT * FROM fatec_matricula WHERE codigo =" + ID);
            ResultSet rs = conn.executeQuery();
            if (rs.next()) {
                fatec_matricula resposta = new fatec_matricula();
                resposta.setCodigo(rs.getInt("codigo"));
                resposta.setIdaluno(rs.getInt("idAluno"));
                resposta.setIdcurso(rs.getInt("idCurso"));
                resposta.setDtmatricula(rs.getString("dtMatricula"));
                resposta.setPeriodo(rs.getString("periodo"));
                return resposta;
            }
            return null;
        } catch (Exception ex) {
            throw ex;
        } finally {
            desconecta();
        }
    }

    public List<fatec_matricula> GetAll() throws Exception {
        try {
            List<fatec_matricula> lista = new java.util.ArrayList<fatec_matricula>();

            PreparedStatement conn = BeginNewStatement("SELECT a.codigo, a.dtMatricula, a.idAluno, a.idCurso, a.periodo, b.nome, c.nome as curso \n"
                    + "FROM fatec_matricula a, fatec_aluno b, fatec_curso c\n"
                    + "where a.idAluno = b.codigo\n"
                    + "and a.idCurso = c.codigo");
            ResultSet rs = conn.executeQuery();
            while (rs.next()) {
                fatec_matricula resposta = new fatec_matricula();
                resposta.setCodigo(rs.getInt("codigo"));
                resposta.setIdaluno(rs.getInt("idAluno"));
                resposta.setIdcurso(rs.getInt("idCurso"));
                resposta.setDtmatricula(rs.getString("dtMatricula"));
                resposta.setPeriodo(rs.getString("periodo"));
                resposta.setNome(rs.getString("nome"));
                resposta.setCurso(rs.getString("curso"));
                lista.add(resposta);
            }
            return lista;
        } catch (Exception ex) {
            throw ex;
        } finally {
            desconecta();
        }
    }

    public void Add(fatec_matricula entidade) throws Exception {
        try {
            PreparedStatement conn = BeginNewStatement("INSERT INTO fatec_matricula (idAluno, idCurso, dtMatricula, periodo) values (?, ?, ?, ?)");
            conn.setInt(1, entidade.getIdaluno());
            conn.setInt(2, entidade.getIdcurso());
            conn.setString(3, entidade.getDtmatricula());
            conn.setString(4, entidade.getPeriodo());
            conn.execute();
            commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            desconecta();
        }
    }

    public void Update(fatec_matricula entidade) throws Exception {
        try {
            PreparedStatement conn = BeginNewStatement("UPDATE fatec_matricula SET idAluno = ?, idCurso = ?, dtMatricula = ?, periodo = ? WHERE codigo = " + entidade.getCodigo());
            conn.setInt(1, entidade.getIdaluno());
            conn.setInt(2, entidade.getIdcurso());
            conn.setString(3, entidade.getDtmatricula());
            conn.setString(4, entidade.getPeriodo());
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
            PreparedStatement conn = BeginNewStatement("DELETE FROM fatec_matricula WHERE codigo = ?");
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
