package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.Pet;

import java.util.List;

@Transactional
@Repository
public interface PetRepository extends JpaRepository<Pet,Long> {

    @Query("select p from Pet p where p.owner.id = :id")
    List<Pet> findAllByOwnersId(@Param("id")long id);

    @Query("select p from Pet p where p.name = :name")
    Pet findByName(@Param("name")String name);

}
