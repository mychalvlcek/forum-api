package cz.cvut.fel.wa2.forum.api;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import cz.cvut.fel.wa2.forum.dto.*;
import cz.cvut.fel.wa2.forum.service.*;
import cz.cvut.fel.wa2.forum.websocket.Producer;

import java.util.List;

@Path(value = "topic")
public class TopicResource {

    private final TopicService service;

    public TopicResource() {
        this.service = new TopicServiceImpl();
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
    @Path("/category/{id}")
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
    public Response save(TopicDTO dto) {
        Long id = service.save(dto);
        try {
            Producer producer = new Producer("queue");
            System.out.println(id);
            producer.sendMessage(id);
            producer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Response.status(Status.OK).entity("Successfully saved").type(MediaType.APPLICATION_JSON).build();
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    @RolesAllowed("admin")
    public Response update(@PathParam("id") Long id, TopicDTO dto) {
        dto.setId(id);
        service.save(dto);
        return Response.status(Status.OK).entity("Successfully updated").type(MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public TopicDTO get(@PathParam("id") Long id) {
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
