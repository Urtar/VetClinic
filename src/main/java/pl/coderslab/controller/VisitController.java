package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Visit;
import pl.coderslab.repository.PetRepository;
import pl.coderslab.repository.VetRepository;
import pl.coderslab.repository.VisitRepository;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class VisitController {

    @Autowired
    private VisitRepository visitRepository;

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private VetRepository vetRepository;

    @ModelAttribute("vetName")
    public String vetName(HttpSession httpSession) {
        return httpSession.getAttribute("vetName").toString();
    }
    @ModelAttribute("ownerId")
    public String ownerId (HttpSession httpSession){
        return httpSession.getAttribute("ownerIdSess").toString();
    }

    @ModelAttribute("petId")
    public String petId(HttpSession httpSession) {
        return httpSession.getAttribute("petIdSess").toString();
    }

    @ModelAttribute("petName")
    public String petName(HttpSession httpSession) {
        return httpSession.getAttribute("petName").toString();
    }


//    @ModelAttribute("allPetVisits")
//    public List<Visit> allVisists(HttpSession httpSession) {
//        return visitRepository.findAllByPet_Id((long)httpSession.getAttribute("petIdSess"));
//    }

    @GetMapping("visit/add")
    public String addVisit(Model model, HttpSession httpSession) {
        model.addAttribute("visit", new Visit());
        return "visit/add";
    }

    @PostMapping("visit/add")
    public String addRace(@ModelAttribute @Valid Visit visit, BindingResult result, HttpSession httpSession, Model
            model) {
        if (result.hasErrors()) {
            return "visit/add";
        }
        if (httpSession.getAttribute("loggedVet") != null) {
            visit.setPet(petRepository.findById((long) httpSession.getAttribute("petIdSess")));
            visit.setVet(vetRepository.findById((long) httpSession.getAttribute("loggedVet")));
            visitRepository.save(visit);
            return "redirect:/visit/list";
        } else
            return "redirect:/visit/brakUprawnien";
    }

    @GetMapping("visit/list")
    public String visitList(HttpSession httpSession, Model model) {
        if (httpSession.getAttribute("loggedVet") != null) {
            model.addAttribute("allPetVisits", visitRepository.findAllByPet_Id((long) httpSession.getAttribute("petIdSess")));
            return "visit/list";
        } else return "visit/brakUprawnien";
    }

    @GetMapping("visit/brakUprawnien")
    public String brakUprawnienVisitAddAdd() {
        return "visit/brakUprawnien";
    }

    @GetMapping("visit/{id}/details")
    public String visitsList(HttpSession httpSession, Model model, @PathVariable("id") long id) {
        if (httpSession.getAttribute("loggedVet") != null) {
            model.addAttribute("allPetVisits", visitRepository.findAllByPet_Id((long) httpSession.getAttribute("petIdSess")));
            // model.addAttribute("visit",visitRepository.findById(id));
            //httpSession.setAttribute("petName", petRepository.findById((long) httpSession.getAttribute("petIdSess")).get().getName());
            model.addAttribute("visit", visitRepository.findByPet_IdAAndVisit_Id((long) httpSession.getAttribute("petIdSess"), id));
            model.addAttribute("petId", httpSession.getAttribute("petIdSess"));
            httpSession.setAttribute("visitIdSess", id);
            return "visit/details";
        } else return "visit/brakUprawnien";
    }
}
