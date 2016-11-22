
package br.fatecfranca.controller;
import br.fatecfranca.model.AlunoModel;
import br.fatecfranca.dao.AlunoDAO;
import java.util.List;
public class AlunoController {
    
    public int insere(AlunoModel aluno){
        // controller acessando model
        AlunoDAO alunoDAOImpl = new AlunoDAO();
        // model retorna dados para controller
        return alunoDAOImpl.insere(aluno);
    }
    
    public List<AlunoModel> consulta(){
        // controller acessando model
        AlunoDAO alunoDAOImpl = new AlunoDAO();
        // model retorna dados para controller
        return alunoDAOImpl.consulta();
    }
    
     public int remove(AlunoModel aluno){
        // controller acessando model
        AlunoDAO alunoDAOImpl = new AlunoDAO();
        // model retorna dados para controller
        return alunoDAOImpl.remove(aluno);
    }
    
    public int atualiza(AlunoModel aluno){
        // controller acessando model
        AlunoDAO alunoDAOImpl = new AlunoDAO();
        // model retorna dados para controller
        return alunoDAOImpl.atualiza(aluno);
    }
     
}
