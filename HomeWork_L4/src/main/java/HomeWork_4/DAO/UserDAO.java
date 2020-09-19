package HomeWork_4.DAO;

import HomeWork_4.User;

public class UserDAO {
    private Long user_id;
    private String login;
    private String password;

    public UserDAO() {
    }

    public UserDAO(Long user_id, String login, String password) {
        this.user_id = user_id;
        this.login = login;
        this.password = password;
    }

    public UserDAO(User user) {
        this.login = user.getLogin();
        this.password = user.getPassword();
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
