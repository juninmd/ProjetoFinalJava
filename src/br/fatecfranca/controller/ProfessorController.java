package br.fatecfranca.controller;

import br.fatecfranca.dao.fatec_professorDao;
import java.util.List;
import br.fatecfranca.model.fatec_professor;

public class ProfessorController {

    public void insere(fatec_professor professor) throws Exception {
        // controller acessando model
        fatec_professorDao professorDao = new fatec_professorDao();
        // model retorna dados para controller
        professorDao.Add(professor);
    }

    public List<fatec_professor> consulta() throws Exception {
        // controller acessando model
        fatec_professorDao professorDao = new fatec_professorDao();
        // model retorna dados para controller
        return professorDao.GetAll();
    }

    public void remove(fatec_professor professor) throws Exception {
        // controller acessando model
        fatec_professorDao professorDao = new fatec_professorDao();
        // model retorna dados para controller
        professorDao.Delete(professor.getCodigo());
    }

    public void atualiza(fatec_professor professor) throws Exception {
        // controller acessando model
        fatec_professorDao professorDao = new fatec_professorDao();
        // model retorna dados para controller
        professorDao.Update(professor);
    }

}
