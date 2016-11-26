package br.fatecfranca.controller;

import br.fatecfranca.dao.fatec_cursoDao;
import br.fatecfranca.dao.fatec_curso_disciplinaDao;
import java.util.List;
import br.fatecfranca.model.fatec_curso;
import br.fatecfranca.model.fatec_curso_disciplina;

public class CursoController {

    public void Add(fatec_curso curso, List<Integer> lista) throws Exception {
        int idCurso = new fatec_cursoDao().Add(curso);

        for (int i = 0; i < lista.size(); i++) {
            int idDisciplina = lista.get(i);
            new fatec_curso_disciplinaDao().Add(new fatec_curso_disciplina() {
                {
                    this.setIdcurso(idCurso);
                    this.setIddisciplina(idDisciplina);
                }
            });
        }
    }

    public List<fatec_curso> GetAll() throws Exception {
        fatec_cursoDao cursoDAOImpl = new fatec_cursoDao();
        return cursoDAOImpl.GetAll();
    }

    public void Delete(fatec_curso curso) throws Exception {
        fatec_cursoDao cursoDAOImpl = new fatec_cursoDao();
        cursoDAOImpl.Delete(curso.getCodigo());
    }

    public void Update(fatec_curso curso) throws Exception {
        fatec_cursoDao cursoDAOImpl = new fatec_cursoDao();
        cursoDAOImpl.Update(curso);
    }

}
