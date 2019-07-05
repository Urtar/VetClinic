package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.Race;

@Transactional
@Repository
public interface RaceRepository extends JpaRepository<Race, Long> {

}
