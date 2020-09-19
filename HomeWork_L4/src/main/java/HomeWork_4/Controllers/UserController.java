package HomeWork_4.Controllers;

import HomeWork_4.DAO.UserDAO;
import HomeWork_4.DAO.UserService;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.List;

@SessionScoped
@Named
public class UserController implements Serializable {

    @EJB
    private UserService userService;

    private UserDAO user = new UserDAO();

    public UserDAO getUser() {
        return user;
    }

    public void setUser(UserDAO user) {
        this.user = user;
    }

    public List <UserDAO> getAllUsers() {
        return userService.findAll();
    }

    public String editUser(UserDAO user) {
        this.user = user;
        return "/admin/login.xhtml?faces-redirect=true";
    }

    public void deleteUser(UserDAO user) {
        userService.deleteUser(user.getUser_id());
    }

    public String createUser() {
        this.user = new UserDAO();
        return "/admin/login.xhtml?faces-redirect=true";
    }

    public String saveUser() {
        if(user.getUser_id() != null) {
            userService.updateUser(user);
        } else {
            userService.insertUser(user);
        }
        return "/admin/product.xhtml?faces-redirect=true";
    }

    public Object logout() {
        ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).invalidate();
        return "/index.xhtml?faces-redirect=true";
    }
}
