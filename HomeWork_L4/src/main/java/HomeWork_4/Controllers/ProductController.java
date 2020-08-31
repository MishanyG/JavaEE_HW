package HomeWork_4.Controllers;

import HomeWork_4.Category;
import HomeWork_4.DAO.ProductDAO;
import HomeWork_4.DAO.ProductService;
import HomeWork_4.Repositories.CategoryRepository;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@SessionScoped
@Named
public class ProductController implements Serializable {

    @EJB
    private ProductService productService;

    @EJB
    private CategoryRepository categoryRepository;

    private ProductDAO product;

    public ProductDAO getProduct() {
        return product;
    }

    public void setProduct(ProductDAO product) {
        this.product = product;
    }

    public List <ProductDAO> getAllProducts() {
        return productService.findAll();
    }

    public String editProduct(ProductDAO product) {
        this.product = product;
        return "/adm_product.xhtml?faces-redirect=true";
    }

    public void deleteProduct(ProductDAO product) {
        productService.delete(product.getProduct_id());
    }

    public String createProduct() {
        this.product = new ProductDAO();
        return "/adm_product.xhtml?faces-redirect=true";
    }

    public String addProductInCart() {
        this.product = new ProductDAO();
        return "/cart.xhtml?faces-redirect=true";
    }

    public String saveProduct() {
        if(product.getProduct_id() != null) {
            productService.update(product);
        } else {
            productService.insert(product);
        }
        return "/product.xhtml?faces-redirect=true";
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}

