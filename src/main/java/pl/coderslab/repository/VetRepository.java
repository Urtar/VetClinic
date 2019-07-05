package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.Vet;

@Transactional
@Repository
public interface VetRepository extends JpaRepository<Vet, Long> {
    Vet findByLogin(String login);

    Vet findById(long id);

    @Query("select v from Vet v where v.firstName = :name")
    Vet findByFirstName(@Param("name") String firstName);
}
