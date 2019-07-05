package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.PetType;

@Transactional
@Repository
public interface PetTypeRepository extends JpaRepository<PetType,Long> {

}
