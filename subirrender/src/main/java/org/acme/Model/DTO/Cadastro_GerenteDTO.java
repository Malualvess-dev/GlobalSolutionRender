package org.acme.Model.DTO;

public class Cadastro_GerenteDTO {
    private String cpf;
    private String nome;
    private String email;
    private String telefone;
    private String senha;
    private String departamento;
    private String dt_nascimento;

    //Construtores


    public Cadastro_GerenteDTO() {
    }

    public Cadastro_GerenteDTO(String cpf, String nome, String email, String telefone, String senha, String departamento, String dt_nascimento) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
        this.departamento = departamento;
        this.dt_nascimento = dt_nascimento;
    }

    //GET e SET


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(String dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }
}
