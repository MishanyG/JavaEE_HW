package HomeWork_4.Repositories;

import HomeWork_4.Role;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class RoleRepository {

    @PersistenceContext(unitName = "ds")
    private EntityManager em;

    @EJB
    private UserRepository userRepository;

    public RoleRepository() {
    }

    @TransactionAttribute
    public void insertRole(Role role) {
        em.persist(role);
    }

    @TransactionAttribute
    public void updateRole(Role role) {
        em.merge(role);
    }

    @TransactionAttribute
    public void deleteRole(Long id) {
        Role role = em.find(Role.class, id);
        if(role != null) {
            em.remove(role);
        }
    }

    public List <Role> findById(Long id) {
        return em.createQuery("from Role r where r.role_id= :role_id", Role.class).setParameter("role_id", id).getResultList();
    }

    public List <Role> findAll() {
        return em.createQuery("from Role", Role.class).getResultList();
    }
}


