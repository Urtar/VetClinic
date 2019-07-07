package pl.coderslab.controller;


import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.*;
import pl.coderslab.repository.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class RegisterController {
    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private VetRepository vetRepository;
    @Autowired
    private PetRepository petRepository;
    @Autowired
    private RaceRepository raceRepository;
    @Autowired
    private PetTypeRepository petTypeRepository;

    @GetMapping("owner/add")
    public String addOwner(Model model) {
        model.addAttribute("owner", new Owner());
        return "owner/add";
    }

    @PostMapping("owner/add")
    public String addOwner(@ModelAttribute @Valid Owner owner, BindingResult result,@ModelAttribute Admin admin, HttpSession httpSession) {
        if (result.hasErrors()) {
            return "owner/add";
        }
        if (httpSession.getAttribute("loggedVet") != null) {
            String hashedPassword = BCrypt.hashpw(owner.getPassword(), BCrypt.gensalt());
            owner.setPassword(hashedPassword);
            ownerRepository.save(owner);
            return "redirect:/owner/list";
        } else {
            return "redirect:/owner/brakUprawnien";
        }
    }
    @GetMapping("owner/{id}/edit")
    public String editOwner(Model model, @PathVariable("id") long id) {
        model.addAttribute("owner", ownerRepository.findById(id).get());
        return "owner/edit";
    }

    @PostMapping("owner/{id}/edit")
    public String editOwner(@ModelAttribute @Valid Owner owner, BindingResult result,@ModelAttribute Admin admin, HttpSession httpSession) {
        if (result.hasErrors()) {
            return "owner/edit";
        }
        if (httpSession.getAttribute("loggedVet") != null) {
            String hashedPassword = BCrypt.hashpw(owner.getPassword(), BCrypt.gensalt());
            owner.setPassword(hashedPassword);
            ownerRepository.saveAndFlush(owner);
            return "redirect:/owner/list";
        } else {
            return "redirect:/owner/brakUprawnien";
        }
    }

    @GetMapping("vet/add")
    public String addVet(Model model) {
        model.addAttribute("vet", new Vet());
        return "vet/add";
    }

    @PostMapping("vet/add")
    public String addVet(@ModelAttribute @Valid Vet vet,BindingResult result, HttpSession httpSession) {
        if (result.hasErrors()) {
            return "vet/add";
        }
        if (httpSession.getAttribute("loggedAdmin") != null) {
            String hashedPassword = BCrypt.hashpw(vet.getPassword(), BCrypt.gensalt());
            vet.setPassword(hashedPassword);
            vetRepository.save(vet);
            return "redirect:/login";
        } else
            return "redirect:/vet/brakUprawnien";
    }

    @GetMapping("vet/{id}/edit")
    public String editVet(Model model, @PathVariable("id")long id) {
        model.addAttribute("vet", vetRepository.findById(id));
        return "vet/edit";
    }

    @PostMapping("vet/{id}/edit")
    public String editVet(@ModelAttribute @Valid Vet vet,BindingResult result, HttpSession httpSession) {
        if (result.hasErrors()) {
            return "vet/edit";
        }
        if (httpSession.getAttribute("loggedAdmin") != null) {
            String hashedPassword = BCrypt.hashpw(vet.getPassword(), BCrypt.gensalt());
            vet.setPassword(hashedPassword);
            vetRepository.saveAndFlush(vet);
            return "redirect:/login";
        } else
            return "redirect:/vet/brakUprawnien";
    }

    @ModelAttribute("allRaces")
    public List<Race> viewAllRaceList() {
        return raceRepository.findAll();
    }

    @ModelAttribute("allOwners")
    public List<Owner> viewAllOwnersList() {
        return ownerRepository.findAll();
    }

    @ModelAttribute("allPetTypes")
    public List<PetType> viewAllPetTypesList() {
        return petTypeRepository.findAll();
    }

    @GetMapping("pet/add")
    public String addPet(Model model,HttpSession httpSession) {
        model.addAttribute("ownerName",ownerRepository.getOne((long)httpSession.getAttribute("ownerIdSess")).getFirstName());
        model.addAttribute("pet", new Pet());
        return "pet/add";
    }

    @PostMapping("pet/add")
    public String addPet(@ModelAttribute @Valid Pet pet,BindingResult result, HttpSession httpSession, Model model) {
        if (result.hasErrors()) {
            return "pet/add";
        }
        if (httpSession.getAttribute("loggedVet") != null) {
            pet.setOwner(ownerRepository.findById((long)httpSession.getAttribute("ownerIdSess")).get());
           petRepository.save(pet);
            model.addAttribute("petId", pet.getId());
            return "redirect:/pet/list";
        } else
            return "redirect:/vet/brakUprawnien";
    }

    @GetMapping("pet/{id}/edit")
    public String editPet(Model model, HttpSession httpSession , @PathVariable("id") long id) {
        model.addAttribute("ownerName",ownerRepository.getOne((long)httpSession.getAttribute("ownerIdSess")).getFirstName());
        model.addAttribute("pet", petRepository.findById(id).get());
        return "pet/edit";
    }

    @PostMapping("pet/{id}/edit")
    public String editPet(@ModelAttribute @Valid Pet pet,BindingResult result, HttpSession httpSession, Model model) {
        if (result.hasErrors()) {
            return "pet/edit";
        }
        if (httpSession.getAttribute("loggedVet") != null) {
            pet.setOwner(ownerRepository.findById((long)httpSession.getAttribute("ownerIdSess")).get());
            petRepository.saveAndFlush(pet);
            model.addAttribute("petId", pet.getId());
            return "redirect:/pet/list";
        } else
            return "redirect:/vet/brakUprawnien";
    }

    @GetMapping("race/add")
    public String addRace(Model model) {
        model.addAttribute("race", new Race());
        return "race/add";
    }

    @PostMapping("race/add")
    public String addRace(@ModelAttribute @Valid Race race,BindingResult result, HttpSession httpSession) {
        if (result.hasErrors()) {
            return "race/add";
        }
        if (httpSession.getAttribute("loggedVet") != null) {
            raceRepository.save(race);
            return "redirect:/owner/list";
        } else
            return "redirect:/race/brakUprawnien";
    }
    @GetMapping("pettype/add")
    public String addPetType(Model model) {
        model.addAttribute("petType", new PetType());
        return "petType/add";
    }

    @PostMapping("pettype/add")
    public String addPetType(@ModelAttribute @Valid PetType petType,BindingResult result, HttpSession httpSession) {
        if (result.hasErrors()) {
            return "petType/add";
        }
        if (httpSession.getAttribute("loggedVet") != null) {
            petTypeRepository.save(petType);
            return "redirect:/owner/list";
        } else
            return "redirect:/pettype/brakUprawnien";
    }
    @GetMapping("vet/brakUprawnien")
    public String brakUprawnienVetAdd(){
        return "vet/brakUprawnien";
    }

    @GetMapping("owner/brakUprawnien")
    public String brakUprawnienOwnerAdd(){return "owner/brakUprawnien";}

    @GetMapping("pet/brakUprawnien")
    public  String brakUprawnienPetAdd(){return "pet/brakUprawnien";}

    @GetMapping("race/brakUprawnien")
    public  String brakUprawnienRaceAdd(){return "race/brakUprawnien";}

    @GetMapping("pettype/brakUprawnien")
    public  String brakUprawnienPetTypeAdd(){return "petType/brakUprawnien";}


}