package org.acme.Model.DTO;

public class FuncionarioLoginDTO {
    public String cpf;
    public String senha;

    //Construtores


    public FuncionarioLoginDTO(String cpf, String senha) {
        this.cpf = cpf;
        this.senha = senha;
    }

    public FuncionarioLoginDTO() {
    }

    //Get e set


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
