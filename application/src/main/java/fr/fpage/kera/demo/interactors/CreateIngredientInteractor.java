package fr.fpage.kera.demo.interactors;

import fr.fpage.kera.application.GenericPort;
import fr.fpage.kera.demo.domain.Ingredient;
import fr.fpage.kera.demo.usecases.CreateIngredientUseCase;

import java.util.UUID;

public class CreateIngredientInteractor implements CreateIngredientUseCase {
    private final GenericPort<UUID, Ingredient> ingredientPort;

    public CreateIngredientInteractor(GenericPort<UUID, Ingredient> ingredientPersistence) {
        this.ingredientPort = ingredientPersistence;
    }

    @Override
    public Ingredient execute(String name) {
        return this.ingredientPort.save(Ingredient.create(name));
    }
}
