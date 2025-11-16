package org.acme.Service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.Model.DTO.TarefasDTO;
import org.acme.Model.Tarefas;
import org.acme.Repository.TarefasRepository;

import java.sql.SQLException;
import java.util.List;

@ApplicationScoped
public class TarefaService {
    @Inject
    TarefasRepository tarefasRepository;


    //Inserir
    public void Inserir(TarefasDTO tarefa) throws SQLException {
        tarefasRepository.Inserir(tarefa);
    }

    //Listar
    public List<Tarefas> listar() throws SQLException{
        return tarefasRepository.lista();
    }

    //Atualzar

    public void Atualizar(int id_tarefa, TarefasDTO tarefasDTO) throws SQLException, IllegalArgumentException{
        if (id_tarefa < 0){
            throw new IllegalArgumentException("ID menor que 0");
        }
        tarefasRepository.Atualizar(id_tarefa,tarefasDTO);
    }


    //DELETE

    public void remove(int id_tarefas) throws SQLException, IllegalArgumentException,RuntimeException{
        if(id_tarefas < 0){
            throw new IllegalArgumentException("ID menor que 0");
        }
        tarefasRepository.remover(id_tarefas);
    }
}
