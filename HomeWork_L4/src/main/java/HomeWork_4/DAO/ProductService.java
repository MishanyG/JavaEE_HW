package HomeWork_4.DAO;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ProductService {
    void insert (ProductDAO productDAO);
    void update (ProductDAO productDAO);
    void delete (Long id);
    List <ProductDAO> findById(Long id);
    List <ProductDAO> findAll();
}
