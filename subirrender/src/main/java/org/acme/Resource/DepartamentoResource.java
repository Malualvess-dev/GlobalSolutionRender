package org.acme.Resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.Model.DTO.DepartamentoDTO;
import org.acme.Model.Departamento;
import org.acme.Service.DepartamentoService;

import java.sql.SQLException;
import java.util.List;

@Path("/Departamentos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class DepartamentoResource {
    @Inject
    DepartamentoService departamentoService;

    //Criação de dados

    @POST
    public Response criar(DepartamentoDTO departamentoDTO){
        try {
            departamentoService.Inserir(departamentoDTO);
            return Response.status(Response.Status.CREATED).entity("Departamento cadastrado com sucesso!!").build();

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
            List<Departamento> listaDepartamento = departamentoService.listar();
            return  Response.status(Response.Status.OK).entity(listaDepartamento).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro de conexão com a Base de Dados").build();
        }
    }

    //Atualizar

    @PUT
    @Path("/{id_departamento}")
    public Response atualizar(@PathParam("id_departamento")int id_departamento, DepartamentoDTO departamentoDTO){
        try{
            departamentoService.Atualizar(id_departamento, departamentoDTO);
            return Response.status(Response.Status.OK).entity("Departamento com ID " + id_departamento + " foi atualizado").build();
        }catch (SQLException e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        } catch (IllegalArgumentException e){
            return  Response.status(422).entity(e.getMessage()).build();
        }
    }

    //DELETE


    @DELETE
    @Path("/{id_departamento}")
    public Response deletar(@PathParam("id_departamento") int id_departamento){
        try {
            departamentoService.remove(id_departamento);
            return Response.status(Response.Status.OK).entity("Deparmento removido com sucesso!!").build();
        } catch (SQLException e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }catch (IllegalArgumentException e){
            return Response.status(422).entity(e.getMessage()).build();
        }catch (RuntimeException e){
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
    }

}
