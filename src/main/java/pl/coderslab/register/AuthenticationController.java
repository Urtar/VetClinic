package pl.coderslab.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.config.ViewMode;
import pl.coderslab.entity.Admin;
import pl.coderslab.entity.Owner;
import pl.coderslab.entity.Vet;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class AuthenticationController {

    @Autowired
    private pl.coderslab.register.AuthenticationService authenticationService;

    @GetMapping("login")
    public String login(Model model) {
        model.addAttribute("viewMode", new ViewMode());
        return "home/login";
    }

    @PostMapping("login")
    public String login(@ModelAttribute ViewMode viewMode, HttpSession httpSession) {
        if ("login".equals(viewMode.getAction())) {
            if (authenticationService.givenLoginExistInDatabaseOwner(viewMode.getLogin())) {
                Owner owner = authenticationService.authenticateOwner(viewMode.getLogin(), viewMode.getPassword());
                httpSession.setAttribute("loggedOwner", owner.getId());
                return "redirect:/index";
            } else if (authenticationService.givenLoginExistInDatabaseVet(viewMode.getLogin())) {
                Vet vet = authenticationService.authenticateVet(viewMode.getLogin(), viewMode.getPassword());
                httpSession.setAttribute("loggedVet", vet.getId());
                httpSession.setAttribute("vetName", vet.getFirstName() + ", " + vet.getLastName());
                return "redirect:/owner/list";
            } else if (authenticationService.givenLoginExistInDatabaseAdmin(viewMode.getLogin())) {
                Admin admin = authenticationService.authenticateAdmin(viewMode.getLogin(), viewMode.getPassword());
                httpSession.setAttribute("loggedAdmin", admin.getId());
                return "redirect:/vet/list";
            } else {
                return "home/login";
            }
        }
        return "home/login";
    }

    @GetMapping("logout")
    public String logout (HttpSession httpSession){
        httpSession.invalidate();
        return "home/logout";
    }

}
