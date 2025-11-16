package org.acme.Service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.Model.Cadastro_Funcionario;
import org.acme.Model.DTO.Cadastro_FuncionarioDTO;
import org.acme.Repository.Cadastro_FuncionarioRepository;

import java.sql.SQLException;
import java.util.List;

@ApplicationScoped
public class Cadastro_FuncionarioService {
    @Inject
    Cadastro_FuncionarioRepository cadastroFuncionarioRepository;

    //Inserir
    public void Inserir(Cadastro_FuncionarioDTO funcionario) throws SQLException {
        cadastroFuncionarioRepository.Inserir(funcionario);
    }

    //Listar
    public List<Cadastro_Funcionario> listar() throws SQLException{
        return cadastroFuncionarioRepository.listar();
    }

    //Atualzar

    public void AtualizarSenha(int id_funcionario, Cadastro_FuncionarioDTO funcionario ) throws SQLException, IllegalArgumentException{
        ValidacaoSenha(funcionario);
        if (id_funcionario < 0){
            throw new IllegalArgumentException("ID menor que 0");
        }
        cadastroFuncionarioRepository.AtualizarSenha(id_funcionario,funcionario);
    }


    //DELETE

    public void remove(int id_funcionario) throws SQLException, IllegalArgumentException,RuntimeException{
        if(id_funcionario < 0){
            throw new IllegalArgumentException("ID menor que 0");
        }
        cadastroFuncionarioRepository.remover(id_funcionario);
    }



    //Validação
    public void ValidacaoSenha(Cadastro_FuncionarioDTO funcionario){
        if(funcionario == null || funcionario.getSenha().isEmpty()){
            throw new IllegalArgumentException("Senha incorreta");
        }
    }
}
