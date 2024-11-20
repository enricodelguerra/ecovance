package br.com.fiap.resource;

import br.com.fiap.bo.PrevisaoBO;
import br.com.fiap.exceptions.PrevisaoNaoEncontradaException;
import br.com.fiap.to.PrevisaoTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/ecovance/previsao")
public class PrevisaoResource {
    private PrevisaoBO previsaoBO = new PrevisaoBO();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<PrevisaoTO> resultado = previsaoBO.findAll();
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok(); // 200 - OK
        } else {
            throw new PrevisaoNaoEncontradaException("Nenhuma previsão encontrada."); // 404 - NOT FOUND
        }
        response.entity(resultado);
        return response.build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Long id) {
        PrevisaoTO resultado = previsaoBO.findById(id);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok(); // 200 (OK)
        } else {
            throw new PrevisaoNaoEncontradaException("Previsão com id " + id + " não encontrada."); // 404 (NOT FOUND)
        }
        response.entity(resultado);
        return response.build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(@Valid PrevisaoTO previsao) {
        PrevisaoTO resultado = previsaoBO.save(previsao);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.created(null); // 201 - CREATED
        } else {
           response = Response.status(400); // 401 - BAD REQUEST
        }
        response.entity(resultado);
        return response.build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id ) {
        Response.ResponseBuilder response = null;
        if (previsaoBO.delete(id)) {
            response = Response.status(204); // 204 - NO CONTENT
        } else {
            throw new PrevisaoNaoEncontradaException("Previsão com id " + id + " não encontrada para exclusão."); // 404 - NOT FOUND
        }
        return response.build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response edit(@Valid PrevisaoTO previsao, @PathParam("id") Long id) {
        previsao.setIdPrevisao(id);
        PrevisaoTO resultado = previsaoBO.edit(previsao);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.created(null); // 201 - CREATED
        } else {
            response = Response.status(400); // - BAD REQUEST
        }
        return response.build();
    }

}
