package HomeWork_4.DAO;

import javax.ejb.Local;
import java.util.List;
import java.util.Optional;

@Local
public interface CategoryService {
    void insertCat (CategoryDAO categoryDAO);
    void updateCat (CategoryDAO categoryDAO);
    void deleteCat (Long id);
    Optional <CategoryDAO> findById(Long id);
    List <CategoryDAO> findAll();
}
