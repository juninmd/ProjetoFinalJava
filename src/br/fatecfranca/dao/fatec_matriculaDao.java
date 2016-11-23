package br.fatecfranca.dao;

import java.sql.ResultSet;
import java.util.List;
import br.fatecfranca.model.fatec_matricula;

public class fatec_matriculaDao extends ComumDao {

    private enum Proc {
        FATEC_SP_S_FATEC_MATRICULA_ID,
        FATEC_SP_S_FATEC_MATRICULA,
        FATEC_SP_I_FATEC_MATRICULA,
        FATEC_SP_U_FATEC_MATRICULA,
        FATEC_SP_D_FATEC_MATRICULA
    }

    public fatec_matricula GetById(int id) throws Exception {
        try {
            BeginNewStatement(Proc.FATEC_SP_S_FATEC_MATRICULA_ID, "academico");
            AddParamter(new Paramter("P_codigo", java.sql.Types.NUMERIC, id));

            ResultSet rs = super.ExecuteReader();

            if (rs.next()) {
                fatec_matricula resposta = new fatec_matricula();
                resposta.setcodigo(rs.getInt("codigo"));
                resposta.setcodigoaluno(rs.getInt("codigoaluno"));
                resposta.setcodigocurso(rs.getInt("codigocurso"));
                resposta.setmatricula(rs.getDate("matricula"));
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

            BeginNewStatement(Proc.FATEC_SP_S_FATEC_MATRICULA, "academico");
            ResultSet rs = super.ExecuteReader();

            while (rs.next()) {
                fatec_matricula resposta = new fatec_matricula();
                resposta.setcodigo(rs.getInt("codigo"));
                resposta.setcodigoaluno(rs.getInt("codigoaluno"));
                resposta.setcodigocurso(rs.getInt("codigocurso"));
                resposta.setmatricula(rs.getDate("matricula"));
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
            BeginNewStatement(Proc.FATEC_SP_I_FATEC_MATRICULA, "academico");
            AddParamter(new Paramter("P_RESULT", java.sql.Types.VARCHAR, null, "OUT"));

            AddParamter(new Paramter("P_codigoaluno", java.sql.Types.INTEGER, entidade.getcodigoaluno()));
            AddParamter(new Paramter("P_codigocurso", java.sql.Types.INTEGER, entidade.getcodigocurso()));
            AddParamter(new Paramter("P_matricula", java.sql.Types.DATE, entidade.getmatricula()));
            RequestProc();
        } catch (Exception ex) {
            throw ex;
        } finally {
            desconecta();
        }
    }

    public void Update(fatec_matricula entidade) throws Exception {
        try {
            BeginNewStatement(Proc.FATEC_SP_U_FATEC_MATRICULA, "academico");
            AddParamter(new Paramter("P_RESULT", java.sql.Types.VARCHAR, null, "OUT"));

            AddParamter(new Paramter("P_codigo", java.sql.Types.INTEGER, entidade.getcodigo()));
            AddParamter(new Paramter("P_codigoaluno", java.sql.Types.INTEGER, entidade.getcodigoaluno()));
            AddParamter(new Paramter("P_codigocurso", java.sql.Types.INTEGER, entidade.getcodigocurso()));
            AddParamter(new Paramter("P_matricula", java.sql.Types.DATE, entidade.getmatricula()));
            RequestProc();
        } catch (Exception ex) {
            throw ex;
        } finally {
            desconecta();
        }
    }

    public void Delete(int ID) throws Exception {
        try {
            BeginNewStatement(Proc.FATEC_SP_U_FATEC_MATRICULA, "academico");
            AddParamter(new Paramter("P_RESULT", java.sql.Types.VARCHAR, null, "OUT"));

            RequestProc();
        } catch (Exception ex) {
            throw ex;
        } finally {
            desconecta();
        }
    }
}
