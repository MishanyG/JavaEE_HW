package HomeWork_4.DAO;

import HomeWork_4.Category;
import HomeWork_4.Product;
import HomeWork_4.Repositories.CategoryRepository;
import HomeWork_4.Repositories.ProductRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Stateless
public class CategoryServiceImpl implements CategoryService{

    @EJB
    private CategoryRepository categoryRepository;

    @EJB
    private ProductRepository productRepository;

    @TransactionAttribute
    @Override
    public void insertCat(CategoryDAO categoryDAO) {
        List<Product> product = productRepository.findAll();
        Category category = new Category(categoryDAO.getCategory_id(), categoryDAO.getCategory(), product);
        categoryRepository.insertCat(category);
    }

    @TransactionAttribute
    @Override
    public void updateCat(CategoryDAO categoryDAO) {
        List<Product> product = productRepository.findAll();
        Category category = new Category(categoryDAO.getCategory_id(), categoryDAO.getCategory(), product);
        categoryRepository.updateCat(category);
    }

    @TransactionAttribute
    @Override
    public void deleteCat(Long id) {
        categoryRepository.deleteCat(id);
    }

    @TransactionAttribute
    @Override
    public Optional <CategoryDAO> findById(Long id) {
        return categoryRepository.findById(id)
                .map(CategoryDAO::new);
    }

    @TransactionAttribute
    @Override
    public List <CategoryDAO> findAll() {
        return categoryRepository.findAll().stream()
                .map(CategoryDAO::new)
                .collect(Collectors.toList());
    }
}
