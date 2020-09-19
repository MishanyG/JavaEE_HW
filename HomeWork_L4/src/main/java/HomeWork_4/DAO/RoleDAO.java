package HomeWork_4.DAO;

import HomeWork_4.Role;

public class RoleDAO {
    private Long role_id;
    private String name;

    public RoleDAO() {
    }

    public RoleDAO(Long role_id, String name) {
        this.role_id = role_id;
        this.name = name;
    }

    public RoleDAO(Role role) {
        this.name = role.getName();
    }

    public Long getRole_id() {
        return role_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
