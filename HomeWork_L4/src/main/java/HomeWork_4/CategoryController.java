package HomeWork_4;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@SessionScoped
@Named
public class CategoryController implements Serializable {

    @Inject
    private Admin_category admin_category;
    private Category category;

    public Product getCategory_id() {
        return getCategory_id ();
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Category getCategory () {
        return category;
    }

    public List<Category> getAllCategory() throws SQLException {
        return admin_category.findAll();
    }

    public String editCategory(Category category) {
        this.category = category;
        return "/adm_categories.xhtml?faces-redirect=true";
    }

    public void deleteCategory(Category category) throws SQLException {
        admin_category.deleteCat (category.getCategory_id ());
    }

    public String createCategory() {
        this.category = new Category ();
        return "/adm_categories.xhtml?faces-redirect=true";
    }

    public String saveCategory() throws SQLException {
        if (category.getCategory_id () != null) {
            admin_category.updateCat (category);
        } else {
            admin_category.insertCat (category);
        }
        return "/categories.xhtml?faces-redirect=true";
    }
}

