package fr.fpage.kera.demo.domain;

import fr.fpage.kera.domain.VersionedDomain;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Recipe extends VersionedDomain<UUID> {
    private String name;
    private int servings;
    private List<RecipeIngredient> ingredients;
    private List<RecipeStep> steps;

    public Recipe(
            UUID id,
            LocalDateTime createdAt,
            LocalDateTime updatedAt,
            Long version,
            String name,
            int servings,
            List<RecipeIngredient> ingredients,
            List<RecipeStep> steps
    ) {
        super(id, createdAt, updatedAt, version);
        validateName(name);
        validateServings(servings);
        this.name = name;
        this.servings = servings;
        this.ingredients = Objects.requireNonNull(ingredients, "Recipe ingredients must not be null");
        this.steps = Objects.requireNonNull(steps, "Recipe steps must not be null");
    }

    private static void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Recipe name must not be blank");
        }
    }

    private static void validateServings(int servings) {
        if (servings <= 0) {
            throw new IllegalArgumentException("Servings must be strictly positive");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        validateName(name);
        this.name = name;
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        validateServings(servings);
        this.servings = servings;
    }

    public List<RecipeIngredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<RecipeIngredient> ingredients) {
        this.ingredients = Objects.requireNonNull(ingredients, "Recipe ingredients must not be null");
    }

    public List<RecipeStep> getSteps() {
        return steps;
    }

    public void setSteps(List<RecipeStep> steps) {
        this.steps = Objects.requireNonNull(steps, "Recipe steps must not be null");
    }
}
