package br.com.fiap.resource;

import br.com.fiap.bo.ProjetoBO;
import br.com.fiap.exceptions.*;
import br.com.fiap.to.ProjetoTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/ecovance")
public class ProjetoResource {
    private ProjetoBO projetoBO = new ProjetoBO();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() throws ProjetoNaoEncontradoException {
        ArrayList<ProjetoTO> resultado = projetoBO.findAll();
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
    public Response findById(@PathParam("id")Long id) throws ProjetoNaoEncontradoException {
        ProjetoTO resultado = projetoBO.findById(id);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok(); // 200 (OK)
        } else {
          response = Response.status(404); // 404 Not - Found
        }
        response.entity(resultado);
        return response.build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(ProjetoTO projeto) throws ProjetoValidationException {
        ProjetoTO resultado = projetoBO.save(projeto);
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
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) throws ProjetoNaoEncontradoException, ProjetoNaoExcluidoException {
        Response.ResponseBuilder response = null;
        if (projetoBO.delete(id)) {
            response = Response.status(204); // 204 - NO CONTENT
        } else {
            response = Response.status(404); // 404 - NOT FOUND
        }
        return response.build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response edit(@Valid ProjetoTO projeto, @PathParam("id") Long id) throws ProjetoValidationException {
        projeto.setIdProjeto(id);
        ProjetoTO resultado = projetoBO.edit(projeto);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.created(null); // 201 - CREATED
        } else {
            response = Response.status(400);
        }
        return response.build();
    }

}
