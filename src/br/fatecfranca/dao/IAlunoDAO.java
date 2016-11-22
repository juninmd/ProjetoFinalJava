

package br.fatecfranca.dao;
import br.fatecfranca.model.AlunoModel;
import java.util.List;
public interface IAlunoDAO {
    public int insere(AlunoModel aluno);
    public int remove(AlunoModel aluno);
    public int atualiza(AlunoModel aluno);
    public List<AlunoModel> consulta();
}
