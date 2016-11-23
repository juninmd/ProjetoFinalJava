package br.fatecfranca.dao;

import br.fatecfranca.model.fatec_aluno;
import java.util.List;

public interface Ifatec_alunoDao {

    public void Add(fatec_aluno aluno) throws Exception;

    public void Delete(int id) throws Exception;

    public void Update(fatec_aluno aluno) throws Exception;

    public List<fatec_aluno> GetAll() throws Exception;

    public fatec_aluno GetById(int id) throws Exception;

}
