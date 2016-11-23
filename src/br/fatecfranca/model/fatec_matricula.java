package br.fatecfranca.model;

import java.util.Date;

public class fatec_matricula {

    private Integer codigo;
    private Integer codigoaluno;
    private Integer codigocurso;
    private Date matricula;

    /**
     *
     * @return @Descrição
     */
    public Integer getcodigo() {
        return codigo;
    }

    public void setcodigo(Integer codigo) {
        this.codigo = codigo;
    }

    /**
     *
     * @return @Descrição
     */
    public Integer getcodigoaluno() {
        return codigoaluno;
    }

    public void setcodigoaluno(Integer codigoaluno) {
        this.codigoaluno = codigoaluno;
    }

    /**
     *
     * @return @Descrição
     */
    public Integer getcodigocurso() {
        return codigocurso;
    }

    public void setcodigocurso(Integer codigocurso) {
        this.codigocurso = codigocurso;
    }

    /**
     *
     * @return @Descrição
     */
    public Date getmatricula() {
        return matricula;
    }

    public void setmatricula(Date matricula) {
        this.matricula = matricula;
    }

}
