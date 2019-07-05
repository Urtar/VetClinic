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
        if (ownerRepository.findByLogin(value) == null || vetRepository.findByLogin(value) == null || adminRepository.findByLogin(value) == null) {
            return true;
        } else return ownerRepository.findByLogin(value).getLogin() != value && vetRepository.findByLogin(value).getLogin() != value && adminRepository.findByLogin(value).getLogin() != value;
    }
}
