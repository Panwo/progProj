package classes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MyService {

    @Autowired
    private  CategoryDAO categoryDAO;

    @Autowired
    private   ProductsDAO productsDAO;



    @Transactional(readOnly =  true)
    public Category find(long id ){
        return categoryDAO.showOne(id);
    }

    @Transactional(readOnly=true)
    public  List<Category> listGroups() {
        return categoryDAO.list();
    }


    @Transactional(readOnly = true)
    public  List<Products> listProducts (Category category){
       return productsDAO.list(category);
    }


}
