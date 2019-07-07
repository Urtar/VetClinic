package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.Visit;

import java.util.List;

@Transactional
@Repository
public interface VisitRepository extends JpaRepository<Visit, Long> {
    @Query("select v from Visit v where v.pet.id = :id")
    List<Visit> findAllByPet_Id(@Param("id")long id);
    @Query("select v from Visit v where v.pet.id = :petId and v.id = :visitId")
    Visit findByPet_IdAAndVisit_Id(@Param("petId")long petId, @Param(("visitId"))long visitId);
    Visit findById(long id);

}
