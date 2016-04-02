package classes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class RoleDAOIMPL  implements  RoleDAO{
    @Autowired
    private SessionFactory sessionFactory;


    private Session  getCurrentSession(){
        return  sessionFactory.getCurrentSession();
    }

    @Override
    public Roles getRole(int id ){
        Roles role = (Roles) getCurrentSession().load(Roles.class, id);
        return role;
    }

}
