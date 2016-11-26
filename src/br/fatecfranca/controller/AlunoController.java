package br.fatecfranca.controller;

import br.fatecfranca.dao.fatec_alunoDao;
import java.util.List;
import br.fatecfranca.model.fatec_aluno;

public class AlunoController {

    public void Add(fatec_aluno aluno) throws Exception {
        fatec_alunoDao alunoDAOImpl = new fatec_alunoDao();
        alunoDAOImpl.Add(aluno);
    }

    public List<fatec_aluno> GetAll() throws Exception {
        fatec_alunoDao alunoDAOImpl = new fatec_alunoDao();
        return alunoDAOImpl.GetAll();
    }

    public void Delete(fatec_aluno aluno) throws Exception {
        fatec_alunoDao alunoDAOImpl = new fatec_alunoDao();
        alunoDAOImpl.Delete(aluno.getCodigo());
    }

    public void Update(fatec_aluno aluno) throws Exception {
        fatec_alunoDao alunoDAOImpl = new fatec_alunoDao();
        alunoDAOImpl.Update(aluno);
    }

}
