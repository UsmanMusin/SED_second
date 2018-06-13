package dao;

import model.Assignment;
import org.hibernate.Session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class AssignmentDAO {
    @PersistenceContext(unitName = "derby_DB")
    private EntityManager em;

    public AssignmentDAO(){

    }

    public void addAssignment(Assignment assignment){
        em.persist(assignment);
    }

    public Assignment getAssignment(long id){
        return em.find(Assignment.class, id);
    }

    public List<Assignment> getAssignList(){
        return em.createQuery("select a from Assignment a",Assignment.class).getResultList();
    }

    public void updateAssignment(Assignment assignment){
        em.merge(assignment);
    }

    public void deleteAssignment(long id){
        Assignment assign = em.find(Assignment.class, id);
        em.remove(assign);
    }
}