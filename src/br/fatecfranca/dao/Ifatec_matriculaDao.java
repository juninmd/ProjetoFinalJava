package br.fatecfranca.dao;

import br.fatecfranca.model.fatec_matricula;
import java.util.List;

public interface Ifatec_matriculaDao {

    public void Add(fatec_matricula aluno) throws Exception;

    public void Delete(int id) throws Exception;

    public void Update(fatec_matricula aluno) throws Exception;

    public List<fatec_matricula> GetAll() throws Exception;

    public fatec_matricula GetById(int id) throws Exception;

}
