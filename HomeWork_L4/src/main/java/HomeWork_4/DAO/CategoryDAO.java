package HomeWork_4.DAO;

import HomeWork_4.Category;
import HomeWork_4.Product;

import java.util.List;

public class CategoryDAO {
    private Long category_id;
    private String category;
    private List <Product> product;
    private String firm;
    private String model;

    public CategoryDAO() {
    }

    public CategoryDAO(Long category_id, String category) {
        this.category_id = category_id;
        this.category = category;
    }

    public CategoryDAO(Category category) {
        this.category_id = category.getCategory_id();
        this.category = category.getCategory();
        this.product = category.getProduct();
    }

    public List <Product> getProduct() {
        return product;
    }

    public void setProduct(List <Product> product) {
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
}