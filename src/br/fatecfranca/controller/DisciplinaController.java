package br.fatecfranca.controller;

import br.fatecfranca.dao.fatec_disciplinaDao;
import br.fatecfranca.dao.fatec_disciplina_professorDao;
import java.util.List;
import br.fatecfranca.model.fatec_disciplina;
import br.fatecfranca.model.fatec_disciplina_professor;

public class DisciplinaController {

    public void Add(fatec_disciplina disciplina, int IdProfessor) throws Exception {
        int idDisciplina = new fatec_disciplinaDao().Add(disciplina);
        new fatec_disciplina_professorDao().Add(new fatec_disciplina_professor() {
            {
                setIddisciplina(idDisciplina);
                setIdprofessor(IdProfessor);
            }
        });
    }

    public void Update(fatec_disciplina disciplina, int IdProfessor) throws Exception {
        new fatec_disciplinaDao().Update(disciplina);
        new fatec_disciplina_professorDao().Update(new fatec_disciplina_professor() {
            {
                setIddisciplina(disciplina.getCodigo());
                setIdprofessor(IdProfessor);
            }
        });
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
