package org.acme.Service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.Model.Cadastro_Gerente;
import org.acme.Model.DTO.Cadastro_GerenteDTO;
import org.acme.Repository.Cadastro_GerenteRepository;

import java.sql.SQLException;
import java.util.List;

@ApplicationScoped
public class Cadastro_GerenteService {
    @Inject
    Cadastro_GerenteRepository cadastroGerenteRepository;

    //Inserir
    public void Inserir(Cadastro_GerenteDTO gerente) throws SQLException {
        cadastroGerenteRepository.Inserir(gerente);
    }

    //Listar
    public List<Cadastro_Gerente> listar() throws SQLException{
        return cadastroGerenteRepository.listar();
    }

    //Atualzar

    public void AtualizarSenha(int id_gerente, Cadastro_GerenteDTO gerente ) throws SQLException, IllegalArgumentException{
        ValidacaoSenha(gerente);
        if (id_gerente < 0){
            throw new IllegalArgumentException("ID menor que 0");
        }
        cadastroGerenteRepository.AtualizarSenha(id_gerente,gerente);
    }


    //DELETE

    public void remove(int id_gerente) throws SQLException, IllegalArgumentException,RuntimeException{
        if(id_gerente < 0){
            throw new IllegalArgumentException("ID menor que 0");
        }
        cadastroGerenteRepository.remover(id_gerente);
    }



    //Validação
    public void ValidacaoSenha(Cadastro_GerenteDTO gerente){
        if(gerente == null || gerente.getSenha().isEmpty()){
            throw new IllegalArgumentException("Senha incorreta");
        }
    }
}
