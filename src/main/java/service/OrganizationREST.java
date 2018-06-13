package service;

import dao.OrganizationDAO;
import model.Organization;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

@Path("/organization")
@Stateless
public class OrganizationREST {

    @EJB
    private OrganizationDAO organizationDAO;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Organization getOrgById(@PathParam("id") long id){
        return organizationDAO.getOrganization(id);
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Organization> getOrgList(){
        return organizationDAO.getOrgList();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addOrg(Organization organization){
        organizationDAO.addOrganization(organization);
        return Response.status(200).type("application/json").entity(organization).build();

    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateOrg(Organization organization){
        organizationDAO.updateOrganization(organization);
        return Response.status(200).type("application/json").entity(organization).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteOrg(@PathParam("id") long id){
        organizationDAO.deleteOrganization(id);
        return Response.status(200).build();

    }



}
