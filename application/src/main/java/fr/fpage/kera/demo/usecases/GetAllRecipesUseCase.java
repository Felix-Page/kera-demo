package fr.fpage.kera.demo.usecases;

import fr.fpage.kera.demo.domain.Recipe;

import java.util.List;

public interface GetAllRecipesUseCase {
    List<Recipe> execute();
}
