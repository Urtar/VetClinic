package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.Owner;

@Transactional
@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
    Owner findByEmail(String email);
    Owner findByLogin(String login);
}
