package pl.coderslab;

import org.springframework.beans.factory.annotation.Autowired;
import pl.coderslab.repository.AdminRepository;
import pl.coderslab.repository.OwnerRepository;
import pl.coderslab.repository.VetRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LoginValidator implements ConstraintValidator<LoginValid, String> {
    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private VetRepository vetRepository;

    @Override
    public void initialize(LoginValid constraintAnnotation) {
    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try{if(ownerRepository.findByLogin(value).getLogin().equals(null) && vetRepository.findByLogin(value).getLogin().equals(null) && adminRepository.findByLogin(value).getLogin().equals(null));}
        catch (NullPointerException e){
            return true;
        }
        return false;
    }
}
//try{ownerRepository.findByLogin(value).getLogin(),
//        vetRepository.findByLogin(value).getLogin(), adminRepository.findByLogin(value).getLogin())}
//        catch (NullPointerException e){
//        return true;
//        }