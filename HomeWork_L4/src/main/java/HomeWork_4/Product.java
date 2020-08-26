package HomeWork_4;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity (name = "Prod")
@Table (name = "product")
public class Product implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long product_id;

    @Column(name = "category_id", insertable = false, updatable = false)
    private Long category_id;

    @Column(name = "firm", length = 255, nullable = false)
    private String firm;

    @Column(name = "model", length = 255, nullable = false)
    private String model;

    @Column(name = "price", scale = 2, precision = 10)
    private BigDecimal price;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany (fetch = FetchType.LAZY, mappedBy = "product")
    private List <Ordering> orderings;

    public Product() {
    }

    public Product (Long product_id, String firm, String model, BigDecimal price) {
        this.product_id = product_id;
        this.firm = firm;
        this.model = model;
        this.price = price;
    }

    public Long getId() {
        return product_id;
    }

    public void setId(Long id) {
        this.product_id = id;
    }

    public Long getProduct_id () {
        return product_id;
    }

    public void setProduct_id (Long product_id) {
        this.product_id = product_id;
    }

    public Long getCategory_id () {
        return category_id;
    }

    public void setCategory_id (Long category_id) {
        this.category_id = category_id;
    }

    public Category getCategory () {
        return category;
    }

    public void setCategory (Category category) {
        this.category = category;
    }

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    public String getModel () {
        return model;
    }

    public void setModel (String model) {
        this.model = model;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List <Ordering> getOrderings () {
        return orderings;
    }

    public void setOrderings (List <Ordering> orderings) {
        this.orderings = orderings;
    }
}