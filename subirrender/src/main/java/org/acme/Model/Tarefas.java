package org.acme.Model;

public class Tarefas {
    private int id_tarefa;
    private String nome_tarefa;
    private String epico;
    private String departamento;
    private String prioridade;
    private int id_funcionario;

    //Construtores


    public Tarefas() {
    }

    public Tarefas(int id_tarefa, String nome_tarefa, String epico, String departamento, String prioridade, int id_funcionario) {
        this.id_tarefa = id_tarefa;
        this.nome_tarefa = nome_tarefa;
        this.epico = epico;
        this.departamento = departamento;
        this.prioridade = prioridade;
        this.id_funcionario = id_funcionario;
    }

    //GET e SET


    public int getId_tarefa() {
        return id_tarefa;
    }

    public void setId_tarefa(int id_tarefa) {
        this.id_tarefa = id_tarefa;
    }

    public String getNome_tarefa() {
        return nome_tarefa;
    }

    public void setNome_tarefa(String nome_tarefa) {
        this.nome_tarefa = nome_tarefa;
    }

    public String getEpico() {
        return epico;
    }

    public void setEpico(String epico) {
        this.epico = epico;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }
}
