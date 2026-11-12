package fr.fpage.kera.demo.entities;

import jakarta.persistence.*;

@Entity(name = "recipe_step")
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"recipe_id", "step_number"}))
public class RecipeStepEntity extends AbstractEntity  {
    @Column(name = "step_number", nullable = false, check = @CheckConstraint(constraint = "step_number > 0"))
    private int stepNumber;

    @Column(nullable = false)
    private String description;

    public RecipeStepEntity() {
        super();
    }

    public int getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(int stepNumber) {
        this.stepNumber = stepNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
