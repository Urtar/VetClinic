package pl.coderslab.register;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.entity.Admin;
import pl.coderslab.entity.Owner;
import pl.coderslab.entity.Vet;
import pl.coderslab.repository.AdminRepository;
import pl.coderslab.repository.OwnerRepository;
import pl.coderslab.repository.VetRepository;

@Service
public class AuthenticationService {

    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private VetRepository vetRepository;
    @Autowired
    private AdminRepository adminRepository;


    public boolean givenLoginExistInDatabaseOwner(String login) {
        Owner owner = ownerRepository.findByLogin(login);
        return owner != null;
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
        return vet != null;
    }

    public Vet authenticateVet(String login, String password) {
        Vet vet = vetRepository.findByLogin(login);
        boolean equalPassword = BCrypt.checkpw(password, vet.getPassword());
        if (equalPassword) {
            return vet;
        }
        return null;
    }

    public boolean givenLoginExistInDatabaseAdmin(String login) {
        Admin admin = adminRepository.findByLogin(login);
        return admin != null;
    }

    public Admin authenticateAdmin(String login, String password) {
        Admin admin = adminRepository.findByLogin(login);
        boolean equalPassword = BCrypt.checkpw(password, admin.getPassword());
        if (equalPassword) {
            return admin;
        }
        return null;
    }
}
