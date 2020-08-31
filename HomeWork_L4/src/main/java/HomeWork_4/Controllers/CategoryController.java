package HomeWork_4.Controllers;

import HomeWork_4.Category;
import HomeWork_4.Repositories.CategoryRepository;
import HomeWork_4.Repositories.ProductRepository;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@SessionScoped
@Named
public class CategoryController implements Serializable {

    @EJB
    private CategoryRepository categoryRepository;

    @EJB
    private ProductRepository productRepository;

    private Category category;

    public void setCategory(Category category) {
        this.category = category;
    }

    public Category getCategory () {
        return category;
    }

    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    public String editCategory(Category category) {
        this.category = category;
        return "/adm_categories.xhtml?faces-redirect=true";
    }

    public void deleteCategory(Category category) {
        categoryRepository.deleteCat (category.getCategory_id ());
    }

    public String createCategory() {
        this.category = new Category ();
        return "/adm_categories.xhtml?faces-redirect=true";
    }

    public String saveCategory() {
        if (category.getCategory_id () != null) {
            categoryRepository.updateCat (category);
        } else {
            categoryRepository.insertCat (category);
        }
        return "/categories.xhtml?faces-redirect=true";
    }
}

