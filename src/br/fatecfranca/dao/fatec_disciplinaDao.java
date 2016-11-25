package br.fatecfranca.dao;
import java.sql.ResultSet;
import java.util.List;
import br.fatecfranca.model.fatec_disciplina;
import java.sql.PreparedStatement;
public class fatec_disciplinaDao extends ComumDao { 

	public fatec_disciplina GetById(int ID) throws Exception
	{
		try{
			PreparedStatement conn = BeginNewStatement("SELECT * FROM fatec_disciplina WHERE codigo = ID");
			ResultSet rs = conn.executeQuery();
			if(rs.next()){
				fatec_disciplina resposta = new fatec_disciplina();
				resposta.setCodigo(rs.getInt("codigo"));
				resposta.setNome(rs.getString("nome"));
				return resposta;
			};
			return null;
		}
		catch (Exception ex){
			throw ex;
		}
		finally {
			desconecta();
		}
	}
	public List<fatec_disciplina> GetAll() throws Exception
	{
		try{
			List<fatec_disciplina> lista = new java.util.ArrayList<fatec_disciplina>();

			PreparedStatement conn = BeginNewStatement("SELECT * FROM fatec_disciplina");
			ResultSet rs = conn.executeQuery();
			while(rs.next()){
				fatec_disciplina resposta = new fatec_disciplina();
				resposta.setCodigo(rs.getInt("codigo"));
				resposta.setNome(rs.getString("nome"));
				lista.add(resposta);
			};
			return lista;
		}
		catch (Exception ex){
			throw ex;
		}
		finally {
			desconecta();
		}
	}
	public void Add(fatec_disciplina entidade) throws Exception
	{
		try{
			PreparedStatement conn = BeginNewStatement("INSERT INTO fatec_disciplina (codigo, nome) values (?, ?)");
			conn.setInt(1, entidade.getCodigo());
			conn.setString(2, entidade.getNome());
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
	public void Update(fatec_disciplina entidade) throws Exception
	{
		try{
			PreparedStatement conn = BeginNewStatement("UPDATE fatec_disciplina SET codigo = ?, nome = ? WHERE codigo = " +  entidade.getCodigo());
			conn.setInt(1, entidade.getCodigo());
			conn.setString(2, entidade.getNome());
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
			PreparedStatement conn = BeginNewStatement("DELETE FROM fatec_disciplina WHERE codigo = ?");
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
