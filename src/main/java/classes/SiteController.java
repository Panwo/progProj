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
    @RequestMapping("/index")
    public String ind(Model model) {
        model.addAttribute("categories", myService.listGroups());
        return "index";
    }


    @RequestMapping("/login")
    public String login(Model model) {
        model.addAttribute("categories", myService.listGroups());
        return "login-form";
    }

    @RequestMapping("/top/{id}")
    public String listCategory (@PathVariable(value = "id") long categoryId, Model model) {
        Category category =  myService.find(categoryId);
        model.addAttribute("cat", category);
        model.addAttribute("products", myService.listProducts(category));
        model.addAttribute("categories", myService.listGroups());
        return "top";
    }


    @RequestMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("category", myService.listGroups());
        return "admin";
    }

}
