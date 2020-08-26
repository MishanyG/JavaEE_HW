package HomeWork_4;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Named
public class ProductRepository extends ProductDAO <Product, Long> {

    @PersistenceContext (unitName = "ds")
    private EntityManager em;

    public ProductRepository () {
    }

    @Override
    @Transactional
    public void insert (Product product) {
        em.persist(product);
    }

    @Override
    @Transactional
    public void update (Product product) {
        em.merge(product);
    }

    @Override
    @Transactional
    public void delete (Long id) {
        Product product = em.find(Product.class, id);
        em.remove(product);
    }

    @Override
    @Transactional
    public Product findById(Long id) {
        return em.find(Product.class, id);
    }

    @Override
    @Transactional
    public List <Product> findAll() {
        CriteriaQuery <Product> query = em.getCriteriaBuilder().createQuery (Product.class);
        Root <Product> product = query.from(Product.class);
        query.select(product);
        return em.createQuery(query).getResultList();
    }
}
