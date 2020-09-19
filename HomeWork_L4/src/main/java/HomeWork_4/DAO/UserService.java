package HomeWork_4.DAO;

import java.util.List;

public interface UserService {
    void insertUser (UserDAO userDAO);
    void updateUser (UserDAO userDAO);
    void deleteUser (Long id);
    List <UserDAO> findById(Long id);
    List <UserDAO> findAll();
}
