package HomeWork_4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletContext;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
@Named
public class Admin_product {

    private static final Logger logger = LoggerFactory.getLogger(Admin_product.class);

    @Inject
    private ServletContext context;
    private Connection con;

    public Admin_product () {
    }

    @PostConstruct
    public void init () throws SQLException {
        con = (Connection) context.getAttribute ("connection");
            if (this.findAll().isEmpty()) {
                logger.info ("No products in DB. Initializing.");
            }
    }

    public void insert (Product product) throws SQLException {
        try (PreparedStatement stmt = con.prepareStatement ("insert into product(firm, model, price) values (?, ?, ?);"))
        {
            stmt.setString(1, product.getFirm ());
            stmt.setString(2, product.getModel ());
            stmt.setBigDecimal (3, product.getPrice ());
            stmt.execute ();
        }
    }

    public void update (Product product) throws SQLException {
        try (PreparedStatement stmt = con.prepareStatement ("update product set " +
                    "firm = ?, model = ?, price = ? where product_id = ?;"))
        {
            stmt.setString(1, product.getFirm ());
            stmt.setString(2, product.getModel ());
            stmt.setBigDecimal (3, product.getPrice ());
            stmt.setLong (4, product.getId ());
            stmt.execute ();
        }
    }

    public void delete (Long id) throws SQLException {
        try (PreparedStatement stmt = con.prepareStatement ("delete from product where product_id = ?;"))
        {
            stmt.setLong (1, id);
            stmt.execute ();
        }
    }

    public Optional <Product> findById(Long id) throws SQLException {
        try (PreparedStatement stmt = con.prepareStatement(
                "select product_id, firm, model, price from product where product_id = ?;")) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return Optional.of(new Product(rs.getLong (1), rs.getString (2), rs.getString(3), rs.getBigDecimal (4)));
            }
        }
        return Optional.empty();
    }

    public List <Product> findAll() throws SQLException {
        List<Product> res = new ArrayList <> ();
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery("select product_id, firm, model, price from product;");

            while (rs.next()) {
                res.add(new Product(rs.getLong (1), rs.getString (2), rs.getString(3), rs.getBigDecimal (4)));
            }
        }
        return res;
    }
}
