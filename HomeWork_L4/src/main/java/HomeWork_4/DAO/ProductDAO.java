package HomeWork_4.DAO;

import HomeWork_4.Category;
import HomeWork_4.Product;

import java.math.BigDecimal;

public class ProductDAO {
    private Long product_id;
    private Long category_id;
    private String firm;
    private String model;
    private BigDecimal price;
    private String category;

    public ProductDAO() {
    }

    public ProductDAO(Long product_id, String firm, String model, BigDecimal price, Category category) {
        this.product_id = product_id;
        this.firm = firm;
        this.model = model;
        this.price = price;
        this.category_id = category.getCategory_id();
        this.category = category.getCategory();
    }

    public ProductDAO(Product product) {
        this.product_id = product.getProduct_id();
        this.firm = product.getFirm();
        this.model = product.getModel();
        this.price = product.getPrice();
        if (product.getCategory() != null) {
            this.category_id = product.getCategory().getCategory_id();
            this.category = product.getCategory().getCategory();
        }
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}