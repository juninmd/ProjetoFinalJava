
package br.fatecfranca.model;
public class AlunoModel {
    private int codigo;
    private String nome, endereco, cidade, estado, 
            sexo, rg, cpf, documentos;
    public AlunoModel() {
        this.codigo = 0;
        this.nome = "";
        this.endereco = "";
        this.cidade = "";
        this.estado = "";
        this.sexo = "";
        this.rg = "";
        this.cpf = "";
        this.documentos = "";
    }
    public AlunoModel(int codigo, String nome, String endereco, String cidade, 
         String estado, String sexo, String rg, String cpf, String documentos) {
        this.codigo = codigo;
        this.nome = nome;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.sexo = sexo;
        this.rg = rg;
        this.cpf = cpf;
        this.documentos = documentos;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getDocumentos() {
        return documentos;
    }
    public void setDocumentos(String documentos) {
        this.documentos = documentos;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getRg() {
        return rg;
    }
    public void setRg(String rg) {
        this.rg = rg;
    }
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
