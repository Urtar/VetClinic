package pl.coderslab.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Vet;
import pl.coderslab.config.ViewMode;
import pl.coderslab.entity.Owner;


import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class AuthenticationController {

    @Autowired
    private pl.coderslab.register.AuthenticationService authenticationService;


    @GetMapping("login")
    public String login(Model model) {
        model.addAttribute("viewMode", new ViewMode());
        return "/home/login";
    }


    @PostMapping("login")
    public String login(@ModelAttribute ViewMode viewMode, HttpSession httpSession) {
        if("register".equals(viewMode.getAction())) {
            return "redirect:/register/add";
        }
        if("login".equals(viewMode.getAction())) {
            if (authenticationService.givenLoginExistInDatabaseOwner(viewMode.getLogin())||authenticationService.givenLoginExistInDatabaseVet(viewMode.getLogin())) {
                Vet vet = authenticationService.authenticateVet(viewMode.getLogin(), viewMode.getPassword());
                Owner owner = authenticationService.authenticateOwner(viewMode.getLogin(), viewMode.getPassword());
                if(vet != null || owner != null) {
                    httpSession.setAttribute("loggedVet", vet.getId());
                    httpSession.setAttribute("loggedOwner", owner.getId());
                    return "redirect:/";
                } else {
                    return "authentication/login";
                }
            } else {
                return "authentication/login";
            }
        }
        return "authentication/login";
    }


}
