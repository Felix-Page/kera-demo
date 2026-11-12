package fr.fpage.kera.demo.interactors;

import fr.fpage.kera.application.GenericPort;
import fr.fpage.kera.demo.domain.Recipe;
import fr.fpage.kera.demo.usecases.GetAllRecipesUseCase;

import java.util.List;
import java.util.UUID;

public class GetAllRecipesInteractor implements GetAllRecipesUseCase {
    private final GenericPort<UUID, Recipe> recipePort;

    public GetAllRecipesInteractor(GenericPort<UUID, Recipe> recipePersistence) {
        this.recipePort = recipePersistence;
    }

    @Override
    public List<Recipe> execute() {
        return this.recipePort.findAll();
    }
}
