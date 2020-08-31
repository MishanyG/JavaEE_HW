package HomeWork_4.Repositories;

import HomeWork_4.Category;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Stateless
public class CategoryRepository {

    @PersistenceContext (unitName = "ds")
    private EntityManager em;

    @EJB
    private ProductRepository productRepository;

    public CategoryRepository () {
    }

    @TransactionAttribute
    public void insertCat (Category category) {
        em.persist(category);
    }

    @TransactionAttribute
    public void updateCat (Category category) {
        em.merge(category);
    }

    @TransactionAttribute
    public void deleteCat (Long id) {
        Category category = em.find(Category.class, id);
        if (category != null) {
            em.remove(category);
        }
    }

    public Optional<Category> findById(Long id) {
        Category category = em.find(Category.class, id);
        if (category != null) {
            return Optional.of(category);
        }
        return Optional.empty();
    }

    public List <Category> findAll() {
        return em.createQuery("from Category ", Category.class)
                .getResultList();
    }

    public Optional <Category> findByName(String name) {
        Category category = em.createQuery("from Category c where c.category = :category", Category.class)
                .setParameter("category", name)
                .getSingleResult();
        if (category != null) {
            return Optional.of(category);
        } else {
            return Optional.empty();
        }
    }
}
