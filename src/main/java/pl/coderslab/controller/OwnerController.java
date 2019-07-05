package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class OwnerController {


//    @GetMapping("ownerView")
//    public String addOwner(@ModelAttribute Owner owner, @ModelAttribute Admin admin, HttpSession httpSession) {
//        if (httpSession.getAttribute("loggedVet") != null) {
//            String hashedPassword = BCrypt.hashpw(owner.getPassword(), BCrypt.gensalt());
//            owner.setPassword(hashedPassword);
//            ownerRepository.save(owner);
//            return "redirect:ownerView";
//        } else {
//            return "redirect:owner/brakUprawnien";
//        }
//    }
}
