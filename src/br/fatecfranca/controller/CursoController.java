package br.fatecfranca.controller;

import br.fatecfranca.dao.fatec_cursoDao;
import java.util.List;
import br.fatecfranca.model.fatec_curso;

public class CursoController {

    public void Add(fatec_curso curso) throws Exception {
        fatec_cursoDao cursoDAOImpl = new fatec_cursoDao();
        cursoDAOImpl.Add(curso);
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
