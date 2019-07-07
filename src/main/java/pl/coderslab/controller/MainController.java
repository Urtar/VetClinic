package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping("vetclinic")
    public String homePage(){
        return "home/home";
    }

    @GetMapping("address")
    public String address(){
        return "home/address";
    }

    @GetMapping("listaUslug")
    public String listOfServices(){
        return "home/index";
    }

    @GetMapping("/")
    public String home(HttpSession httpSession) {
        if(httpSession.getAttribute("loggedOwner") == null) {
            return "redirect:/login";
        }
        return "home";
    }
}
