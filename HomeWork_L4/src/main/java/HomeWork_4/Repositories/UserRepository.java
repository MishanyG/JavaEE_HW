package HomeWork_4.Repositories;

import HomeWork_4.User;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class UserRepository {

    @PersistenceContext(unitName = "ds")
    private EntityManager em;

    @EJB
    private RoleRepository roleRepository;

    public UserRepository() {
    }

    @TransactionAttribute
    public void insertUser(User user) {
        em.persist(user);
    }

    @TransactionAttribute
    public void updateUser(User user) {
        em.merge(user);
    }

    @TransactionAttribute
    public void deleteUser(Long id) {
        User user = em.find(User.class, id);
        if(user != null) {
            em.remove(user);
        }
    }

    public List <User> findById(Long id) {
        return em.createQuery("from User u where u.user_id = :user_id", User.class).setParameter("user_id", id).getResultList();
    }

    public List <User> findAll() {
        return em.createQuery("from User ", User.class).getResultList();
    }

    public List <User> findByName(String login) {
        return em.createQuery("from User u where u.login= :login", User.class)
                .setParameter("login", login)
                .getResultList();
    }
}

