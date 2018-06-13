package service;

import dao.EmployeeDAO;
import model.Employee;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

@Path("/employee")
@Stateless
public class EmployeeREST {

    @EJB
    private EmployeeDAO employeeDAO;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Employee getEmp(){
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("inef");
        employee.setMiddleName("efaef");
        return employee;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Employee getEmpById(@PathParam("id") long id){
        return employeeDAO.getEmployee(id);
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Employee> getEmpList(){
        return employeeDAO.getEmpList();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addEmp(Employee employee){

        employeeDAO.addEmployee(employee);
        return Response.status(200).type("application/json").entity(employee).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateEmp(Employee employee){
        employeeDAO.updateEmployee(employee);
        return Response.status(200).type("application/json").entity(employee).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteEmp(@PathParam("id") long id){
        employeeDAO.deleteEmployee(id);
        return Response.status(200).build();
    }

}