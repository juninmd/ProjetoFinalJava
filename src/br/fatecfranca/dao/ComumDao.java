package br.fatecfranca.dao;

import java.sql.*; // API JDBC
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ComumDao {

    // Aqui ficara salva a Conexăo com o Banco
    public Connection connection;

    // Nome da Package + Procedure
    private String procedureName;

    public String getProcedureName() {
        return procedureName;
    }

    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }

    // Recebe a Lista de Parametros
    private List<Paramter> parameters;

    public List<Paramter> getParamters() {
        return parameters;
    }

    public void setParamters(List<Paramter> parameters) {
        this.parameters = parameters;
    }

    // callStatement será o retorno da procedure 
    protected CallableStatement proc;
    public Statement statement;

    public Statement getStatement() {
        return statement;
    }

    // Recebe a Chamada da Procedure com os parametros
    private final String callOut = "CALL %s(%s)";

    // Nome Default do RecordSet
    private final String resultSetDefaultName = "P_CURSORSELECT";

    /**
     * Adiciona o parâmetro
     *
     * @param param
     */
    public void AddParamter(Paramter param) {
        this.parameters.add(param);
    }

    /**
     * Passa os parâmetros para a chamada da procedure
     *
     * @throws SQLException
     */
    private void PreencheParametro() throws SQLException {
        for (Paramter param : this.parameters) {
            if (param.getDirection() == "IN") {
                proc.setObject(param.getParamterName(), param.getValue(), param.getMySqlType());
            } else {
                proc.registerOutParameter(param.getParamterName(), param.getMySqlType());
            }
        }
    }

    /**
     * Desconecta ao Banco
     *
     * @throws Exception
     */
    public void desconecta() throws Exception {
        if (this.connection != null && !this.connection.isClosed()) {
            connection.close();
            connection = null;
        }
    }

    /**
     * Comita as Alteraçőes
     *
     * @throws Exception
     */
    public void commit() throws Exception {
        connection.commit();
    }

    /**
     * Desfaz as Alteraçőes
     *
     * @throws Exception
     */
    public void rollback() throws Exception {
        this.connection.rollback();
    }

    /**
     * Método responsável por retornar o valor de um parâmetro out
     *
     * @param param Parâmetro que será recuperado seu valor
     * @return Valor retornado
     * @throws Exception Exeção gerada durante a execução
     */
    public Object recoverParamterOut(String parametro) throws SQLException {
        return this.proc.getObject(parametro);
    }

    /**
     * Seta o nome da Procedure / Caso a conexăo esteja nulla conecta novamente
     * / Faz a lista de parametros
     *
     * @param packageName
     * @param procedureName
     * @param nomeFonteDados
     * @throws Exception
     */
    public void BeginNewStatement(Object procedureName, String nomeFonteDados) throws Exception {
        try {
            if (this.connection == null) {
                Class.forName("com.mysql.jdbc.Driver");

                connection = DriverManager.getConnection("jdbc:mysql://localhost/academico", "root", "fatec123*");
                connection.setAutoCommit(false);

            }
            // Seta o nome da procedure
            this.setProcedureName(procedureName.toString());

            // Cria a instância dos parâmetros
            this.setParamters(new ArrayList<Paramter>());

        } catch (Exception e) {
            throw new Exception("Ocorreu uma falha na chamada da procedure " + procedureName + " Verifique se a JNDI [" + nomeFonteDados + "] foi configurada ou existe. Erro: " + e.getMessage());
        }
    }

    /**
     * Metodo para Executar a Proc, utilizado em GETS
     *
     * @return
     * @throws Exception
     */
    public ResultSet ExecuteReader() throws Exception {
        try {

            String paramExec = "";
            paramExec = ":" + this.resultSetDefaultName;
            for (Paramter param : this.parameters) {
                paramExec += ", " + ":" + param.getParamterName();
            }

            proc = connection.prepareCall(String.format(callOut, procedureName, paramExec));
            proc.registerOutParameter(this.resultSetDefaultName, 0);
            PreencheParametro();
            this.proc.execute();
            return (ResultSet) this.proc.getObject(this.resultSetDefaultName);
        } catch (Exception ex) {
            throw ex;
        }
    }

    public void Executar() throws Exception {
        try {

            String paramExec = "";
            for (Paramter param : this.parameters) {
                paramExec += ":" + param.getParamterName() + ",";
            }
            paramExec = paramExec.substring(0, paramExec.length() - 1);

            proc = connection.prepareCall(String.format(callOut, procedureName, paramExec));
            PreencheParametro();
            this.proc.execute();
            this.commit();
        } catch (Exception ex) {
            throw ex;
        }

    }

    public void RequestProc() throws Exception {
        try {

            String paramExec = "";
            for (Paramter param : this.parameters) {
                paramExec += ":" + param.getParamterName() + ",";
            }
            paramExec = paramExec.substring(0, paramExec.length() - 1);

            proc = connection.prepareCall(String.format(callOut, procedureName, paramExec));
            PreencheParametro();
            this.proc.execute();

            String result = (String) proc.getObject("P_RESULT");

            if (result.contains("MYSQL-")) {
                throw new Exception(result);
            }
            commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            desconecta();
        }
    }

    public void RequestProc(String resultName) throws Exception {
        try {

            String paramExec = "";
            for (Paramter param : this.parameters) {
                paramExec += ":" + param.getParamterName() + ",";
            }
            paramExec = paramExec.substring(0, paramExec.length() - 1);

            proc = connection.prepareCall(String.format(callOut, procedureName, paramExec));
            PreencheParametro();
            this.proc.execute();

            String result = proc.getObject(resultName).toString();

            if (result.contains("MYSQL-")) {
                throw new Exception(result);
            }
            commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            desconecta();
        }
    }
}
