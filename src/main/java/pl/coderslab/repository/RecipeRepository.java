package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.Recipe;

import java.util.List;

@Transactional
@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    @Query("select r from Recipe r where r.visit.id = :id")
    List<Recipe> findAllByVisit_Id(@Param("id")long id);
    @Query("select r from Recipe r where r.visit.id = :id")
    List<Recipe> findRecipesByVisitId(@Param("id")long id);

    Recipe findById(long id);
}
