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
public class UserServiceImpl implements UserService{

    @EJB
    private UserRepository userRepository;

    @EJB
    private RoleRepository roleRepository;

    @TransactionAttribute
    @Override
    public void insertUser(UserDAO userDAO) {
        List <Role> roles = roleRepository.findAll();
        User user = new User(userDAO.getUser_id(), userDAO.getLogin(), userDAO.getPassword(), roles);
        userRepository.insertUser(user);
    }

    @TransactionAttribute
    @Override
    public void updateUser(UserDAO userDAO) {
        List <Role> roles = roleRepository.findAll();
        User user = new User(userDAO.getUser_id(), userDAO.getLogin(), userDAO.getPassword(), roles);
       userRepository.updateUser(user);
    }

    @TransactionAttribute
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteUser(id);
    }

    @TransactionAttribute
    @Override
    public List <UserDAO> findById(Long id) {
        return userRepository.findById(id).stream().map(UserDAO :: new).collect(Collectors.toList());
    }

    @TransactionAttribute
    @Override
    public List <UserDAO> findAll() {
        return userRepository.findAll().stream().map(UserDAO :: new).collect(Collectors.toList());
    }
}
