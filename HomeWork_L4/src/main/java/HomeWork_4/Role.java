package HomeWork_4;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "role")
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long role_id;
    @Column(name = "name", unique = true, nullable = false)
    private String name;
    @ManyToMany(mappedBy = "roles")
    private List <User> users;

    public Role(){}
    public Role(Long role_id, String name, List <User> users) {
        this.role_id = role_id;
        this.name = name;
        this.users = users;
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

    public List <User> getUsers() {
        return users;
    }

    public void setUsers(List <User> users) {
        this.users = users;
    }
}
