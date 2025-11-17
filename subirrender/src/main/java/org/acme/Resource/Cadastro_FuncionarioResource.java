package org.acme.Resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.Model.Cadastro_Funcionario;
import org.acme.Model.DTO.Cadastro_FuncionarioDTO;
import org.acme.Service.Cadastro_FuncionarioService;

import java.sql.SQLException;
import java.util.List;

@Path("/Funcionarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Cadastro_FuncionarioResource {

    @Inject
    Cadastro_FuncionarioService cadastroFuncionarioService;

    // Inserção de dados

    @POST
    public Response criar(Cadastro_FuncionarioDTO funcionario){
        try {
            cadastroFuncionarioService.Inserir(funcionario);
            return Response.status(Response.Status.CREATED).entity("Funcionaro cadastrado com sucesso!!").build();

        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro com a base de dados").build();

        } catch (IllegalArgumentException e){
            return Response.status(422).entity(e.getMessage()).build();
        }
    }

    //Listar

    @GET
    public Response listar(){
        try{
            List<Cadastro_Funcionario> listaFuncionario = cadastroFuncionarioService.listar();
            return  Response.status(Response.Status.OK).entity(listaFuncionario).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro de conexão com a Base de Dados").build();
        }
    }

    //Atualizar

    @PUT
    @Path("/{id_funcionario}")
    public Response atualizar(@PathParam("id_funcionario")int id_funcionario, Cadastro_FuncionarioDTO funcionario){
        try{
            cadastroFuncionarioService.AtualizarSenha(id_funcionario, funcionario);
            return Response.status(Response.Status.OK).entity("Funcionario com ID " + id_funcionario + " sua senha foi atualizada").build();
        }catch (SQLException e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        } catch (IllegalArgumentException e){
            return  Response.status(422).entity(e.getMessage()).build();
        }
    }

    //DELETE


    @DELETE
    @Path("/{id_funcionario}")
    public Response deletar(@PathParam("id_funcionario") int id_funcionario){
        try {
            cadastroFuncionarioService.remove(id_funcionario);
            return Response.status(Response.Status.OK).entity("Funcionario removido com sucesso!!").build();
        } catch (SQLException e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }catch (IllegalArgumentException e){
            return Response.status(422).entity(e.getMessage()).build();
        }catch (RuntimeException e){
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
    }

    // -------------------------
    //  Login Funcionario
    // -------------------------
    @POST
    @Path("/loginFuncionario")
    public Response login(LoginRequest login) {

        try {
            Cadastro_Funcionario f = cadastroFuncionarioService.loginFuncionario(login.cpf, login.senha);

            if (f == null) {
                return Response.status(Response.Status.UNAUTHORIZED)
                        .entity("CPF ou senha inválidos!")
                        .build();
            }

            return Response.ok("Bem vindo usuario").build();

        } catch (SQLException e) {
            return Response.serverError().entity("Erro: " + e.getMessage()).build();
        }
    }

    // DTO interno para LOGIN
    public static class LoginRequest {
        public String cpf;
        public String senha;
    }

}
