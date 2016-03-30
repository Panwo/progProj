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
     Users users;

    @Column(name = "role")
    private  String role;



    public roles() {
    }

    public roles(Users users, String role) {
        this.users = users;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public Users getUsers() {
        return users;
    }

    public String getRole() {
        return role;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
