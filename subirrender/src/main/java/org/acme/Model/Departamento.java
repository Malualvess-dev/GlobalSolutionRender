package org.acme.Model;

public class Departamento {
    private int id_departamento;
    private String nome_departamento;
    private int id_gerente;

    //Construtores


    public Departamento() {
    }

    public Departamento(int id_departamento, String nome_departamento, int id_gerente) {
        this.id_departamento = id_departamento;
        this.nome_departamento = nome_departamento;
        this.id_gerente = id_gerente;
    }

    //GET E SET


    public int getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }

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
