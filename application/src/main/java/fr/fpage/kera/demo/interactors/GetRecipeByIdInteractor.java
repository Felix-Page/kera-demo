package fr.fpage.kera.demo.interactors;

import fr.fpage.kera.application.GenericPort;
import fr.fpage.kera.demo.domain.Recipe;
import fr.fpage.kera.demo.usecases.GetRecipeByIdUseCase;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public class GetRecipeByIdInteractor implements GetRecipeByIdUseCase {
    private final GenericPort<UUID, Recipe> recipePort;

    public GetRecipeByIdInteractor(GenericPort<UUID, Recipe> recipePersistence) {
        this.recipePort = recipePersistence;
    }

    @Override
    public Optional<Result> execute(UUID id, int servings) {
        Objects.requireNonNull(id, "Recipe id must not be null");
        if (servings <= 0) {
            throw new IllegalArgumentException("Servings must be strictly positive");
        }
        return this.recipePort.findById(id)
                .map(recipe -> toScaledResult(recipe, servings));
    }

    private Result toScaledResult(Recipe recipe, int requestedServings) {
        List<ScaledIngredient> scaledIngredients = recipe.getIngredients().stream()
                .map(ri -> new ScaledIngredient(
                        ri.getIngredient(),
                        ri.scaleQuantity(recipe.getServings(), requestedServings),
                        ri.getUnit()
                ))
                .toList();

        return new Result(
                recipe.getId(),
                recipe.getName(),
                requestedServings,
                scaledIngredients,
                recipe.getSteps()
        );
    }
}
