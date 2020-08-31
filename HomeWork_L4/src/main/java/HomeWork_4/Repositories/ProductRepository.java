package HomeWork_4.Repositories;

import HomeWork_4.Product;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Stateless
public class ProductRepository {

//    private static final Logger logger = LoggerFactory.getLogger(ProductRepository.class);

    @PersistenceContext (unitName = "ds")
    private EntityManager em;

    @EJB
    private CategoryRepository categoryRepository;

    public ProductRepository() {
    }

    public void insert(Product product) {
//        logger.info("Inserting new product");
        em.persist(product);
    }

    public void update(Product product) {
        em.merge(product);
    }

    public void delete(long id) {
        Product product = em.find(Product.class, id);
        if (product != null) {
            em.remove(product);
        }
    }

    public Optional<Product> findById(Long id) {
        Product product = em.find(Product.class, id);
        if (product != null) {
            return Optional.of(product);
        }
        return Optional.empty();
    }

    public List<Product> findAll() {
        CriteriaQuery <Product> query = em.getCriteriaBuilder().createQuery (Product.class);
        Root <Product> product = query.from(Product.class);
        query.select(product);
        return em.createQuery(query).getResultList();
    }
}
