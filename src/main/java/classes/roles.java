
package classes;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users_roles")
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Integer id;

    @OneToMany(mappedBy = "roles",cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    Set <Users> userRoles;

    @Column(name = "role")
    private String role;

    public Roles() {
    }


    public Set<Users> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<Users> userRoles) {
        this.userRoles = userRoles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
