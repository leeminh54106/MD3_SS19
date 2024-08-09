package ra.demospring.controller;

import konta.demospring.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping
    public String home(Model model) {
        model.addAttribute("name","nguyen van a");
        model.addAttribute("age",20);
        model.addAttribute("student",new Student(1,19,"Nguyen Van B"));
        return "home";
    }
}
