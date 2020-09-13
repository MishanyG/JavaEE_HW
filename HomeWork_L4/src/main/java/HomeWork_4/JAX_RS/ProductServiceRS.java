package HomeWork_4.JAX_RS;

import HomeWork_4.DAO.CategoryDAO;
import HomeWork_4.DAO.ProductDAO;

import javax.ejb.Local;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Local
@Path("/product")
public interface ProductServiceRS {
    @POST
    @Path("/insertCat")
    @Consumes(MediaType.APPLICATION_JSON)
    void insertCat(CategoryDAO categoryDAO);
    @POST
    @Path("/insertProd")
    @Consumes(MediaType.APPLICATION_JSON)
    void insert (ProductDAO productDAO);
    @DELETE
    @Path("/delete/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    void delete (@PathParam("id") Long id);
    @GET
    @Path("/findById/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    List <ProductDAO> findById(@PathParam("id") Long id);
    @GET
    @Path("/findByName/{firm}/{model}")
    @Produces(MediaType.APPLICATION_JSON)
    List <ProductDAO> findByName(@PathParam("firm") String firm, @PathParam("model")String model);
    @GET
    @Path("/findByIdCat/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    List <ProductDAO> findByIdCat(@PathParam("id") Long id);
    @GET
    @Path("/findAll")
    @Produces(MediaType.APPLICATION_JSON)
    List <ProductDAO> findAll();
}
