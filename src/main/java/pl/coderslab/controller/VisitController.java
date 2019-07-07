package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Visit;
import pl.coderslab.repository.PetRepository;
import pl.coderslab.repository.RecipeRepository;
import pl.coderslab.repository.VetRepository;
import pl.coderslab.repository.VisitRepository;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/")
public class VisitController {

    @Autowired
    private VisitRepository visitRepository;

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private VetRepository vetRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    @ModelAttribute("petId")
    public String petId(HttpSession httpSession) {
        return httpSession.getAttribute("petIdSess").toString();
    }

    @ModelAttribute("petName")
    public String petName(HttpSession httpSession) {
        return httpSession.getAttribute("petName").toString();
    }


    @GetMapping("visit/add")
    public String addVisit(Model model, HttpSession httpSession) {
        model.addAttribute("vetName", vetRepository.findById((long) httpSession.getAttribute("loggedVet")).getFirstName() + vetRepository.findById((long) httpSession.getAttribute("loggedVet")).getLastName());
        model.addAttribute("visit", new Visit());
        return "visit/add";
    }

    @PostMapping("visit/add")
    public String addVisit(@ModelAttribute @Valid Visit visit, BindingResult result, HttpSession httpSession, Model
            model) {
        if (result.hasErrors()) {
            return "visit/add";
        }
        if (httpSession.getAttribute("loggedVet") != null) {
            visit.setPet(petRepository.findById((long) httpSession.getAttribute("petIdSess")).get());
            visit.setVet(vetRepository.findById((long) httpSession.getAttribute("loggedVet")));
            visitRepository.save(visit);
            return "redirect:/visit/list";
        } else
            return "redirect:/visit/brakUprawnien";
    }

    @GetMapping("visit/{id}/edit")
    public String editVisit(Model model, HttpSession httpSession, @PathVariable("id") long id) {
        model.addAttribute("vetName", vetRepository.findById((long) httpSession.getAttribute("loggedVet")).getFirstName() + vetRepository.findById((long) httpSession.getAttribute("loggedVet")).getLastName());
        model.addAttribute("visit", visitRepository.findById(id));
        return "visit/edit";
    }

    @PostMapping("visit/{id}/edit")
    public String editVisit(@PathVariable("id") long id, @ModelAttribute @Valid Visit visit, BindingResult result, HttpSession httpSession, Model
            model) {
        if (result.hasErrors()) {
            return "visit/edit";
        }
        if (httpSession.getAttribute("loggedVet") != null) {
            visit.setDateOfVisit(visitRepository.findById(id).getDateOfVisit());
            visit.setUpdated(LocalDateTime.now());
            visit.setPet(petRepository.findById((long) httpSession.getAttribute("petIdSess")).get());
            visit.setVet(vetRepository.findById((long) httpSession.getAttribute("loggedVet")));
            visitRepository.saveAndFlush(visit);
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
            model.addAttribute("vetName", vetRepository.findById((long) httpSession.getAttribute("loggedVet")).getFirstName() + vetRepository.findById((long) httpSession.getAttribute("loggedVet")).getLastName());
            model.addAttribute("allPetVisits", visitRepository.findAllByPet_Id((long) httpSession.getAttribute("petIdSess")));
            model.addAttribute("visit", visitRepository.findByPet_IdAAndVisit_Id((long) httpSession.getAttribute("petIdSess"), id));
            model.addAttribute("petId", httpSession.getAttribute("petIdSess"));
            httpSession.setAttribute("visitIdSess", id);
            model.addAttribute("allVisitRecipes", recipeRepository.findRecipesByVisitId((long) httpSession.getAttribute("visitIdSess")));
            return "visit/details";
        } else return "visit/brakUprawnien";
    }

    @GetMapping("visit/{id}/detailsForOwner")
    public String visitsListForOwner(HttpSession httpSession, Model model, @PathVariable("id") long id) {
        if (httpSession.getAttribute("loggedOwner") != null) {
            model.addAttribute("visit", visitRepository.findByPet_IdAAndVisit_Id((long) httpSession.getAttribute("petIdSess"), id));
            model.addAttribute("petId", httpSession.getAttribute("petIdSess"));
            model.addAttribute("petName", petRepository.findById((long) httpSession.getAttribute("petIdSess")).get().getName());
            httpSession.setAttribute("visitIdSess", id);
            return "visit/detailsForOwner";
        } else return "visit/brakUprawnien";
    }

}
