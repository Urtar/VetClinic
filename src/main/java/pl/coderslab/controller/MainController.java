package pl.coderslab.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class MainController {

    @GetMapping("/")
    public String homePage(){
        return "/home/index";
    }
}
