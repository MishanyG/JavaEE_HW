package HomeWork_4;

import javax.persistence.*;
import java.io.Serializable;

@Entity (name = "Ord")
@Table (name = "ordering")
@NamedQuery(name = "Ordering.findAll", query = "from Ord")
public class Ordering implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long order_id;

    @Column(name = "product_id", nullable = false, insertable = false, updatable = false)
    private Long product_id;

    @Column(name = "count", nullable = false)
    private Long count;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Ordering () {
    }

    public Ordering (Long order_id, Long product_id, Long count) {
        this.order_id = order_id;
        this.product_id = product_id;
        this.count = count;
    }

    public Long getOrder_id () {
        return order_id;
    }

    public Ordering setOrder_id (Long order_id) {
        this.order_id = order_id;
        return this;
    }

    public void setProducts (Product products) {
        this.product = products;
    }

    public Ordering setCount (Long count) {
        this.count = count;
        return this;
    }

    public void setOrder_idf (Long order_id) {
        this.order_id = order_id;
    }

    public void setProduct_idf (Long product_id) {
        this.product_id = product_id;
    }

    public void setCountf (Long count) {
        this.count = count;
    }

    public Long getProduct_id () {
        return product_id;
    }

    public Ordering setProduct_id (Long product_id) {
        this.product_id = product_id;
        return this;
    }

    public Long getCount () {
        return count;
    }

    public Product getProducts () {
        return product;
    }
}