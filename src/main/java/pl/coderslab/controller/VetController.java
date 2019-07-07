package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Owner;
import pl.coderslab.repository.OwnerRepository;
import pl.coderslab.repository.PetRepository;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/")
public class VetController {

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private PetRepository petRepository;

    @ModelAttribute("allOwners")
    public List<Owner> viewAllOwnersList() {
        return ownerRepository.findAll();
    }

    @GetMapping("owner/list")
    public String ownerAdd(HttpSession httpSession, Model model){
        if(httpSession.getAttribute("loggedVet") != null){
            return "owner/list";
        } else return "owner/brakUprawnien";
    }

    @GetMapping("owner/{id}")
    public String ownersPets(HttpSession httpSession, Model model, @PathVariable("id") long id){
        if(httpSession.getAttribute("loggedVet") != null){
            model.addAttribute("allPets",petRepository.findAllByOwnersId(id));
            model.addAttribute("ownerId",id);
            httpSession.setAttribute("ownerIdSess", id);
            httpSession.setAttribute("ownerPeselSess",ownerRepository.findById(id).get().getPesel() );
            System.out.println(httpSession.getAttribute("ownerPeselSess"));
            return "pet/list";
        } else return "owner/brakUprawnien";
    }
}
