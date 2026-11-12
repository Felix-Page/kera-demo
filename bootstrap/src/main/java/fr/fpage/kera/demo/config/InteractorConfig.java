package fr.fpage.kera.demo.config;

import fr.fpage.kera.application.GenericPort;
import fr.fpage.kera.demo.domain.Ingredient;
import fr.fpage.kera.demo.domain.Recipe;
import fr.fpage.kera.demo.interactors.CreateIngredientInteractor;
import fr.fpage.kera.demo.interactors.DeleteIngredientInteractor;
import fr.fpage.kera.demo.interactors.GetAllIngredientsInteractor;
import fr.fpage.kera.demo.interactors.GetAllRecipesInteractor;
import fr.fpage.kera.demo.interactors.GetRecipeByIdInteractor;
import fr.fpage.kera.demo.usecases.CreateIngredientUseCase;
import fr.fpage.kera.demo.usecases.DeleteIngredientUseCase;
import fr.fpage.kera.demo.usecases.GetAllIngredientsUseCase;
import fr.fpage.kera.demo.usecases.GetAllRecipesUseCase;
import fr.fpage.kera.demo.usecases.GetRecipeByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Configuration
public class InteractorConfig {
    @Bean
    public GetAllRecipesUseCase getAllRecipesUseCase(GenericPort<UUID, Recipe> recipePersistenceAdapter) {
        return new GetAllRecipesInteractor(recipePersistenceAdapter);
    }

    @Bean
    public GetRecipeByIdUseCase getRecipeByIdUseCase(GenericPort<UUID, Recipe> recipePersistenceAdapter) {
        return new GetRecipeByIdInteractor(recipePersistenceAdapter);
    }

    @Bean
    public CreateIngredientUseCase createIngredientUseCase(GenericPort<UUID, Ingredient> ingredientPersistenceAdapter) {
        return new CreateIngredientInteractor(ingredientPersistenceAdapter);
    }

    @Bean
    public DeleteIngredientUseCase deleteIngredientUseCase(GenericPort<UUID, Ingredient> ingredientPersistenceAdapter) {
        return new DeleteIngredientInteractor(ingredientPersistenceAdapter);
    }

    @Bean
    public GetAllIngredientsUseCase getAllIngredientsUseCase(GenericPort<UUID, Ingredient> ingredientPersistenceAdapter) {
        return new GetAllIngredientsInteractor(ingredientPersistenceAdapter);
    }
}
