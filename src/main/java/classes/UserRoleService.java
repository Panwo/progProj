package classes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserRoleService {

    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    private  UsersDAO userDAO;

    public Roles getRole(int id ){
       return   roleDAO.getRole(id);
    }

    public Users  getUser(String login ){
        return userDAO.findByLogin(login);
    }
}
