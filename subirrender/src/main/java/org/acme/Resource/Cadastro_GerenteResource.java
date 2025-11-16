package org.acme.Resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.Model.Cadastro_Gerente;
import org.acme.Model.DTO.Cadastro_GerenteDTO;
import org.acme.Service.Cadastro_GerenteService;

import java.sql.SQLException;
import java.util.List;

@Path("/Gerentes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Cadastro_GerenteResource {
    @Inject
    Cadastro_GerenteService cadastroGerenteService;


    //Criação de dados

    @POST
    public Response criar(Cadastro_GerenteDTO gerente){
        try {
            cadastroGerenteService.Inserir(gerente);
            return Response.status(Response.Status.CREATED).entity("Gerente cadastrado com sucesso!!").build();

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
            List<Cadastro_Gerente> listaGerente = cadastroGerenteService.listar();
            return  Response.status(Response.Status.OK).entity(listaGerente).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro de conexão com a Base de Dados").build();
        }
    }

    //Atualizar

    @PUT
    @Path("/{id_gerente}")
    public Response atualizar(@PathParam("id_gerente")int id_gerente, Cadastro_GerenteDTO gerente){
        try{
            cadastroGerenteService.AtualizarSenha(id_gerente, gerente);
            return Response.status(Response.Status.OK).entity("Gerente com ID " + id_gerente + " sua senha foi atualizada").build();
        }catch (SQLException e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        } catch (IllegalArgumentException e){
            return  Response.status(422).entity(e.getMessage()).build();
        }
    }

    //DELETE


    @DELETE
    @Path("/{id_gerente}")
    public Response deletar(@PathParam("id_gerente") int id_gerente){
        try {
            cadastroGerenteService.remove(id_gerente);
            return Response.status(Response.Status.OK).entity("Gerente removido com sucesso!!").build();
        } catch (SQLException e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }catch (IllegalArgumentException e){
            return Response.status(422).entity(e.getMessage()).build();
        }catch (RuntimeException e){
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
    }


}
