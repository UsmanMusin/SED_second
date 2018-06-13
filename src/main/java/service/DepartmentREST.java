package service;


import dao.DepartmentDAO;
import model.Department;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

@Path("/department")
@Stateless
public class DepartmentREST {

    @EJB
    private DepartmentDAO departmentDAO;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Department getDepById(@PathParam("id") long id){
        return departmentDAO.getDepartment(id);
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Department> getDepList(){
        return departmentDAO.getDepList();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addDep(Department department){
        departmentDAO.addDepartment(department);
        return Response.status(200).type("application/json").entity(department).build();

    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateDep(Department department){
        departmentDAO.updateDepartment(department);
        return Response.status(200).type("application/json").entity(department).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteDep(@PathParam("id") long id){
        departmentDAO.deleteDepartment(id);
        return Response.status(200).build();

    }



}
