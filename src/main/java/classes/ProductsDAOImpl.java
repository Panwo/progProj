package classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Repository
public class ProductsDAOImpl implements  ProductsDAO  {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Products> list (Category category) {
        Query query = null;
        if (category!= null) {
            query = entityManager.createQuery("SELECT c FROM Category c join c.categories WHERE c.id = 7", Products.class);
            //query.setParameter("category", category);
        }
        return (List<Products>) query.getResultList();
    }
}
