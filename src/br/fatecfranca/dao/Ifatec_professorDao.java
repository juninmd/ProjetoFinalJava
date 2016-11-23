package br.fatecfranca.dao;

import br.fatecfranca.model.fatec_professor;
import java.util.List;

public interface Ifatec_professorDao {

    public void Add(fatec_professor aluno) throws Exception;

    public void Delete(int id) throws Exception;

    public void Update(fatec_professor aluno) throws Exception;

    public List<fatec_professor> GetAll() throws Exception;

    public fatec_professor GetById(int id) throws Exception;

}
