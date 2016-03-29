package classes;

import java.util.List;

public interface CategoryDAO {

    Category showOne(long id);
    List<Category> list();
}
