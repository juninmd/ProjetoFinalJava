package br.fatecfranca.controller;

import br.fatecfranca.dao.fatec_alunoDao;
import java.util.List;
import br.fatecfranca.model.fatec_aluno;

public class AlunoController {

    public void insere(fatec_aluno aluno) throws Exception {
        // controller acessando model
        fatec_alunoDao alunoDAOImpl = new fatec_alunoDao();
        // model retorna dados para controller
        alunoDAOImpl.Add(aluno);
    }

    public List<fatec_aluno> consulta() throws Exception {
        // controller acessando model
        fatec_alunoDao alunoDAOImpl = new fatec_alunoDao();
        // model retorna dados para controller
        return alunoDAOImpl.GetAll();
    }

    public void remove(fatec_aluno aluno) throws Exception {
        // controller acessando model
        fatec_alunoDao alunoDAOImpl = new fatec_alunoDao();
        // model retorna dados para controller
        alunoDAOImpl.Delete(aluno.getCodigo());
    }

    public void atualiza(fatec_aluno aluno) throws Exception {
        // controller acessando model
        fatec_alunoDao alunoDAOImpl = new fatec_alunoDao();
        // model retorna dados para controller
        alunoDAOImpl.Update(aluno);
    }

}
