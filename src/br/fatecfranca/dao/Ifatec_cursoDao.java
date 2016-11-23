package br.fatecfranca.dao;

import br.fatecfranca.model.fatec_curso;
import java.util.List;

public interface Ifatec_cursoDao {

    public void Add(fatec_curso aluno) throws Exception;

    public void Delete(int id) throws Exception;

    public void Update(fatec_curso aluno) throws Exception;

    public List<fatec_curso> GetAll() throws Exception;

    public fatec_curso GetById(int id) throws Exception;

}
