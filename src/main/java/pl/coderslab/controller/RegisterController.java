package pl.coderslab.controller;


import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Admin;
import pl.coderslab.entity.Owner;
import pl.coderslab.entity.Pet;
import pl.coderslab.entity.Vet;
import pl.coderslab.repository.OwnerRepository;
import pl.coderslab.repository.PetRepository;
import pl.coderslab.repository.VetRepository;

@Controller
@RequestMapping("/")
public class RegisterController {
    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private VetRepository vetRepository;
    @Autowired
    private PetRepository petRepository;

    @GetMapping("owner/add")
    public String addOwner(Model model) {
        model.addAttribute("owner", new Owner());
        return "owner/add";
    }

    @PostMapping("owner/add")
    public String addOwner(@ModelAttribute Owner owner, @ModelAttribute Admin admin) {
        if (admin.getPassword() == "gh12@%;5RvBu") {
            String hashedPassword = BCrypt.hashpw(owner.getPassword(), BCrypt.gensalt());
            owner.setPassword(hashedPassword);
            ownerRepository.save(owner);
            return "redirect:owner/authentication/login";
        } else {
            return "redirect:owner/brakUprawnien";
        }
    }

    @GetMapping("vet/add")//Dodać do widoku dodawania vet pole do wprowadzenia hasła admin
    public String addVet(Model model) {
        model.addAttribute("vet", new Vet());
        return "vet/add";
    }

    @PostMapping("vet/add")
    public String addVet(@ModelAttribute Vet vet, @ModelAttribute Admin admin) {
        if (admin.getPassword() == "gh12@%;5RvBu") {
            String hashedPassword = BCrypt.hashpw(vet.getPassword(), BCrypt.gensalt());
            vet.setPassword(hashedPassword);
            vetRepository.save(vet);
            return "redirect:vet/authentication/login";
        } else
            return "redirect:vet/brakUprawnien";
    }

    @GetMapping("pet/add")//Dodać do widoku dodawania vet pole do wprowadzenia hasła admin
    public String addPet(Model model) {
        model.addAttribute("pet", new Pet());
        return "pet/add";
    }

    @PostMapping("pet/add")
    public String addPet(@ModelAttribute Pet pet, @ModelAttribute Admin admin) {
            petRepository.save(pet);
            return "redirect:pet/authentication/login";
    }

}