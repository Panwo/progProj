package classes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class SiteController {
    @Autowired
    MyService myService;


    @RequestMapping("/")
    public String index(Model model) {

        model.addAttribute("categories", myService.listGroups());
        return "index";
    }


    @RequestMapping("/top/{id}")
    public String listCategory (@PathVariable(value = "id") long categoryId, Model model) {
          categoryId = 7;
            Category category =  myService.find(categoryId);

        model.addAttribute("products", MyService.listProducts(category));
        return "top";
    }

}
