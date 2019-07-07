package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.PetType;
import pl.coderslab.repository.PetTypeRepository;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class PetTypeController {

    @Autowired
    private PetTypeRepository petTypeRepository;

    @GetMapping("petType/list")
    public String petList(HttpSession httpSession, Model model) {
        if (httpSession.getAttribute("loggedVet") != null) {
            model.addAttribute("allPetTypes", petTypeRepository.findAll());
            return "petType/list";
        } else return "petType/brakUprawnien";
    }

    @GetMapping("petType/{id}/edit")
    public String editPetType(Model model, HttpSession httpSession, @PathVariable("id") long id) {
        model.addAttribute("petType", petTypeRepository.findById(id).get());
        return "petType/edit";
    }

    @PostMapping("petType/{id}/edit")
    public String editPetType(@ModelAttribute @Valid PetType petType, BindingResult result, HttpSession httpSession, Model model) {
        if (result.hasErrors()) {
            return "petType/edit";
        }
        if (httpSession.getAttribute("loggedVet") != null) {
            petTypeRepository.saveAndFlush(petType);
            model.addAttribute("petId", petType.getId());
            return "redirect:/petType/list";
        } else
            return "redirect:/petType/brakUprawnien";
    }

}
