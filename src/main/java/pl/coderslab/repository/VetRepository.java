package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.Owner;
import pl.coderslab.entity.Vet;

@Transactional
@Repository
public interface VetRepository extends JpaRepository<Vet, Long> {
    Vet findByLogin(String login);
}
