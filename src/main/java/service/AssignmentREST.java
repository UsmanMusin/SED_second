package service;

import dao.AssignmentDAO;
import model.Assignment;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

@Path("/assignment")
@Stateless
public class AssignmentREST {

    @EJB
    private AssignmentDAO assignmentDAO;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Assignment getAssignById(@PathParam("id") long id){
        return assignmentDAO.getAssignment(id);
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Assignment> getAssignList(){
        return assignmentDAO.getAssignList();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addAssign(Assignment assignment){
        assignmentDAO.addAssignment(assignment);
        return Response.status(200).type("application/json").entity(assignment).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateAssign(Assignment assignment){
        assignmentDAO.updateAssignment(assignment);
        return Response.status(200).type("application/json").entity(assignment).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteAssign(@PathParam("id") long id){
        assignmentDAO.deleteAssignment(id);
        return Response.status(200).build();
    }

}