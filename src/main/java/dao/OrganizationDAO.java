package dao;

import model.Organization;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class OrganizationDAO {
    @PersistenceContext(unitName = "derby_DB")
    private EntityManager em;

    public OrganizationDAO(){

    }

    public void addOrganization(Organization organization){
        em.persist(organization);
    }

    public Organization getOrganization(long id){
        return em.find(Organization.class, id);
    }

    public List<Organization> getOrgList(){
        return em.createQuery("select o from Organization o",Organization.class).getResultList();
    }

    public void updateOrganization(Organization organization){
        em.merge(organization);
    }

    public void deleteOrganization(long id){
        Organization org = em.find(Organization.class, id);
        em.remove(org);
    }



}