import homework_4.dao.ProductService;
import homework_4.dao.ProductServiceWS;
import homework_4.jax_ws.CategoryDAO;
import homework_4.jax_ws.ProductDAO;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://127.0.0.1:8080/HomeWork_L4/ProductService/ProductServiceImpl?wsdl");
        ProductService productService = new ProductService(url);
        ProductServiceWS productServiceWS = productService.getProductServiceImplPort();
        insert(productServiceWS);
        delete(productServiceWS);
        insertCat(productServiceWS);
        findById(productServiceWS);
        findByName(productServiceWS);
        findAll(productServiceWS);
        findByIdCat(productServiceWS);
    }

    public static void insert(ProductServiceWS productServiceWS) {
        ProductDAO product = new ProductDAO();
        product.setCategoryId(2L);
        product.setFirm("Nokia");
        product.setModel("nk-7564");
        product.setPrice(BigDecimal.valueOf(3250));
        productServiceWS.insert(product);
    }

    public static void delete(ProductServiceWS productServiceWS) {
        productServiceWS.delete(26L);
    }

    public static void insertCat(ProductServiceWS productServiceWS) {
        CategoryDAO category = new CategoryDAO();
        category.setCategory("Ноутбуки");
        productServiceWS.insertCat(category);
    }

    public static void findById(ProductServiceWS productServiceWS) {
            productServiceWS.findById(3L).forEach(todo -> System.out.println(todo.getProductId() + ": "
                    + todo.getFirm() + ": " + todo.getModel() + ": " + todo.getPrice()));
    }

    public static void findByName(ProductServiceWS productServiceWS) {
        productServiceWS.findByName("Pentium 3", "Intel").forEach(todo -> System.out.println(todo.getProductId() + ": "
                + todo.getCategory() + ": " + todo.getFirm() + ": " + todo.getModel() + ": " + todo.getPrice()));
    }

    public static void findByIdCat(ProductServiceWS productServiceWS) {
        productServiceWS.findByIdCat(1L).forEach(todo -> System.out.println(todo.getProductId() + ": "
                + todo.getCategory() + ": " + todo.getFirm() + ": " + todo.getModel() + ": " + todo.getPrice()));
    }

    public static void findAll(ProductServiceWS productServiceWS) {
        productServiceWS.findAll().forEach(todo -> System.out.println(todo.getProductId() + ": "
                + todo.getFirm() + ": " + todo.getModel()));
    }
}
