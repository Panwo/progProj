package classes;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name ="Users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column (name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column (name = "male")
    private boolean male;


    @ManyToMany(mappedBy = "usersList")
    private List<Products> productses = new ArrayList<>();


    @OneToMany(mappedBy="users", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Orders> orders = new ArrayList<>();


    @OneToMany(mappedBy = "users")
    private  List<roles>   userRole = new ArrayList<>();

    public long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public boolean isMale() {
        return male;
    }
}
