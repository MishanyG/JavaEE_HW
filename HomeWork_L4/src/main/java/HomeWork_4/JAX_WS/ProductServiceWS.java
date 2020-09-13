package HomeWork_4.JAX_WS;

import HomeWork_4.DAO.CategoryDAO;
import HomeWork_4.DAO.ProductDAO;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface ProductServiceWS {
    @WebMethod
    void insertCat(CategoryDAO categoryDAO);
    @WebMethod
    void insert (ProductDAO productDAO);
    @WebMethod
    void delete (Long id);
    @WebMethod
    List <ProductDAO> findById(Long id);
    @WebMethod
    List <ProductDAO> findByName(String firm, String model);
    @WebMethod
    List <ProductDAO> findByIdCat(Long id);
    @WebMethod
    List <ProductDAO> findAll();
}
