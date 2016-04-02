package classes;

import org.springframework.stereotype.Service;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.transaction.annotation.Transactional;


import  java.util.Collection;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional(readOnly = true)
public class MyUserDetailService  implements UserDetailsService {

    @Autowired
    private UsersDAO usersDAO;

    public UserDetails loadUserByUsername(String login ) {

        Users domainUser = usersDAO.findByLogin(login);

        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        return new User(
                domainUser.getLogin(),
                domainUser.getPassword(),
                enabled,
                accountNonExpired,
                credentialsNonExpired,
                accountNonLocked,
                getAuthorities(domainUser.getRole().getId())
        );
    }

     public Collection getAuthorities(Integer role){
         List authList = getGrantedAuthorities((getRoleS(role)));
         return  authList;
    }

    public ArrayList<String> getRoleS(Integer role) {
        ArrayList<String> roles = new ArrayList();

        if (role.intValue() == 1) {
            roles.add("ROLE_MODERATOR");
            roles.add("ROLE_ADMIN");

        } else if (role.intValue() == 2) {
            roles.add("ROLE_MODERATOR");
        }

        return roles;

    }

    public static List getGrantedAuthorities(ArrayList<String> roles) {

        List   authorities = new ArrayList();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }
}










