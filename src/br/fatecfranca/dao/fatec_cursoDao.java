package br.fatecfranca.dao;

import java.sql.ResultSet;
import java.util.List;
import br.fatecfranca.model.fatec_curso;

public class fatec_cursoDao extends ComumDao {

    private enum Proc {
        FATEC_SP_S_FATEC_CURSO_ID,
        FATEC_SP_S_FATEC_CURSO,
        FATEC_SP_I_FATEC_CURSO,
        FATEC_SP_U_FATEC_CURSO,
        FATEC_SP_D_FATEC_CURSO
    }

    public fatec_curso GetById(int id) throws Exception {
        try {
            BeginNewStatement(Proc.FATEC_SP_S_FATEC_CURSO_ID, "academico");
            AddParamter(new Paramter("P_codigo", java.sql.Types.NUMERIC, id));

            ResultSet rs = super.ExecuteReader();

            if (rs.next()) {
                fatec_curso resposta = new fatec_curso();
                resposta.setcodigo(rs.getInt("codigo"));
                resposta.setnome(rs.getString("nome"));
                return resposta;
            };
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

            BeginNewStatement(Proc.FATEC_SP_S_FATEC_CURSO, "academico");
            ResultSet rs = super.ExecuteReader();

            while (rs.next()) {
                fatec_curso resposta = new fatec_curso();
                resposta.setcodigo(rs.getInt("codigo"));
                resposta.setnome(rs.getString("nome"));
                lista.add(resposta);
            };
            return lista;
        } catch (Exception ex) {
            throw ex;
        } finally {
            desconecta();
        }
    }

    public void Add(fatec_curso entidade) throws Exception {
        try {
            BeginNewStatement(Proc.FATEC_SP_I_FATEC_CURSO, "academico");
            AddParamter(new Paramter("P_RESULT", java.sql.Types.VARCHAR, null, "OUT"));

            AddParamter(new Paramter("P_nome", java.sql.Types.VARCHAR, entidade.getnome()));
            RequestProc();
        } catch (Exception ex) {
            throw ex;
        } finally {
            desconecta();
        }
    }

    public void Update(fatec_curso entidade) throws Exception {
        try {
            BeginNewStatement(Proc.FATEC_SP_U_FATEC_CURSO, "academico");
            AddParamter(new Paramter("P_RESULT", java.sql.Types.VARCHAR, null, "OUT"));

            AddParamter(new Paramter("P_NOME", java.sql.Types.VARCHAR, entidade.getnome()));
            RequestProc();
        } catch (Exception ex) {
            throw ex;
        } finally {
            desconecta();
        }
    }

    public void Delete(int ID) throws Exception {
        try {
            BeginNewStatement(Proc.FATEC_SP_U_FATEC_CURSO, "academico");
            AddParamter(new Paramter("P_RESULT", java.sql.Types.VARCHAR, null, "OUT"));

            RequestProc();
        } catch (Exception ex) {
            throw ex;
        } finally {
            desconecta();
        }
    }
}
