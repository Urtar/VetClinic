package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Recipe;
import pl.coderslab.repository.PetRepository;
import pl.coderslab.repository.RecipeRepository;
import pl.coderslab.repository.VisitRepository;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class RecipeController {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private VisitRepository visitRepository;

    @GetMapping("recipe/add")
    public String addRecipe(Model model, HttpSession httpSession) {
        model.addAttribute("ownerPesel", httpSession.getAttribute("ownerPeselSess"));
        model.addAttribute("allVisitRecipes", recipeRepository.findRecipesByVisitId((long) httpSession.getAttribute("visitIdSess")));
        model.addAttribute("recipe", new Recipe());
        return "recipe/add";
    }

    @PostMapping("recipe/add")
    public String addRecipe(@ModelAttribute @Valid Recipe recipe, BindingResult result, HttpSession httpSession, Model
            model) {
        if (result.hasErrors()) {
            return "recipe/add";
        }
        if (httpSession.getAttribute("loggedVet") != null) {
            model.addAttribute("allVisitRecipes", recipeRepository.findRecipesByVisitId((long) httpSession.getAttribute("visitIdSess")));
            recipe.setPet(petRepository.findById((long) httpSession.getAttribute("petIdSess")));
            recipe.setVisit(visitRepository.findById((long) httpSession.getAttribute("visitIdSess")));
            model.addAttribute("ownerPesel", httpSession.getAttribute("ownerPeselSess"));
            recipeRepository.save(recipe);
            return "redirect:/recipe/list";
        } else
            return "redirect:/visit/brakUprawnien";
    }

    @GetMapping("recipe/list")
    public String recipeList(HttpSession httpSession, Model model) {
        if (httpSession.getAttribute("loggedVet") != null) {
            model.addAttribute("allVisitRecipes", recipeRepository.findRecipesByVisitId((long) httpSession.getAttribute("visitIdSess")));
            return "recipe/list";
        } else return "recipe/brakUprawnien";
    }

    @GetMapping("recipe/{id}/details")
    public String recipeDetails(HttpSession httpSession, Model model, @PathVariable("id") long id) {
        if (httpSession.getAttribute("loggedVet") != null) {
            //model.addAttribute("allVisitRecipes", recipeRepository.findRecipesByVisitId((long) httpSession.getAttribute("visitIdSess")));
            model.addAttribute("ownerPesel", httpSession.getAttribute("ownerPeselSess"));
            model.addAttribute("recipe", recipeRepository.findById(id));
            return "recipe/details";
        } else return "recipe/brakUprawnien";
    }
}
