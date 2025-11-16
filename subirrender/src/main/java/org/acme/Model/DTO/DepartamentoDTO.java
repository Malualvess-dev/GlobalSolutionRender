package org.acme.Model.DTO;

public class DepartamentoDTO {
    private String nome_departamento;
    private int id_gerente;

    //Construtores


    public DepartamentoDTO() {
    }

    public DepartamentoDTO(String nome_departamento, int id_gerente) {
        this.nome_departamento = nome_departamento;
        this.id_gerente = id_gerente;
    }

    //GET e SET


    public String getNome_departamento() {
        return nome_departamento;
    }

    public void setNome_departamento(String nome_departamento) {
        this.nome_departamento = nome_departamento;
    }

    public int getId_gerente() {
        return id_gerente;
    }

    public void setId_gerente(int id_gerente) {
        this.id_gerente = id_gerente;
    }
}
