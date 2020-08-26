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
public class OrderRepository extends OrderDAO <Ordering, Long> {

    @PersistenceContext (unitName = "ds")
    private EntityManager em;

    public OrderRepository () {
    }

    @Override
    @Transactional
    public Ordering findById (Long id) {
        return em.find (Ordering.class, id);
    }

    @Override
    @Transactional
    public void updateOrd (Ordering ord) {
        em.merge (ord);
    }

    @Override
    @Transactional
    public void deleteOrd (Long id) {
        Ordering ordering = em.find (Ordering.class, id);
        em.remove (ordering);
    }

    @Override
    @Transactional
    public void insertOrd (Ordering ord) {
            em.persist(ord);
    }

    @Override
    @Transactional
    public List <Ordering> findAll () {
        CriteriaQuery <Ordering> query = em.getCriteriaBuilder().createQuery (Ordering.class);
        Root <Ordering> ordering = query.from(Ordering.class);
        query.select(ordering);
        return em.createQuery(query).getResultList();
    }
}
