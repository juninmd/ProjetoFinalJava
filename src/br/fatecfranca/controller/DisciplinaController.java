package br.fatecfranca.controller;

import br.fatecfranca.dao.fatec_disciplinaDao;
import java.util.List;
import br.fatecfranca.model.fatec_disciplina;

public class DisciplinaController {

    public void Add(fatec_disciplina disciplina) throws Exception {
        fatec_disciplinaDao disciplinaDAOImpl = new fatec_disciplinaDao();
        disciplinaDAOImpl.Add(disciplina);
    }

    public List<fatec_disciplina> GetAll() throws Exception {
        fatec_disciplinaDao disciplinaDAOImpl = new fatec_disciplinaDao();
        return disciplinaDAOImpl.GetAll();
    }

    public void Delete(fatec_disciplina disciplina) throws Exception {
        fatec_disciplinaDao disciplinaDAOImpl = new fatec_disciplinaDao();
        disciplinaDAOImpl.Delete(disciplina.getCodigo());
    }

    public void Update(fatec_disciplina disciplina) throws Exception {
        fatec_disciplinaDao disciplinaDAOImpl = new fatec_disciplinaDao();
        disciplinaDAOImpl.Update(disciplina);
    }

}
