package ra.springthymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.springthymeleaf.repository.StudentDao;

import javax.transaction.Transactional;

@Controller
@Transactional
public class HomeController {
    @Autowired
    private StudentDao studentDao;
    @RequestMapping
    public String getAll(){
        studentDao.getAll();
        return "home";
    }
}
