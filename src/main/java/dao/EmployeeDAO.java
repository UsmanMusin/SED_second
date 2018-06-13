package dao;

import model.Employee;
import org.hibernate.Session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
public class EmployeeDAO {
    @PersistenceContext(unitName = "derby_DB")
    private EntityManager em;

    public EmployeeDAO(){
    }

    public void addEmployee(Employee employee){
        em.persist(employee);
    }

    public Employee getEmployee(long id){
        return em.find(Employee.class, id);
    }


    public List<Employee> getEmpList(){
        return em.createQuery("select e from Employee e",Employee.class).getResultList();
    }


    public void updateEmployee(Employee employee){
        em.merge(employee);
    }

    public void deleteEmployee(long id){
        Employee emp = em.find(Employee.class, id);
        em.remove(emp);
    }

}
