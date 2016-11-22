
package br.fatecfranca.dao;
import java.sql.*; // API JDBC
public class BaseDAO {
    private Connection conexao; // conexão com o banco de dados
    public BaseDAO(){
        
    }
    public Connection conecta(){
        try{
           // carrega o Driver JDBC do MySQL
            Class.forName("com.mysql.jdbc.Driver");
            // carrega o Driver JDBC do SQL Server
            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // local de conexão - onde está o BD - MySQL
            String url = "jdbc:mysql://localhost/academico";
            // local de conexão - onde está o BD - SQL Server
            //String url = "jdbc:sqlserver://localhost:1433";
            // faz a conexão
            conexao = DriverManager.getConnection(url, "root", "fatec123*");
            return conexao;
        }
        catch(Exception e){
            System.out.println("Problema na conexão" + e.getMessage());
            return null;
        }
    }
    public int fecha(){
        try{
            conexao.close();
            return 1;
        }
        catch(Exception e){
            System.out.println("Não fechou" + e.getMessage());
            return 0;
        }
    }
}
