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
        Query query;
        System.out.println("gitTest");
            query = entityManager.createQuery("select  p from Products p join p.categories c where  c.id = :idCategory", Products.class);
            query.setParameter("idCategory", category.getId());

        return (List<Products>) query.getResultList();
    }
}
