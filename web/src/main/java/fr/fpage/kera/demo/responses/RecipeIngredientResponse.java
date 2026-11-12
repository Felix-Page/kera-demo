package fr.fpage.kera.demo.responses;

import fr.fpage.kera.demo.domain.Unit;

public record RecipeIngredientResponse(
        IngredientResponse ingredient,
        double quantity,
        Unit unit
) {
}
