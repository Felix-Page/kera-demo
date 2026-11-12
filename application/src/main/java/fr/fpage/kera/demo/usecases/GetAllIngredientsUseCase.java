package fr.fpage.kera.demo.usecases;

import fr.fpage.kera.demo.domain.Ingredient;

import java.util.List;

public interface GetAllIngredientsUseCase {
    List<Ingredient> execute();
}
