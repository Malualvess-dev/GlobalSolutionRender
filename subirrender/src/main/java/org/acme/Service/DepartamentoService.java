package org.acme.Service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.Model.DTO.DepartamentoDTO;
import org.acme.Model.Departamento;
import org.acme.Repository.DepartamentoRepository;

import java.sql.SQLException;
import java.util.List;

@ApplicationScoped
public class DepartamentoService {
    @Inject
    DepartamentoRepository departamentoRepository;

    //Inserir
    public void Inserir(DepartamentoDTO departamento) throws SQLException {
        departamentoRepository.Inserir(departamento);
    }

    //Listar
    public List<Departamento> listar() throws SQLException{
        return departamentoRepository.lista();
    }

    //Atualzar

    public void Atualizar(int id_departamento, DepartamentoDTO departamentoDTO) throws SQLException, IllegalArgumentException{
        if (id_departamento < 0){
            throw new IllegalArgumentException("ID menor que 0");
        }
        departamentoRepository.Atualizar(id_departamento,departamentoDTO);
    }


    //DELETE

    public void remove(int id_gerente) throws SQLException, IllegalArgumentException,RuntimeException{
        if(id_gerente < 0){
            throw new IllegalArgumentException("ID menor que 0");
        }
        departamentoRepository.remover(id_gerente);
    }
}
