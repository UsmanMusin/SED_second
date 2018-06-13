package dao;

import model.Department;
import org.hibernate.Session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class DepartmentDAO {
    @PersistenceContext(unitName = "derby_DB")
    private EntityManager em;

    public DepartmentDAO(){
    }

    public void addDepartment(Department department){
        em.persist(department);
    }

    public Department getDepartment(long id){
        return em.find(Department.class, id);

    }

    public List<Department> getDepList(){
        return em.createQuery("select d from Department d",Department.class).getResultList();
    }

    public void updateDepartment(Department department){
        em.merge(department);
    }

    public void deleteDepartment(long id){
        Department dep = em.find(Department.class, id);
        em.remove(dep);
    }

}
