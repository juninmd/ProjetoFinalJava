package br.fatecfranca.dao;

import br.fatecfranca.model.fatec_disciplina;
import java.util.List;

public interface Ifatec_disciplinaDao {

    public void Add(fatec_disciplina aluno) throws Exception;

    public void Delete(int id) throws Exception;

    public void Update(fatec_disciplina aluno) throws Exception;

    public List<fatec_disciplina> GetAll() throws Exception;

    public fatec_disciplina GetById(int id) throws Exception;

}
