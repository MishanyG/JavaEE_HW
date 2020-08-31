package HomeWork_4.DAO;

import javax.ejb.Local;
import java.util.List;
import java.util.Optional;

@Local
public interface ProductService {
    void insert (ProductDAO productDAO);
    void update (ProductDAO productDAO);
    void delete (Long id);
    Optional <ProductDAO> findById(Long id);
    List <ProductDAO> findAll();
}
