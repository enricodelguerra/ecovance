package br.com.fiap.resource;

import br.com.fiap.bo.EnergiaBO;
import br.com.fiap.exceptions.EnergiaNaoEncontradaException;
import br.com.fiap.exceptions.EnergiaNaoExcluidaException;
import br.com.fiap.exceptions.EnergiaValidationException;
import br.com.fiap.to.EnergiaTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/ecovance/energia")
public class EnergiaResource {
    private EnergiaBO energiaBO = new EnergiaBO();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() throws EnergiaNaoEncontradaException {
        ArrayList<EnergiaTO> resultado = energiaBO.findAll();
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
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Long id) throws EnergiaNaoEncontradaException {
        EnergiaTO resultado = energiaBO.findById(id);
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
    public Response save(EnergiaTO energia) throws EnergiaValidationException {
        EnergiaTO resultado = energiaBO.save(energia);
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
    public Response delete(@PathParam("id") Long id) throws EnergiaNaoExcluidaException{
        Response.ResponseBuilder response = null;
        if (energiaBO.delete(id)) {
            response = Response.status(204); // 204 - NO CONTENT
        } else {
            response = Response.status(404); // 404 - NOT FOUND
        }
        return response.build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response edit(EnergiaTO energia, @PathParam("id") Long id) throws EnergiaValidationException {
        energia.setIdFonteEnergia(id);
        EnergiaTO resultado = energiaBO.edit(energia);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.created(null); // 201 - CREATED
        } else {
            response = Response.status(400);
        }
        return response.build();
    }
}
