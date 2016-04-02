
package classes;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAOIMPL implements UsersDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session openSession(){
         return  sessionFactory.getCurrentSession();
    }


    @Override
    public Users findByLogin(String login){
        List<Users> usersList = new ArrayList<>();
        Query query = openSession().createQuery("FROM  Users u where u.login  =:login ");
        query.setParameter("login", login);
        usersList = query.list();

        if (usersList.size()>0){
            return usersList.get(0);

        } else  return null;
    }
}

