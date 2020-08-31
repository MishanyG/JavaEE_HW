package HomeWork_4.DAO;

import javax.ejb.Local;
import java.util.List;

@Local
public interface CartService {
    void addToCart(ProductDAO productDAO);
    List<ProductDAO> getAllProducts();
}
