package br.fatecfranca.dao;
import java.sql.ResultSet;
import java.util.List;
import br.fatecfranca.model.fatec_aluno;
import java.sql.PreparedStatement;
public class fatec_alunoDao extends ComumDao { 

	public fatec_aluno GetById(int ID) throws Exception
	{
		try{
			PreparedStatement conn = BeginNewStatement("SELECT * FROM fatec_aluno WHERE codigo ="+ ID);
			ResultSet rs = conn.executeQuery();
			if(rs.next()){
				fatec_aluno resposta = new fatec_aluno();
				resposta.setCodigo(rs.getInt("codigo"));
				resposta.setCidade(rs.getString("cidade"));
				resposta.setCpf(rs.getString("cpf"));
				resposta.setDocumentos(rs.getString("documentos"));
				resposta.setEndereco(rs.getString("endereco"));
				resposta.setEstado(rs.getString("estado"));
				resposta.setNome(rs.getString("nome"));
				resposta.setRg(rs.getString("rg"));
				resposta.setSexo(rs.getString("sexo"));
				return resposta;
			}
			return null;
		}
		catch (Exception ex){
			throw ex;
		}
		finally {
			desconecta();
		}
	}
	public List<fatec_aluno> GetAll() throws Exception
	{
		try{
			List<fatec_aluno> lista = new java.util.ArrayList<fatec_aluno>();

			PreparedStatement conn = BeginNewStatement("SELECT * FROM fatec_aluno");
			ResultSet rs = conn.executeQuery();
			while(rs.next()){
				fatec_aluno resposta = new fatec_aluno();
				resposta.setCodigo(rs.getInt("codigo"));
				resposta.setCidade(rs.getString("cidade"));
				resposta.setCpf(rs.getString("cpf"));
				resposta.setDocumentos(rs.getString("documentos"));
				resposta.setEndereco(rs.getString("endereco"));
				resposta.setEstado(rs.getString("estado"));
				resposta.setNome(rs.getString("nome"));
				resposta.setRg(rs.getString("rg"));
				resposta.setSexo(rs.getString("sexo"));
				lista.add(resposta);
			}
			return lista;
		}
		catch (Exception ex){
			throw ex;
		}
		finally {
			desconecta();
		}
	}
	public void Add(fatec_aluno entidade) throws Exception
	{
		try{
			PreparedStatement conn = BeginNewStatement("INSERT INTO fatec_aluno (cidade, cpf, documentos, endereco, estado, nome, rg, sexo) values (?, ?, ?, ?, ?, ?, ?, ?)");
			conn.setString(1, entidade.getCidade());
			conn.setString(2, entidade.getCpf());
			conn.setString(3, entidade.getDocumentos());
			conn.setString(4, entidade.getEndereco());
			conn.setString(5, entidade.getEstado());
			conn.setString(6, entidade.getNome());
			conn.setString(7, entidade.getRg());
			conn.setString(8, entidade.getSexo());
			conn.execute();
			commit();
		}
		catch (Exception ex){
			throw ex;
		}
		finally {
			desconecta();
		}
	}
	public void Update(fatec_aluno entidade) throws Exception
	{
		try{
			PreparedStatement conn = BeginNewStatement("UPDATE fatec_aluno SET cidade = ?, cpf = ?, documentos = ?, endereco = ?, estado = ?, nome = ?, rg = ?, sexo = ? WHERE codigo = " +  entidade.getCodigo());
			conn.setString(1, entidade.getCidade());
			conn.setString(2, entidade.getCpf());
			conn.setString(3, entidade.getDocumentos());
			conn.setString(4, entidade.getEndereco());
			conn.setString(5, entidade.getEstado());
			conn.setString(6, entidade.getNome());
			conn.setString(7, entidade.getRg());
			conn.setString(8, entidade.getSexo());
			conn.execute();
			commit();
		}
		catch (Exception ex){
			throw ex;
		}
		finally {
			desconecta();
		}
	}
	public void Delete(int ID) throws Exception
	{
		try{
			PreparedStatement conn = BeginNewStatement("DELETE FROM fatec_aluno WHERE codigo = ?");
			conn.setInt(1, ID);
			conn.execute();
			commit();
		}
		catch (Exception ex){
			throw ex;
		}
		finally {
			desconecta();
		}
	}
}
