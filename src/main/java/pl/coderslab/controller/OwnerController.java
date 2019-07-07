package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.repository.OwnerRepository;
import pl.coderslab.repository.PetRepository;
import pl.coderslab.repository.VisitRepository;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class OwnerController {

    @Autowired
    public OwnerRepository ownerRepository;

    @Autowired
    public PetRepository petRepository;

    @Autowired
    public VisitRepository visitRepository;

    @GetMapping("pet/{id}/detailsForOwner")
    public String ownerPetDetails (HttpSession httpSession, Model model, @PathVariable("id") long id) {
        if (httpSession.getAttribute("loggedOwner") != null) {
            model.addAttribute("allPetVisits", visitRepository.findAllByPet_Id(id));
            model.addAttribute("petId", id);
            httpSession.setAttribute("petIdSess", id);
            httpSession.setAttribute("petName", petRepository.findById(id).get().getName());
            return "pet/detailsForOwner";
        } else return "owner/brakUprawnienOwner";
    }

    @GetMapping("owner/petList")
    public String ownerPetList(HttpSession httpSession, Model model) {
        if (httpSession.getAttribute("loggedOwner") != null) {
            model.addAttribute("owner", ownerRepository.findById((long)httpSession.getAttribute("loggedOwner")));
            model.addAttribute("ownerFirstName", ownerRepository.findById((long)httpSession.getAttribute("loggedOwner")).get().getFirstName());
            model.addAttribute("ownerLastName", ownerRepository.findById((long)httpSession.getAttribute("loggedOwner")).get().getLastName());
            model.addAttribute("allPets", petRepository.findAllByOwnersId((long) httpSession.getAttribute("loggedOwner")));
            return "owner/petList";
        } else return "owner/brakUprawnienOwner";
    }

}
