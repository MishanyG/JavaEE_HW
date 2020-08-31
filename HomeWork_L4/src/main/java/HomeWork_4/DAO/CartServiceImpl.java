package HomeWork_4.DAO;

import HomeWork_4.Logger;

import javax.ejb.Local;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.interceptor.Interceptors;
import java.util.ArrayList;
import java.util.List;

@Stateful
@Local
public class CartServiceImpl implements CartService {

    private List <ProductDAO> productDAOList = new ArrayList <>();

    @TransactionAttribute
    @Override
    @Interceptors(Logger.class)
    public void addToCart(ProductDAO productDAO) {
        if(productDAO != null) {
            productDAOList.add(productDAO);
        }
    }

    @TransactionAttribute
    @Override
    @Interceptors(Logger.class)
    public List <ProductDAO> getAllProducts() {
        return productDAOList;
    }
}
