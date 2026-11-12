package fr.fpage.kera.demo.usecases;

import fr.fpage.kera.demo.domain.Ingredient;
import fr.fpage.kera.demo.domain.RecipeStep;
import fr.fpage.kera.demo.domain.Unit;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public interface GetRecipeByIdUseCase {
    Optional<Result> execute(UUID id, int servings);

    record Result(
            UUID id,
            String name,
            int servings,
            List<ScaledIngredient> ingredients,
            List<RecipeStep> steps
    ) {
        public Result {
            Objects.requireNonNull(id, "Recipe id must not be null");
            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException("Recipe name must not be blank");
            }
            if (servings <= 0) {
                throw new IllegalArgumentException("Servings must be strictly positive");
            }
            Objects.requireNonNull(ingredients, "Ingredients must not be null");
            Objects.requireNonNull(steps, "Steps must not be null");
        }
    }

    record ScaledIngredient(
            Ingredient ingredient,
            double quantity,
            Unit unit
    ) {
        public ScaledIngredient {
            Objects.requireNonNull(ingredient, "Ingredient must not be null");
            if (quantity <= 0) {
                throw new IllegalArgumentException("Quantity must be strictly positive");
            }
            Objects.requireNonNull(unit, "Unit must not be null");
        }
    }
}
