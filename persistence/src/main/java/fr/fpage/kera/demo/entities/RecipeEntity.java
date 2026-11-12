package fr.fpage.kera.demo.entities;

import fr.fpage.kera.persistence.entity.ReferenceableEntity;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "recipe")
public class RecipeEntity extends AbstractEntity implements ReferenceableEntity {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false, check = @CheckConstraint(constraint = "servings > 0"))
    private int servings;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "recipe_id", nullable = false)
    private List<RecipeIngredientEntity> ingredients;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "recipe_id", nullable = false)
    @OrderBy("stepNumber ASC")
    private List<RecipeStepEntity> steps;

    public RecipeEntity() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public List<RecipeIngredientEntity> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<RecipeIngredientEntity> ingredients) {
        this.ingredients = ingredients;
    }

    public List<RecipeStepEntity> getSteps() {
        return steps;
    }

    public void setSteps(List<RecipeStepEntity> steps) {
        this.steps = steps;
    }
}
