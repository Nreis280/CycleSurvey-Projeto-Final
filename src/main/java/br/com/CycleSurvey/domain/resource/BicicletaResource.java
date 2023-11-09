package br.com.CycleSurvey.domain.resource;


import br.com.CycleSurvey.domain.entity.Bicicleta;

import br.com.CycleSurvey.domain.service.BicicletaService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.net.URI;
import java.util.List;
import java.util.Objects;

@Path("bicicleta/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)



public class BicicletaResource implements Resource<Bicicleta, Long>{

    @Context
    UriInfo uriInfo;

    BicicletaService service = new BicicletaService();

    @GET
    @Override
    public Response findAll() {
        List<Bicicleta> all = service.findAll();
        return Response.ok( all ).build();
    }


    @GET
    @Path("/{id}")
    @Override
    public Response findById(@PathParam("id") Long id) {

        Bicicleta bc = service.findById( id );

        if (Objects.isNull( bc )) return Response.status( 404 ).build();

        return Response.ok( bc ).build();
    }

    @POST
    @Override
    public Response persiste(Bicicleta bc) {
        bc.setId( null );
        Bicicleta bicicleta = service.persiste( bc );

        if (Objects.isNull( bicicleta.getId() ))
            return Response.notModified( "Não foi possível persistir: " + bc ).build();

        UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
        URI uri = uriBuilder.path( String.valueOf( bicicleta.getId() ) ).build();

        return Response.created( uri ).entity( bicicleta ).build();

    }






}
