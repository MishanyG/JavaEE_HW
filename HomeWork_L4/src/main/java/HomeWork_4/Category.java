package HomeWork_4;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity (name = "Cat")
@Table (name = "category")
public class Category implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long category_id;

    @Column(name = "category", length = 255)
    private String category;

    @OneToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "category")
    private List <Product> products;

    public Category () {
    }

    public Category (Long id, String category) {
        this.category_id = id;
        this.category = category;
    }

    public List <Product> getProducts () {
        return products;
    }

    public void setProducts (List <Product> products) {
        this.products = products;
    }

    public Category (List <Product> products) {
        this.products = products;
    }

    public Long getCategory_id () {
        return category_id;
    }

    public void setCategory_id (Long category_id) {
        this.category_id = category_id;
    }

    public String getCategory () {
        return category;
    }

    public void setCategory (String category) {
        this.category = category;
    }
}