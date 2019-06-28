package pl.coderslab.register;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.entity.Owner;
import pl.coderslab.entity.Vet;
import pl.coderslab.repository.OwnerRepository;
import pl.coderslab.repository.VetRepository;

@Service
public class AuthenticationService {

    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private VetRepository vetRepository;


    public boolean givenLoginExistInDatabaseOwner(String login) {
        Owner owner = ownerRepository.findByLogin(login);
        if(owner != null) {
            return true;
        }
        return false;
    }

    public Owner authenticateOwner(String login, String password) {
        Owner owner = ownerRepository.findByLogin(login);
        boolean equalPassword = BCrypt.checkpw(password, owner.getPassword());
        if (equalPassword) {
            return owner;
        }
        return null;
    }
    public boolean givenLoginExistInDatabaseVet(String login) {
        Vet vet = vetRepository.findByLogin(login);
        if(vet != null) {
            return true;
        }
        return false;
    }

    public Vet authenticateVet(String login, String password) {
        Vet vet = vetRepository.findByLogin(login);
        boolean equalPassword = BCrypt.checkpw(password, vet.getPassword());
        if (equalPassword) {
            return vet;
        }
        return null;
    }
}
