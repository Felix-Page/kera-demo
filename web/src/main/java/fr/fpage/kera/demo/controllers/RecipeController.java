package fr.fpage.kera.demo.controllers;

import fr.fpage.kera.demo.mappers.RecipeDomainMapper;
import fr.fpage.kera.demo.responses.RecipeDetailResponse;
import fr.fpage.kera.demo.responses.SimpleRecipeResponse;
import fr.fpage.kera.demo.usecases.GetAllRecipesUseCase;
import fr.fpage.kera.demo.usecases.GetRecipeByIdUseCase;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

import static fr.fpage.kera.demo.controllers.Constants.API;
import static fr.fpage.kera.demo.controllers.Constants.RECIPES;

@RestController
@RequestMapping(API + RECIPES)
public class RecipeController {
    private final GetAllRecipesUseCase getAllRecipesUseCase;
    private final GetRecipeByIdUseCase getRecipeByIdUseCase;
    private final RecipeDomainMapper recipeDomainMapper;

    public RecipeController(
            GetAllRecipesUseCase getAllRecipesUseCase,
            GetRecipeByIdUseCase getRecipeByIdUseCase,
            RecipeDomainMapper recipeDomainMapper
    ) {
        this.getAllRecipesUseCase = getAllRecipesUseCase;
        this.getRecipeByIdUseCase = getRecipeByIdUseCase;
        this.recipeDomainMapper = recipeDomainMapper;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Transactional(readOnly = true)
    public List<SimpleRecipeResponse> getAllRecipes() {
        return this.getAllRecipesUseCase.execute().stream().map(recipeDomainMapper::toSimpleResponse).toList();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Transactional(readOnly = true)
    public RecipeDetailResponse getRecipeById(
            @PathVariable("id") UUID id,
            @RequestParam("servings") @Positive int servings
    ) {
        return this.getRecipeByIdUseCase.execute(id, servings)
                .map(this.recipeDomainMapper::toDetailResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
