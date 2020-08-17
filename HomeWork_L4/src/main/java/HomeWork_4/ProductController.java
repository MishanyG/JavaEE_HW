package HomeWork_4;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@SessionScoped
@Named
public class ProductController implements Serializable {

    @Inject
    private Admin_product admin_product;
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Product> getAllProducts() throws SQLException {
        return admin_product.findAll();
    }

    public String editProduct(Product product) {
        this.product = product;
        return "/adm_product.xhtml?faces-redirect=true";
    }

    public void deleteProduct(Product product) throws SQLException {
        admin_product.delete(product.getId());
    }

    public String createProduct() {
        this.product = new Product();
        return "/adm_product.xhtml?faces-redirect=true";
    }

    public String saveProduct() throws SQLException {
        if (product.getId() != null) {
            admin_product.update(product);
        } else {
            admin_product.insert(product);
        }
        return "/product.xhtml?faces-redirect=true";
    }
}

