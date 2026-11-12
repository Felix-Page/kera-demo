package fr.fpage.kera.demo.interactors;

import fr.fpage.kera.application.GenericPort;
import fr.fpage.kera.demo.domain.Ingredient;
import fr.fpage.kera.demo.usecases.GetAllIngredientsUseCase;

import java.util.List;
import java.util.UUID;

public class GetAllIngredientsInteractor implements GetAllIngredientsUseCase {
    private final GenericPort<UUID, Ingredient> ingredientPort;

    public GetAllIngredientsInteractor(GenericPort<UUID, Ingredient> ingredientPersistence) {
        this.ingredientPort = ingredientPersistence;
    }

    @Override
    public List<Ingredient> execute() {
        return this.ingredientPort.findAll();
    }
}
