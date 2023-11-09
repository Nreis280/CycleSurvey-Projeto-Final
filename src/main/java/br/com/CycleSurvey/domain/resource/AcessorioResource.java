package br.com.CycleSurvey.domain.resource;

import br.com.CycleSurvey.domain.entity.Acessorio;
import br.com.CycleSurvey.domain.service.AcessorioService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.net.URI;
import java.util.List;
import java.util.Objects;

@Path("acessorio/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)


public class AcessorioResource implements Resource<Acessorio, Long>{

    @Context
    UriInfo uriInfo;

    AcessorioService service = new AcessorioService();

    @GET
    @Override
    public Response findAll() {
        List<Acessorio> all = service.findAll();
        return Response.ok( all ).build();
    }


    @GET
    @Path("/{id}")
    @Override
    public Response findById(@PathParam("id") Long id) {

        Acessorio ac = service.findById( id );

        if (Objects.isNull( ac )) return Response.status( 404 ).build();

        return Response.ok( ac ).build();
    }

    @POST
    @Override
    public Response persiste(Acessorio ac) {
        ac.setId( null );
        Acessorio acessorio = service.persiste( ac );

        if (Objects.isNull( acessorio.getId() ))
            return Response.notModified( "Não foi possível persistir: " + ac ).build();

        UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
        URI uri = uriBuilder.path( String.valueOf( acessorio.getId() ) ).build();

        return Response.created( uri ).entity( acessorio ).build();

    }



}
