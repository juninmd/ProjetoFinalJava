package br.fatecfranca.controller;

import br.fatecfranca.dao.fatec_matriculaDao;
import java.util.List;
import br.fatecfranca.model.fatec_matricula;

public class MatriculaController {

    public void Add(fatec_matricula matricula) throws Exception {
        fatec_matriculaDao matriculaDAOImpl = new fatec_matriculaDao();
        matriculaDAOImpl.Add(matricula);
    }

    public List<fatec_matricula> GetAll() throws Exception {
        fatec_matriculaDao matriculaDAOImpl = new fatec_matriculaDao();
        return matriculaDAOImpl.GetAll();
    }

    public void Delete(fatec_matricula matricula) throws Exception {
        fatec_matriculaDao matriculaDAOImpl = new fatec_matriculaDao();
        matriculaDAOImpl.Delete(matricula.getCodigo());
    }

    public void Update(fatec_matricula matricula) throws Exception {
        fatec_matriculaDao matriculaDAOImpl = new fatec_matriculaDao();
        matriculaDAOImpl.Update(matricula);
    }

}
