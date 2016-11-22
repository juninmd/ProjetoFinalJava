package br.fatecfranca.dao;
import br.fatecfranca.model.AlunoModel;
import java.sql.Connection;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
public class AlunoDAO implements IAlunoDAO{
    private PreparedStatement canal; // canal de comunicação
    private Connection conexao; // conexão com o banco
    public Connection conecta(){
            BaseDAO bd = new BaseDAO();
            return bd.conecta(); // conecta e retorna objeto de conexão 
    }
    @Override
    public int insere(AlunoModel aluno) {
        try{
            conexao = conecta();
            if (conexao != null){ // conectou
String sql = "insert into aluno (cidade, cpf, documentos, endereco, estado, "
        + "nome, rg, sexo) values (?,?,?,?,?,?,?,?)";
                // canal
                canal = conexao.prepareStatement(sql);
                // atribui os valores do aluno
                canal.setString(1, aluno.getCidade());
                canal.setString(2, aluno.getCpf());
                canal.setString(3, aluno.getDocumentos());
                canal.setString(4, aluno.getEndereco());
                canal.setString(5, aluno.getEstado());
                canal.setString(6, aluno.getNome());
                canal.setString(7, aluno.getRg());
                canal.setString(8, aluno.getSexo());
                // executa a inserção
                canal.execute();
                return 1;
            }
            else return 0;
        }
        catch(Exception e){
            System.out.println(" AlunoDAOImpl" + e.getMessage());
            return -1;
        }
    }
    @Override
    public int remove(AlunoModel aluno) {
         try{
            conexao = conecta();
            if (conexao != null){ // conectou
String sql = "delete from aluno where codigo = ?";
                // canal
                canal = conexao.prepareStatement(sql);
                // atribui os valores do aluno
                canal.setInt(1, aluno.getCodigo());
                // executa a inserção
                canal.execute();
                return 1;
            }
            else return 0;
        }
        catch(Exception e){
            System.out.println(" AlunoDAOImpl" + e.getMessage());
            return -1;
        }
    }
    @Override
    public int atualiza(AlunoModel aluno) {
       try{
            conexao = conecta();
            if (conexao != null){ // conectou
String sql = "update aluno set cidade = ?, cpf = ?, documentos = ?, "
        + "endereco = ?, estado = ?, nome = ? , rg = ?, sexo = ? where "
        + "codigo = ?";
            // canal
            canal = conexao.prepareStatement(sql);
            // atribui os valores do aluno
            canal.setString(1, aluno.getCidade());
            canal.setString(2, aluno.getCpf());
            canal.setString(3, aluno.getDocumentos());
            canal.setString(4, aluno.getEndereco());
            canal.setString(5, aluno.getEstado());
            canal.setString(6, aluno.getNome());
            canal.setString(7, aluno.getRg());
            canal.setString(8, aluno.getSexo());
            canal.setInt(9, aluno.getCodigo());
            
            // executa a inserção
            canal.execute();
            return 1;
            }
            else return 0;
        }
        catch(Exception e){
            System.out.println(" AlunoDAOImpl" + e.getMessage());
            return -1;
        }
    }
    @Override
    public List<AlunoModel> consulta() {
        // guarda a lista de alunos
        ArrayList<AlunoModel> alunos = new ArrayList();
        try{
            conexao = conecta(); // conecta
            if (conexao != null){ // conectou
                String sql = "select * from aluno";
                // canal de comunicação
                canal = conexao.prepareStatement(sql);
                // executa a consulta
                ResultSet rs = canal.executeQuery();
                while (rs.next()){ // cada linha
                    AlunoModel aluno = new AlunoModel();
                    aluno.setCidade(rs.getString("cidade"));
                    aluno.setCodigo(rs.getInt("codigo"));
                    aluno.setCpf(rs.getString("cpf"));
                    aluno.setDocumentos(rs.getString("documentos"));
                    aluno.setEndereco(rs.getString("endereco"));
                    aluno.setEstado(rs.getString("estado"));
                    aluno.setNome(rs.getString("nome"));
                    aluno.setRg(rs.getString("rg"));
                    aluno.setSexo(rs.getString("sexo"));
                    // adiciona no array
                    alunos.add(aluno);
                } // fecha while
                return alunos; // arraylist com alunos
            }
            else return null; // erro
        }
        catch(Exception e){
            return null; // erro
        }
    }
}
