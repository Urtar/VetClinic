package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Vet;
import pl.coderslab.repository.VetRepository;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/")
public class AdminController {

    @Autowired
    private VetRepository vetRepository;

    @ModelAttribute("allVets")
    public List<Vet> viewAllVetsList() {
        return vetRepository.findAll();
    }

    @GetMapping("vet/list")
    public String vatAdd(HttpSession httpSession, Model model){
        if(httpSession.getAttribute("loggedAdmin") != null){
            return "vet/list";
        } else return "vet/brakUprawnien";
    }
}
