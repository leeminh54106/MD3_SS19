package ra.springthymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class CookiesController {
    @Autowired
    HttpSession session;
    @RequestMapping("/cookies")
    public String setCookies(@CookieValue(name = "count",defaultValue = "0") Integer count, HttpServletResponse response, Model model,HttpSession session){
        // lay ra cookies
//       Cookie[] cookies = request.getCookies();
//        for (int i = 0; i < cookies.length; i++) {
//            System.out.printf("name : %s | value : %s \n",cookies[i].getName(),cookies[i].getValue());
//            model.addAttribute(cookies[i].getName(),cookies[i].getValue());
//        }
        Integer countUpdate = count+1;
//        model.addAttribute("count",countUpdate);
        Cookie cookie = new Cookie("count",countUpdate.toString());
        response.addCookie(cookie);
        return "cookies";
    }

    @RequestMapping("/add-cookies")
    public String addCookies(HttpServletRequest request, HttpServletResponse response){
        // them 1 cookies co nam = username
//        Cookie[] cookies = request.getCookies();
//        boolean check = true;
//        for (int i = 0; i < cookies.length; i++) {
//            if (cookies[i].getName().equals("username")){
//                check =false;
//                Cookie cookie = new Cookie("username","hunghx");
//                cookie.setMaxAge(0);
//                cookies[i] = cookie;
//            }
//        }
//        if (check){
            Cookie cookie = new Cookie("username","sontx");
            cookie.setMaxAge(3*60);
            response.addCookie(cookie);
//        }
        return "cookies";

    }

}
