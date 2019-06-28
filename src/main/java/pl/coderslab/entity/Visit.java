package pl.coderslab.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    @CreatedDate
    private LocalDateTime dateOfVisit;
    @CreatedDate
    private LocalDateTime updated;
    @NotEmpty
    private String description;

    @OneToMany(mappedBy = "visit")
    private List<Recipe> recipes;

    @ManyToOne
    private Vet vet;

    @ManyToOne
    private Pet pet;

    public Visit(@NotNull LocalDateTime dateOfVisit) {
        this.dateOfVisit = dateOfVisit;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getDateOfVisit() {
        return dateOfVisit;
    }

    public void setDateOfVisit(LocalDateTime dateOfVisit) {
        this.dateOfVisit = dateOfVisit;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public Vet getVet() {
        return vet;
    }

    public void setVet(Vet vet) {
        this.vet = vet;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
