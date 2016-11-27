package br.fatecfranca.model;

public class fatec_matricula {

    private int codigo;
    private int idAluno;
    private int idCurso;
    private String dtMatricula;
    private String periodo;
    private String nome;
    private String curso;

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     *
     * @return @Descrição
     */
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     *
     * @return @Descrição
     */
    public int getIdaluno() {
        return idAluno;
    }

    public void setIdaluno(int idAluno) {
        this.idAluno = idAluno;
    }

    /**
     *
     * @return @Descrição
     */
    public int getIdcurso() {
        return idCurso;
    }

    public void setIdcurso(int idCurso) {
        this.idCurso = idCurso;
    }

    /**
     *
     * @return @Descrição
     */
    public String getDtmatricula() {
        return dtMatricula;
    }

    public void setDtmatricula(String dtMatricula) {
        this.dtMatricula = dtMatricula;
    }

    /**
     *
     * @return @Descrição
     */
    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

}
