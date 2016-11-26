package br.fatecfranca.dao;

import java.sql.*; // API JDBC
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Statement;

public class ComumDao {

    // Aqui ficara salva a Conexăo com o Banco
    public Connection connection;

    protected CallableStatement proc;
    public Statement statement;

    public Statement getStatement() {
        return statement;
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
     * Seta o nome da Procedure / Caso a conexăo esteja nulla conecta novamente
     * / Faz a lista de parametros
     *
     * @param query
     * @return
     * @throws Exception
     */
    public PreparedStatement BeginNewStatement(String query) throws Exception {
        try {
            if (this.connection == null) {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost/academico", "root", "mysql");
                connection.setAutoCommit(false);
            }
            return this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

        } catch (Exception e) {
            throw new Exception("Ocorreu uma falha na execução da query " + query + " Erro: " + e.getMessage());
        }
    }
}
