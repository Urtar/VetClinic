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
public class PetController {

    @Autowired
    private PetRepository petRepository;
    @Autowired
    private VisitRepository visitRepository;
    @Autowired
    private OwnerRepository ownerRepository;

    @GetMapping("pet/{id}/details")
    public String petsList(HttpSession httpSession, Model model, @PathVariable("id") long id) {
        if (httpSession.getAttribute("loggedVet") != null) {
            model.addAttribute("allPetVisits", visitRepository.findAllByPet_Id(id));
            model.addAttribute("petId", id);
            httpSession.setAttribute("petIdSess", id);
            httpSession.setAttribute("petName", petRepository.findById(id).get().getName());
            return "visit/list";
        } else return "vet/brakUprawnien";
    }

    @GetMapping("pet/list")
    public String petList(HttpSession httpSession, Model model) {
        if (httpSession.getAttribute("loggedVet") != null) {
            model.addAttribute("ownerName", ownerRepository.findById((long) httpSession.getAttribute("ownerIdSess")).get().getFirstName());
            model.addAttribute("allPets", petRepository.findAllByOwnersId((long) httpSession.getAttribute("ownerIdSess")));
            return "pet/list";
        } else return "pet/brakUprawnien";
    }
}
