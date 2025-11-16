package org.acme.Resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.Model.DTO.TarefasDTO;
import org.acme.Model.Tarefas;
import org.acme.Service.TarefaService;

import java.sql.SQLException;
import java.util.List;

@Path("/Tarefas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class TarefasResource {
    @Inject
    TarefaService tarefaService;


    //Criação de dados

    @POST
    public Response criar(TarefasDTO tarefa){
        try {
            tarefaService.Inserir(tarefa);
            return Response.status(Response.Status.CREATED).entity("Tarefa cadastrada com sucesso!!").build();

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
            List<Tarefas> listaTarefas = tarefaService.listar();
            return  Response.status(Response.Status.OK).entity(listaTarefas).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro de conexão com a Base de Dados").build();
        }
    }

    //Atualizar

    @PUT
    @Path("/{id_tarefa}")
    public Response atualizar(@PathParam("id_tarefa")int id_tarefa, TarefasDTO tarefa){
        try{
            tarefaService.Atualizar(id_tarefa, tarefa);
            return Response.status(Response.Status.OK).entity("Tarefa com ID " + id_tarefa + " sua prioridade foi atualizada").build();
        }catch (SQLException e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        } catch (IllegalArgumentException e){
            return  Response.status(422).entity(e.getMessage()).build();
        }
    }

    //DELETE


    @DELETE
    @Path("/{id_tarefa}")
    public Response deletar(@PathParam("id_tarefa") int id_tarefa){
        try {
            tarefaService.remove(id_tarefa);
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
