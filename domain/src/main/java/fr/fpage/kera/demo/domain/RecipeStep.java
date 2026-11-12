package fr.fpage.kera.demo.domain;

import fr.fpage.kera.domain.VersionedDomain;

import java.time.LocalDateTime;
import java.util.UUID;

public class RecipeStep extends VersionedDomain<UUID> {
    private int stepNumber;
    private String description;

    public RecipeStep(
            UUID id,
            LocalDateTime createdAt,
            LocalDateTime updatedAt,
            Long version,
            int stepNumber,
            String description
    ) {
        super(id, createdAt, updatedAt, version);
        validateStepNumber(stepNumber);
        validateDescription(description);
        this.stepNumber = stepNumber;
        this.description = description;
    }

    private static void validateStepNumber(int stepNumber) {
        if (stepNumber <= 0) {
            throw new IllegalArgumentException("Step number must be strictly positive");
        }
    }

    private static void validateDescription(String description) {
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Step description must not be blank");
        }
    }

    public int getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(int stepNumber) {
        validateStepNumber(stepNumber);
        this.stepNumber = stepNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        validateDescription(description);
        this.description = description;
    }
}
