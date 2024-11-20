package br.com.fiap.resource;

import br.com.fiap.bo.AtividadeBO;
import br.com.fiap.exceptions.AtividadeNaoEncontradaException;
import br.com.fiap.exceptions.AtividadeNaoExcluidaException;
import br.com.fiap.exceptions.AtividadeValidationException;
import br.com.fiap.to.AtividadeTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/ecovance/atividade")
public class AtividadeResource {
    private AtividadeBO atividadeBO = new AtividadeBO();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() throws AtividadeNaoEncontradaException {
        ArrayList<AtividadeTO> resultado = atividadeBO.findAll();
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok(); //200 (OK)
        } else {
            response = Response.status(404); // 404 (NOT FOUND)
        }
        response.entity(resultado);
        return response.build();
    }
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Long id) throws AtividadeNaoEncontradaException {
        AtividadeTO resultado = atividadeBO.findById(id);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok(); // 200 (OK)
        } else {
            response = Response.status(404); // 404 (NOT FOUND)
        }
        response.entity(resultado);
        return response.build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(AtividadeTO atividade) throws AtividadeValidationException {
        AtividadeTO resultado = atividadeBO.save(atividade);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.created(null); // 201 - CREATED
        } else {
            response = Response.status(400);
        }
        response.entity(resultado);
        return response.build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) throws AtividadeNaoExcluidaException {
        Response.ResponseBuilder response = null;
        if (atividadeBO.delete(id)) {
            response = Response.status(204); // 204 - NO CONTENT
        } else {
            response = Response.status(404); // 404 - NOT FOUND
        }
        return response.build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response edit(@Valid AtividadeTO atividade, @PathParam("id") Long id) throws AtividadeValidationException {
        atividade.setIdAtividade(id);
        AtividadeTO resultado = atividadeBO.edit(atividade);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.created(null); // 201 - CREATED
        } else {
            response = Response.status(400);
        }
        return response.build();
    }
}
