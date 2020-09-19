package HomeWork_4.Controllers;

import HomeWork_4.DAO.RoleDAO;
import HomeWork_4.DAO.RoleService;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.List;

@SessionScoped
@Named
public class RoleController implements Serializable {

    @EJB
    private RoleService roleService;

    private RoleDAO role = new RoleDAO();

    public RoleDAO getRole() {
        return role;
    }

    public void setRole(RoleDAO role) {
        this.role = role;
    }

    public List <RoleDAO> getAllRoles() {
        return roleService.findAll();
    }

    public String editRole(RoleDAO role) {
        this.role = role;
        return "/admin/login.xhtml?faces-redirect=true";
    }

    public void deleteRole(RoleDAO role) {
        roleService.deleteRole(role.getRole_id());
    }

    public String createRole() {
        this.role = new RoleDAO();
        return "/admin/login.xhtml?faces-redirect=true";
    }

    public String saveRole() {
        if(role.getRole_id() != null) {
            roleService.updateRole(role);
        } else {
            roleService.insertRole(role);
        }
        return "/admin/product.xhtml?faces-redirect=true";
    }

    public Object logout() {
        ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).invalidate();
        return "/index.xhtml?faces-redirect=true";
    }
}
