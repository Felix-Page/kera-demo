package fr.fpage.kera.demo.interactors;

import fr.fpage.kera.demo.domain.Ingredient;
import fr.fpage.kera.demo.usecases.DeleteIngredientUseCase;
import fr.fpage.kera.application.GenericPort;

import java.util.Objects;
import java.util.UUID;

public class DeleteIngredientInteractor implements DeleteIngredientUseCase {
    private final GenericPort<UUID, Ingredient> ingredientPort;

    public DeleteIngredientInteractor(GenericPort<UUID, Ingredient> ingredientPersistence) {
        this.ingredientPort = ingredientPersistence;
    }

    @Override
    public void execute(UUID id) {
        Objects.requireNonNull(id, "Ingredient id must not be null");
        this.ingredientPort.deleteById(id);
    }
}
