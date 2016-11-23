package br.fatecfranca.dao;

import br.fatecfranca.model.fatec_aluno;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author jr_ac
 */
public class fatec_alunoDao extends ComumDao implements Ifatec_alunoDao {

    private enum Proc {
        FATEC_SP_S_FATEC_ALUNO_ID,
        FATEC_SP_S_FATEC_ALUNO,
        FATEC_SP_I_FATEC_ALUNO,
        FATEC_SP_U_FATEC_ALUNO,
        FATEC_SP_D_FATEC_ALUNO
    }

    public fatec_aluno GetById(int id) throws Exception {
        try {
            BeginNewStatement(Proc.FATEC_SP_S_FATEC_ALUNO_ID, "academico");
            AddParamter(new Paramter("P_codigo", java.sql.Types.NUMERIC, id));

            ResultSet rs = super.ExecuteReader();

            if (rs.next()) {
                fatec_aluno resposta = new fatec_aluno();
                resposta.setcodigo(rs.getInt("codigo"));
                resposta.setcidade(rs.getString("cidade"));
                resposta.setcpf(rs.getString("cpf"));
                resposta.setdocumentos(rs.getString("documentos"));
                resposta.setendereco(rs.getString("endereco"));
                resposta.setestado(rs.getString("estado"));
                resposta.setnome(rs.getString("nome"));
                resposta.setrg(rs.getString("rg"));
                resposta.setsexo(rs.getString("sexo"));
                return resposta;
            };
            return null;
        } catch (Exception ex) {
            throw ex;
        } finally {
            desconecta();
        }
    }

    public List<fatec_aluno> GetAll() throws Exception {
        try {
            List<fatec_aluno> lista = new java.util.ArrayList<fatec_aluno>();

            BeginNewStatement(Proc.FATEC_SP_S_FATEC_ALUNO, "academico");
            ResultSet rs = super.ExecuteReader();

            while (rs.next()) {
                fatec_aluno resposta = new fatec_aluno();
                resposta.setcodigo(rs.getInt("codigo"));
                resposta.setcidade(rs.getString("cidade"));
                resposta.setcpf(rs.getString("cpf"));
                resposta.setdocumentos(rs.getString("documentos"));
                resposta.setendereco(rs.getString("endereco"));
                resposta.setestado(rs.getString("estado"));
                resposta.setnome(rs.getString("nome"));
                resposta.setrg(rs.getString("rg"));
                resposta.setsexo(rs.getString("sexo"));
                lista.add(resposta);
            };
            return lista;
        } catch (Exception ex) {
            throw ex;
        } finally {
            desconecta();
        }
    }

    public void Add(fatec_aluno entidade) throws Exception {
        try {
            BeginNewStatement(Proc.FATEC_SP_I_FATEC_ALUNO, "academico");
            AddParamter(new Paramter("P_RESULT", java.sql.Types.VARCHAR, null, "OUT"));

            AddParamter(new Paramter("P_cidade", java.sql.Types.VARCHAR, entidade.getcidade()));
            AddParamter(new Paramter("P_cpf", java.sql.Types.VARCHAR, entidade.getcpf()));
            AddParamter(new Paramter("P_documentos", java.sql.Types.VARCHAR, entidade.getdocumentos()));
            AddParamter(new Paramter("P_endereco", java.sql.Types.VARCHAR, entidade.getendereco()));
            AddParamter(new Paramter("P_estado", java.sql.Types.VARCHAR, entidade.getestado()));
            AddParamter(new Paramter("P_nome", java.sql.Types.VARCHAR, entidade.getnome()));
            AddParamter(new Paramter("P_rg", java.sql.Types.VARCHAR, entidade.getrg()));
            AddParamter(new Paramter("P_sexo", java.sql.Types.VARCHAR, entidade.getsexo()));
            RequestProc();
        } catch (Exception ex) {
            throw ex;
        } finally {
            desconecta();
        }
    }

    public void Update(fatec_aluno entidade) throws Exception {
        try {
            BeginNewStatement(Proc.FATEC_SP_U_FATEC_ALUNO, "academico");
            AddParamter(new Paramter("P_RESULT", java.sql.Types.VARCHAR, null, "OUT"));

            AddParamter(new Paramter("P_cidade", java.sql.Types.VARCHAR, entidade.getcidade()));
            AddParamter(new Paramter("P_cpf", java.sql.Types.VARCHAR, entidade.getcpf()));
            AddParamter(new Paramter("P_documentos", java.sql.Types.VARCHAR, entidade.getdocumentos()));
            AddParamter(new Paramter("P_endereco", java.sql.Types.VARCHAR, entidade.getendereco()));
            AddParamter(new Paramter("P_estado", java.sql.Types.VARCHAR, entidade.getestado()));
            AddParamter(new Paramter("P_nome", java.sql.Types.VARCHAR, entidade.getnome()));
            AddParamter(new Paramter("P_rg", java.sql.Types.VARCHAR, entidade.getrg()));
            AddParamter(new Paramter("P_sexo", java.sql.Types.VARCHAR, entidade.getsexo()));
            RequestProc();
        } catch (Exception ex) {
            throw ex;
        } finally {
            desconecta();
        }
    }

    public void Delete(int ID) throws Exception {
        try {
            BeginNewStatement(Proc.FATEC_SP_U_FATEC_ALUNO, "academico");
            AddParamter(new Paramter("P_RESULT", java.sql.Types.VARCHAR, null, "OUT"));

            RequestProc();
        } catch (Exception ex) {
            throw ex;
        } finally {
            desconecta();
        }
    }
}
