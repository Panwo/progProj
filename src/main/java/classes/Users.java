
package classes;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name ="Users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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


    @OneToMany(mappedBy = "usersrole")
    private  List<roles>   userRole = new ArrayList<>();


    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setMale(boolean male) {
        this.male = male;
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

