package br.fatecfranca.dao;

import java.sql.ResultSet;
import java.util.List;
import br.fatecfranca.model.fatec_disciplina;

public class fatec_disciplinaDao extends ComumDao {

    private enum Proc {
        FATEC_SP_S_FATEC_DISCIPLINA_ID,
        FATEC_SP_S_FATEC_DISCIPLINA,
        FATEC_SP_I_FATEC_DISCIPLINA,
        FATEC_SP_U_FATEC_DISCIPLINA,
        FATEC_SP_D_FATEC_DISCIPLINA
    }

    public fatec_disciplina GetById(int id) throws Exception {
        try {
            BeginNewStatement(Proc.FATEC_SP_S_FATEC_DISCIPLINA_ID, "academico");
            AddParamter(new Paramter("P_codigo", java.sql.Types.NUMERIC, id));

            ResultSet rs = super.ExecuteReader();

            if (rs.next()) {
                fatec_disciplina resposta = new fatec_disciplina();
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

    @SuppressWarnings("empty-statement")
    public List<fatec_disciplina> GetAll() throws Exception {
        try {
            List<fatec_disciplina> lista = new java.util.ArrayList<fatec_disciplina>();

            BeginNewStatement(Proc.FATEC_SP_S_FATEC_DISCIPLINA, "academico");
            ResultSet rs = super.ExecuteReader();

            while (rs.next()) {
                fatec_disciplina resposta = new fatec_disciplina();
                resposta.setcodigo(rs.getInt("codigo"));
                resposta.setnome(rs.getString("nome"));
                lista.add(resposta);
            }
            return lista;
        } catch (Exception ex) {
            throw ex;
        } finally {
            desconecta();
        }
    }

    public void Add(fatec_disciplina entidade) throws Exception {
        try {
            BeginNewStatement(Proc.FATEC_SP_I_FATEC_DISCIPLINA, "academico");
            AddParamter(new Paramter("P_RESULT", java.sql.Types.VARCHAR, null, "OUT"));

            AddParamter(new Paramter("P_NOME", java.sql.Types.VARCHAR, entidade.getnome()));
            RequestProc();
        } catch (Exception ex) {
            throw ex;
        } finally {
            desconecta();
        }
    }

    public void Update(fatec_disciplina entidade) throws Exception {
        try {
            BeginNewStatement(Proc.FATEC_SP_U_FATEC_DISCIPLINA, "academico");
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
            BeginNewStatement(Proc.FATEC_SP_U_FATEC_DISCIPLINA, "academico");
            AddParamter(new Paramter("P_RESULT", java.sql.Types.VARCHAR, null, "OUT"));

            RequestProc();
        } catch (Exception ex) {
            throw ex;
        } finally {
            desconecta();
        }
    }
}
