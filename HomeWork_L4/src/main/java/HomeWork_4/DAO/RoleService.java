package HomeWork_4.DAO;

import java.util.List;

public interface RoleService {
    void insertRole(RoleDAO roleDAO);
    void updateRole(RoleDAO roleDAO);
    void deleteRole(Long id);
    List <RoleDAO> findById(Long id);
    List <RoleDAO> findAll();
}
