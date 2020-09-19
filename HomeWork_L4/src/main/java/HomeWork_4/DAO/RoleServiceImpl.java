package HomeWork_4.DAO;

import HomeWork_4.Repositories.RoleRepository;
import HomeWork_4.Repositories.UserRepository;
import HomeWork_4.Role;
import HomeWork_4.User;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class RoleServiceImpl implements RoleService{

    @EJB
    private UserRepository userRepository;

    @EJB
    private RoleRepository roleRepository;

    @TransactionAttribute
    @Override
    public void insertRole(RoleDAO roleDAO) {
        List <User> users = userRepository.findAll();
        Role role = new Role(roleDAO.getRole_id(), roleDAO.getName(), users);
        roleRepository.insertRole(role);
    }

    @TransactionAttribute
    @Override
    public void updateRole(RoleDAO roleDAO) {
        List <User> users = userRepository.findAll();
        Role role = new Role(roleDAO.getRole_id(), roleDAO.getName(), users);
        roleRepository.updateRole(role);
    }

    @TransactionAttribute
    @Override
    public void deleteRole(Long id) {
        roleRepository.deleteRole(id);
    }

    @TransactionAttribute
    @Override
    public List <RoleDAO> findById(Long id) {
        return roleRepository.findById(id).stream().map(RoleDAO :: new).collect(Collectors.toList());
    }

    @TransactionAttribute
    @Override
    public List <RoleDAO> findAll() {
        return roleRepository.findAll().stream().map(RoleDAO :: new).collect(Collectors.toList());
    }
}
