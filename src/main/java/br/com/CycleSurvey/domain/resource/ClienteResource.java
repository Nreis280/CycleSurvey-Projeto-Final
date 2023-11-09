package br.com.CycleSurvey.domain.resource;


import br.com.CycleSurvey.domain.entity.Cliente;
import br.com.CycleSurvey.domain.service.ClienteService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.net.URI;
import java.util.List;
import java.util.Objects;

@Path("cliente/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)


public class ClienteResource implements Resource<Cliente, Long> {
    @Context
    UriInfo uriInfo;

    ClienteService service = new ClienteService();

    @GET
    @Override
    public Response findAll() {
        List<Cliente> all = service.findAll();
        return Response.ok( all ).build();
    }


    @GET
    @Path("/{id}")
    @Override
    public Response findById(@PathParam("id") Long id) {

        Cliente cliente = service.findById( id );

        if (Objects.isNull( cliente )) return Response.status( 404 ).build();

        return Response.ok( cliente ).build();
    }

    @POST
    @Override
    public Response persiste(Cliente cliente) {
        cliente.setId( null );
        Cliente pessoa = service.persiste( cliente );

        if (Objects.isNull( pessoa.getId() ))
            return Response.notModified( "Não foi possível persistir: " + cliente ).build();

        UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
        URI uri = uriBuilder.path( String.valueOf( pessoa.getId() ) ).build();

        return Response.created( uri ).entity( pessoa ).build();

    }

}