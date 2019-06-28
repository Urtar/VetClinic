package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.Visit;

@Transactional
@Repository
public interface VisitRepository extends JpaRepository<Visit, Long> {
}
