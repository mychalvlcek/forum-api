package cz.cvut.fel.aos.forum.api;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import cz.cvut.fel.aos.forum.dto.*;
import cz.cvut.fel.aos.forum.service.*;

import java.util.List;

@Path(value = "post")
public class PostResource {

    private final PostService service;

    public PostResource() {
        this.service = new PostServiceImpl();
    }

    @GET
    @Path("/")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getRecords() {
        List result = null;
        result = service.getAll();

        Response.ResponseBuilder rb = Response.status(Status.OK);
        rb.header("X-Count-records", service.getCount());
        rb.entity(result);
        return  rb.build();
    }

    @GET
    @Path("/topic/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getFiltered(@PathParam("id") Long id) {
        List result = null;
        result = service.find(id);

        Response.ResponseBuilder rb = Response.status(Status.OK);
        rb.entity(result);
        return  rb.build();
    }

    @POST
    @Path("/")
    @Consumes({MediaType.APPLICATION_JSON})
    @RolesAllowed("admin")
    public Response save(PostDTO dto) {
        service.save(dto);
        return Response.status(Status.OK).entity("Successfully saved").type(MediaType.APPLICATION_JSON).build();
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    @RolesAllowed("admin")
    public Response update(@PathParam("id") Long id, PostDTO dto) {
        dto.setId(id);
        service.save(dto);
        return Response.status(Status.OK).entity("Successfully updated").type(MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public PostDTO get(@PathParam("id") Long id) {
        return service.get(id);
    }

    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @RolesAllowed("admin")
    public Response delete(@PathParam("id") Long id) {
        service.delete(id);
        return Response.status(Status.OK).entity("Successfully deleted").type(MediaType.APPLICATION_JSON).build();
    }

}
