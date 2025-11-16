package org.acme.Resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.Model.DTO.Gerenciador_HumorDTO;
import org.acme.Model.Gerenciador_Humor;
import org.acme.Service.Gerenciador_HumorService;

import java.sql.SQLException;
import java.util.List;

@Path("/Gerenciador_Humor")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class Gerenciador_HumorResource {
    @Inject
    Gerenciador_HumorService gerenciadorHumorService;

    // Inserção de dados

    @POST
    public Response criar(Gerenciador_HumorDTO humor){
        try {
            gerenciadorHumorService.Inserir(humor);
            return Response.status(Response.Status.CREATED).entity("Humor cadastrado com sucesso!!").build();

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
            List<Gerenciador_Humor> listaHumor = gerenciadorHumorService.listar();
            return  Response.status(Response.Status.OK).entity(listaHumor).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro de conexão com a Base de Dados").build();
        }
    }

}
