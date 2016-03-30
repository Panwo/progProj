package classes;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAOIMPL implements UsersDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Override
    public Users findByLogin(String login){
        List<Users> usersList = new ArrayList<>();

        usersList = sessionFactory.getCurrentSession().createQuery("from Users where login =?").setParameter(0,login).list();

        if (usersList.size()>0){
            return usersList.get(0);

        } else  return null;
    }

}
