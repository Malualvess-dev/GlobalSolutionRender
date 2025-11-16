package org.acme.Model.DTO;

public class Gerenciador_HumorDTO {
    private double horas_sono;
    private String ambiente_trabalho;
    private int qtd_agua;
    private int qtd_estresse;
    private String pesquisa_clima;
    private int id_funcionario;

    //Construtores


    public Gerenciador_HumorDTO() {
    }

    public Gerenciador_HumorDTO(double horas_sono, String ambiente_trabalho, int qtd_agua, int qtd_estresse, String pesquisa_clima, int id_funcionario) {
        this.horas_sono = horas_sono;
        this.ambiente_trabalho = ambiente_trabalho;
        this.qtd_agua = qtd_agua;
        this.qtd_estresse = qtd_estresse;
        this.pesquisa_clima = pesquisa_clima;
        this.id_funcionario = id_funcionario;
    }

    //GET e SET


    public double getHoras_sono() {
        return horas_sono;
    }

    public void setHoras_sono(double horas_sono) {
        this.horas_sono = horas_sono;
    }

    public String getAmbiente_trabalho() {
        return ambiente_trabalho;
    }

    public void setAmbiente_trabalho(String ambiente_trabalho) {
        this.ambiente_trabalho = ambiente_trabalho;
    }

    public int getQtd_agua() {
        return qtd_agua;
    }

    public void setQtd_agua(int qtd_agua) {
        this.qtd_agua = qtd_agua;
    }

    public int getQtd_estresse() {
        return qtd_estresse;
    }

    public void setQtd_estresse(int qtd_estresse) {
        this.qtd_estresse = qtd_estresse;
    }

    public String getPesquisa_clima() {
        return pesquisa_clima;
    }

    public void setPesquisa_clima(String pesquisa_clima) {
        this.pesquisa_clima = pesquisa_clima;
    }

    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }
}
