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
public class Admin_category {

    private static final Logger logger = LoggerFactory.getLogger(Admin_product.class);

    @Inject
    private ServletContext context;
    private Connection con;

    public Admin_category () {
    }

    @PostConstruct
    public void init () throws SQLException {
        con = (Connection) context.getAttribute ("connection");
        if (this.findAll().isEmpty()) {
            logger.info ("No products in DB. Initializing.");
        }
    }

    public void insertCat (Category category) throws SQLException {
        try (PreparedStatement stmt = con.prepareStatement ("insert into category(category) value (?);"))
        {
            stmt.setString(1, category.getCategory ());
            stmt.execute ();
        }
    }

    public void updateCat (Category category) throws SQLException {
        try (PreparedStatement stmt = con.prepareStatement ("update category set category = ? where category_id = ?;"))
        {
            stmt.setString(1, category.getCategory ());
            stmt.setLong (2, category.getCategory_id ());
            stmt.execute ();
        }
    }

    public void deleteCat (Long id) throws SQLException {
        try (PreparedStatement stmt = con.prepareStatement ("delete from category where category_id = ?;"))
        {
            stmt.setLong (1, id);
            stmt.execute ();
        }
    }

    public Optional <Category> findById(Long id) throws SQLException {
        try (PreparedStatement stmt = con.prepareStatement(
                "select category_id, category from category where category_id = ?;")) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return Optional.of(new Category (rs.getLong (1), rs.getString(2)));
            }
        }
        return Optional.empty();
    }

    public List <Category> findAll() throws SQLException {
        List<Category> res = new ArrayList <> ();
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery("select category_id, category from category;");

            while (rs.next()) {
                res.add(new Category (rs.getLong (1), rs.getString(2)));
            }
        }
        return res;
    }
}
