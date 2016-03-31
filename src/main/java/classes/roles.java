
package classes;


import javax.persistence.*;

@Entity
@Table(name = "users_roles")
public class roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name = "login")
     Users usersrole;

    @Column(name = "role")
    private  String role;

    public roles() {
    }

    public roles(Users usersrole, String role) {
        this.usersrole = usersrole;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Users getUsersrole() {
        return usersrole;
    }

    public void setUsersrole(Users usersrole) {
        this.usersrole = usersrole;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

