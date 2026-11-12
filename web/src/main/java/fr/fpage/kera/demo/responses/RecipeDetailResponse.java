package fr.fpage.kera.demo.responses;

import java.util.List;
import java.util.UUID;

public record RecipeDetailResponse(
        UUID id,
        String name,
        int servings,
        List<RecipeIngredientResponse> ingredients,
        List<RecipeStepResponse> steps
) {
}
