package HomeWork_4.Controllers;

import HomeWork_4.DAO.CartService;
import HomeWork_4.DAO.ProductDAO;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class CartController implements Serializable {

    @EJB
    private CartService cartService;

    public List <ProductDAO> getAllProducts() {
        return cartService.getAllProducts();
    }

    public void addToCart(ProductDAO productDAO) {
        cartService.addToCart(productDAO);
    }
}
