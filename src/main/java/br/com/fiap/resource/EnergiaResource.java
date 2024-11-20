package br.com.fiap.resource;

import br.com.fiap.bo.EnergiaBO;
import br.com.fiap.exceptions.EnergiaNaoEncontradaException;
import br.com.fiap.exceptions.EnergiaNaoExcluidaException;
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
    public Response findAll() {
        ArrayList<EnergiaTO> resultado = energiaBO.findAll();
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok(); //200 (OK)
        } else {
            throw new EnergiaNaoEncontradaException("Nenhuma energia encontrada."); // 404 (NOT FOUND)
        }
        response.entity(resultado);
        return response.build();
    }
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Long id) {
        EnergiaTO resultado = energiaBO.findById(id);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok(); // 200 (OK)
        } else {
            throw new EnergiaNaoEncontradaException("Energia com ID " + id + " não encontrada."); // 404 (NOT FOUND)
        }
        response.entity(resultado);
        return response.build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(EnergiaTO energia) {
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
    public Response delete(@PathParam("id") Long id) {
        Response.ResponseBuilder response = null;
        if (energiaBO.delete(id)) {
            response = Response.status(204); // 204 - NO CONTENT
        } else {
            throw new EnergiaNaoExcluidaException("Erro ao excluir a energia com ID " + id + "."); // 404 - NOT FOUND
        }
        return response.build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response edit(EnergiaTO energia, @PathParam("id") Long id) {
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
