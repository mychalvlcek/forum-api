package cz.cvut.fel.aos.forum.api;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import cz.cvut.fel.aos.forum.dto.UserDTO;
import cz.cvut.fel.aos.forum.service.UserService;
import cz.cvut.fel.aos.forum.service.UserServiceImpl;

import java.util.List;

@Path(value = "user")
public class UserResource {

    private final UserService service;

    public UserResource() {
        this.service = new UserServiceImpl();
    }

    /**
     * Returns all recourds based on filter.
     * @param filter filtering (e.g.: "dateOfDepartureFrom=2013-02-27T02:04:46+01:00,dateOfDepartureTo=2013-02-27T03:04:46+01:00")
     * @param order ordering (e.g.: "name:desc")
     * @param base paging param (e.g.: 10)
     * @param offset paging param (e.g.: 10)
     * @return List of records
     */
    @GET
    @Path("/")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getRecords(@HeaderParam("X-Filter") String filter,
                                    @HeaderParam("X-Order") String order,
                                    @HeaderParam("X-Base") String base,
                                    @HeaderParam("X-Offset") String offset
                                    ) {
        List result = null;
        int baseParam = service.getCount().intValue();
        int offsetParam = 0;
        if (base != null) {
            baseParam = Integer.valueOf(base);
        }
        if (offset != null) {
            offsetParam = Integer.valueOf(offset);
        }
        if (order == null) {
            order = "";
        }

        result = service.find(order, filter, Integer.valueOf(baseParam), Integer.valueOf(offsetParam));

        Response.ResponseBuilder rb = Response.status(Status.OK);
        rb.header("X-Count-records", service.getCount());
        rb.entity(result);
        return  rb.build();
    }

    /**
     * Save new record
     * @param dto record
     * @return response message
     */
    @POST
    @Path("/")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @RolesAllowed("admin")
    public Response save(UserDTO dto) {
        service.save(dto);
        return Response.status(Status.OK).entity("Successfully saved").type(MediaType.APPLICATION_JSON).build();
    }

    /**
     * Update existing record
     * @param id of edited record
     * @param dto record
     * @return response message
     */
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @RolesAllowed("admin")
    public Response update(@PathParam("id") Long id, UserDTO dto) {
        dto.setId(id);
        service.save(dto);
        return Response.status(Status.OK).entity("Successfully updated").type(MediaType.APPLICATION_JSON).build();
    }

    /**
     * Retrieve record specified by id
     * @param id of record
     * @return record
     */
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public UserDTO get(@PathParam("id") Long id) {
        return service.get(id);
    }

    /**
     * Remove record
     * @param id of record
     * @return message response
     */
    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @RolesAllowed("admin")
    public Response delete(@PathParam("id") Long id) {
        service.delete(id);
        return Response.status(Status.OK).entity("Successfully deleted").type(MediaType.APPLICATION_JSON).build();
    }

}
