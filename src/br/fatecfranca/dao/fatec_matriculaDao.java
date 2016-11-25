package br.fatecfranca.dao;

import java.sql.ResultSet;
import java.util.List;
import br.fatecfranca.model.fatec_matricula;
import java.sql.Date;
import java.sql.PreparedStatement;

public class fatec_matriculaDao extends ComumDao {

    public fatec_matricula GetById(int ID) throws Exception {
        try {
            PreparedStatement conn = BeginNewStatement("SELECT * FROM fatec_matricula WHERE codigo = ID");
            ResultSet rs = conn.executeQuery();
            if (rs.next()) {
                fatec_matricula resposta = new fatec_matricula();
                resposta.setCodigo(rs.getInt("codigo"));
                resposta.setCodigoaluno(rs.getInt("codigoaluno"));
                resposta.setCodigocurso(rs.getInt("codigocurso"));
                resposta.setMatricula(rs.getDate("matricula"));
                return resposta;
            };
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

            PreparedStatement conn = BeginNewStatement("SELECT * FROM fatec_matricula");
            ResultSet rs = conn.executeQuery();
            while (rs.next()) {
                fatec_matricula resposta = new fatec_matricula();
                resposta.setCodigo(rs.getInt("codigo"));
                resposta.setCodigoaluno(rs.getInt("codigoaluno"));
                resposta.setCodigocurso(rs.getInt("codigocurso"));
                resposta.setMatricula(rs.getDate("matricula"));
                lista.add(resposta);
            };
            return lista;
        } catch (Exception ex) {
            throw ex;
        } finally {
            desconecta();
        }
    }

    public void Add(fatec_matricula entidade) throws Exception {
        try {
            PreparedStatement conn = BeginNewStatement("INSERT INTO fatec_matricula (codigo, codigoaluno, codigocurso, matricula) values (?, ?, ?, ?)");
            conn.setInt(1, entidade.getCodigo());
            conn.setInt(2, entidade.getCodigoaluno());
            conn.setInt(3, entidade.getCodigocurso());
            conn.setDate(4, (Date) entidade.getMatricula());
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
            PreparedStatement conn = BeginNewStatement("UPDATE fatec_matricula SET codigo = ?, codigoaluno = ?, codigocurso = ?, matricula = ? WHERE codigo = " + entidade.getCodigo());
            conn.setInt(1, entidade.getCodigo());
            conn.setInt(2, entidade.getCodigoaluno());
            conn.setInt(3, entidade.getCodigocurso());
            conn.setDate(4, (Date) entidade.getMatricula());
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
