package br.fatecfranca.controller;

import br.fatecfranca.dao.fatec_professorDao;
import java.util.List;
import br.fatecfranca.model.fatec_professor;

public class ProfessorController {

    public void Add(fatec_professor professor) throws Exception {
        fatec_professorDao professorDAOImpl = new fatec_professorDao();
        professorDAOImpl.Add(professor);
    }

    public List<fatec_professor> GetAll() throws Exception {
        fatec_professorDao professorDAOImpl = new fatec_professorDao();
        return professorDAOImpl.GetAll();
    }

    public void Delete(fatec_professor professor) throws Exception {
        fatec_professorDao professorDAOImpl = new fatec_professorDao();
        professorDAOImpl.Delete(professor.getCodigo());
    }

    public void Update(fatec_professor professor) throws Exception {
        fatec_professorDao professorDAOImpl = new fatec_professorDao();
        professorDAOImpl.Update(professor);
    }

}
