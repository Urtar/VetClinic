package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Race;
import pl.coderslab.repository.RaceRepository;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class RaceController {

    @Autowired
    private RaceRepository raceRepository;

    @GetMapping("race/list")
    public String petList(HttpSession httpSession, Model model) {
        if (httpSession.getAttribute("loggedVet") != null) {
            model.addAttribute("allRaces", raceRepository.findAll());
            return "race/list";
        } else return "race/brakUprawnien";
    }

    @GetMapping("race/{id}/edit")
    public String editPetType(Model model, HttpSession httpSession, @PathVariable("id") long id) {
        model.addAttribute("race", raceRepository.findById(id).get());
        return "race/edit";
    }

    @PostMapping("race/{id}/edit")
    public String editPetType(@ModelAttribute @Valid Race race, BindingResult result, HttpSession httpSession, Model model) {
        if (result.hasErrors()) {
            return "race/edit";
        }
        if (httpSession.getAttribute("loggedVet") != null) {
            raceRepository.saveAndFlush(race);
            model.addAttribute("petId", race.getId());
            return "redirect:/race/list";
        } else
            return "redirect:/race/brakUprawnien";
    }
}
