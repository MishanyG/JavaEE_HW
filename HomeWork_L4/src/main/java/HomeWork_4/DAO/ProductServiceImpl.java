package HomeWork_4.DAO;

import HomeWork_4.Category;
import HomeWork_4.Logger;
import HomeWork_4.Product;
import HomeWork_4.Repositories.CategoryRepository;
import HomeWork_4.Repositories.ProductRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.interceptor.Interceptors;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Stateless
public class ProductServiceImpl implements ProductService {

    @EJB
    private ProductRepository productRepository;

    @EJB
    private CategoryRepository categoryRepository;

    @TransactionAttribute
    @Override
    @Interceptors(Logger.class)
    public void insert(ProductDAO productDAO) {
        Category category = categoryRepository.findById(productDAO.getCategory_id()).orElse(null);
        Product product = new Product(productDAO.getProduct_id(), productDAO.getFirm(), productDAO.getModel(), productDAO.getPrice(), category);
        productRepository.insert(product);
    }

    @TransactionAttribute
    @Override
    @Interceptors(Logger.class)
    public void update(ProductDAO productDAO) {
        Category category = categoryRepository.findById(productDAO.getCategory_id()).orElse(null);
        Product product = new Product(productDAO.getProduct_id(), productDAO.getFirm(), productDAO.getModel(), productDAO.getPrice(), category);
        productRepository.update(product);
    }

    @TransactionAttribute
    @Override
    @Interceptors(Logger.class)
    public void delete(Long id) {
        productRepository.delete(id);
    }

    @TransactionAttribute
    @Override
    public Optional <ProductDAO> findById(Long id) {
        return productRepository.findById(id)
                .map(ProductDAO::new);
    }

    @TransactionAttribute
    @Override
    public List <ProductDAO> findAll() {
        return productRepository.findAll().stream()
                .map(ProductDAO::new)
                .collect(Collectors.toList());
    }
}
