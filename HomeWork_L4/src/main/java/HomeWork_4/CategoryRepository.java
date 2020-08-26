package HomeWork_4;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Named
public class CategoryRepository extends CategoryDAO <Category, Long> {

    @PersistenceContext (unitName = "ds")
    private EntityManager em;

    public CategoryRepository () {
    }

    @Override
    @Transactional
    public void insertCat (Category category) {
        em.persist(category);
    }

    @Override
    @Transactional
    public void updateCat (Category category) {
        em.merge(category);
    }

    @Override
    @Transactional
    public void deleteCat (Long id) {
        Category category = em.find(Category.class, id);
        em.remove(category);
    }

    @Override
    @Transactional
    public Category findById(Long id) {
        return em.find(Category.class, id);
    }

    @Override
    @Transactional
    public List <Category> findAll() {
        return em.createQuery("from Cat", Category.class)
                .getResultList();
    }
}
