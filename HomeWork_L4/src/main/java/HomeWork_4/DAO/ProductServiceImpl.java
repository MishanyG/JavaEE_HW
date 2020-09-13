package HomeWork_4.DAO;

import HomeWork_4.Category;
import HomeWork_4.JAX_RS.ProductServiceRS;
import HomeWork_4.JAX_WS.ProductServiceWS;
import HomeWork_4.Logger;
import HomeWork_4.Product;
import HomeWork_4.Repositories.CategoryRepository;
import HomeWork_4.Repositories.ProductRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.interceptor.Interceptors;
import javax.jws.WebService;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
@WebService(endpointInterface = "HomeWork_4.JAX_WS.ProductServiceWS", serviceName = "ProductService")
public class ProductServiceImpl implements ProductService, ProductServiceWS, ProductServiceRS {

    @EJB
    private ProductRepository productRepository;

    @EJB
    private CategoryRepository categoryRepository;

    @Override
    public void insertCat(CategoryDAO categoryDAO) {
        List<Product> product = productRepository.findAll();
        Category category = new Category(categoryDAO.getCategory_id(), categoryDAO.getCategory(), product);
        categoryRepository.insertCat(category);
    }

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
    public List <ProductDAO> findById(Long id) {
        return productRepository.findById(id).stream()
                .map(ProductDAO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List <ProductDAO> findByName(String firm, String model) {
        return productRepository.findByName(firm, model).stream()
                .map(ProductDAO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List <ProductDAO> findByIdCat(Long id) {
        return productRepository.findByIdCat(id).stream()
                .map(ProductDAO::new)
                .collect(Collectors.toList());
    }

    @TransactionAttribute
    @Override
    public List <ProductDAO> findAll() {
        return productRepository.findAll().stream()
                .map(ProductDAO::new)
                .collect(Collectors.toList());
    }
}
