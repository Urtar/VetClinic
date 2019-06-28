package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.Pet;

@Transactional
@Repository
public interface PetRepository extends JpaRepository<Pet,Long> {
}
