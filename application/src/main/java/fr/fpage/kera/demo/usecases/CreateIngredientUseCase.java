package fr.fpage.kera.demo.usecases;

import fr.fpage.kera.demo.domain.Ingredient;

public interface CreateIngredientUseCase {
    Ingredient execute(String name);
}
