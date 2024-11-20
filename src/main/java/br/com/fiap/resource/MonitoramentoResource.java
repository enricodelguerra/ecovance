package br.com.fiap.resource;

import br.com.fiap.bo.MonitoramentoBO;
import br.com.fiap.exceptions.MonitoramentoNaoEncontradoException;
import br.com.fiap.exceptions.MonitoramentoNaoExcluidoException;
import br.com.fiap.exceptions.MonitoramentoValidationException;
import br.com.fiap.to.MonitoramentoTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/ecovance/monitoramento")
public class MonitoramentoResource {
    private MonitoramentoBO monitoramentoBO = new MonitoramentoBO();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() throws MonitoramentoNaoEncontradoException {
        ArrayList<MonitoramentoTO> resultado = monitoramentoBO.findAll();
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
    public Response findById(@PathParam("id") Long id) throws MonitoramentoNaoEncontradoException {
        MonitoramentoTO resultado = monitoramentoBO.findById(id);
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
    public Response save(MonitoramentoTO monitoramento) throws MonitoramentoValidationException {
        MonitoramentoTO resultado = monitoramentoBO.save(monitoramento);
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
    public Response delete(@PathParam("id") Long id) throws MonitoramentoNaoExcluidoException {
        Response.ResponseBuilder response = null;
        if (monitoramentoBO.delete(id)) {
            response = Response.status(204); // 204 - NO CONTENT
        } else {
            response = Response.status(404); // 404 - NOT FOUND
        }
        return response.build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response edit(@Valid MonitoramentoTO monitoramento, @PathParam("id") Long id) throws MonitoramentoValidationException {
    monitoramento.setIdMonitoramento(id);
    MonitoramentoTO resultado = monitoramentoBO.edit(monitoramento);
    Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.created(null); // 201 - CREATED
        } else {
            response = Response.status(400);
        }
        return response.build();
    }
}