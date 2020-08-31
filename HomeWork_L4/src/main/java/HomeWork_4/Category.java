package HomeWork_4;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table (name = "category")
public class Category implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long category_id;

    @Column(name = "category", length = 255)
    private String category;

    @OneToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "category")
    private List <Product> product;

    public Category () {
    }

    public Category (Long id, String category, List <Product> product) {
        this.category_id = id;
        this.category = category;
        this.product = product;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List <Product> getProduct() {
        return product;
    }

    public void setProduct(List <Product> product) {
        this.product = product;
    }
}