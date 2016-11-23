package br.fatecfranca.model;

public class fatec_aluno {

    private int codigo;
    private String cidade;
    private String cpf;
    private String documentos;
    private String endereco;
    private String estado;
    private String nome;
    private String rg;
    private String sexo;

    /**
     *
     * @return @Descrição
     */
    public int getcodigo() {
        return codigo;
    }

    public void setcodigo(Integer codigo) {
        this.codigo = codigo;
    }

    /**
     *
     * @return @Descrição
     */
    public String getcidade() {
        return cidade;
    }

    public void setcidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     *
     * @return @Descrição
     */
    public String getcpf() {
        return cpf;
    }

    public void setcpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     *
     * @return @Descrição
     */
    public String getdocumentos() {
        return documentos;
    }

    public void setdocumentos(String documentos) {
        this.documentos = documentos;
    }

    /**
     *
     * @return @Descrição
     */
    public String getendereco() {
        return endereco;
    }

    public void setendereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     *
     * @return @Descrição
     */
    public String getestado() {
        return estado;
    }

    public void setestado(String estado) {
        this.estado = estado;
    }

    /**
     *
     * @return @Descrição
     */
    public String getnome() {
        return nome;
    }

    public void setnome(String nome) {
        this.nome = nome;
    }

    /**
     *
     * @return @Descrição
     */
    public String getrg() {
        return rg;
    }

    public void setrg(String rg) {
        this.rg = rg;
    }

    /**
     *
     * @return @Descrição
     */
    public String getsexo() {
        return sexo;
    }

    public void setsexo(String sexo) {
        this.sexo = sexo;
    }

}
