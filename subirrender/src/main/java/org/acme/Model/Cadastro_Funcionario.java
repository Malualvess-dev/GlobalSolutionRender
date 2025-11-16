package org.acme.Model;

public class Cadastro_Funcionario {
    private int id_funcionaro;
    private String cpf;
    private String nome;
    private String email;
    private String telefone;
    private String senha;
    private String departamento;
    private String dt_nascimento;
    private int id_gerente;
    private int id_departamento;

    // Construtores


    public Cadastro_Funcionario() {
    }

    public Cadastro_Funcionario(int id_funcionaro, String cpf, String nome, String email, String telefone, String senha, String departamento, String dt_nascimento, int id_gerente, int id_departamento) {
        this.id_funcionaro = id_funcionaro;
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
        this.departamento = departamento;
        this.dt_nascimento = dt_nascimento;
        this.id_gerente = id_gerente;
        this.id_departamento = id_departamento;
    }

    // GET e SET


    public int getId_funcionaro() {
        return id_funcionaro;
    }

    public void setId_funcionaro(int id_funcionaro) {
        this.id_funcionaro = id_funcionaro;
    }

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

    public int getId_gerente() {
        return id_gerente;
    }

    public void setId_gerente(int id_gerente) {
        this.id_gerente = id_gerente;
    }

    public int getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }
}
