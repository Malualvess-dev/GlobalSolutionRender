package org.acme.Model.DTO;

public class GerenteLoginDTO {
    public String cpf;
    public String senha;

    //Construtores


    public GerenteLoginDTO(String cpf, String senha) {
        this.cpf = cpf;
        this.senha = senha;
    }

    public GerenteLoginDTO() {
    }

    //GET e set


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
