package fr.fpage.kera.demo.controllers;

import fr.fpage.kera.demo.mappers.IngredientDomainMapper;
import fr.fpage.kera.demo.requests.CreateIngredientRequest;
import fr.fpage.kera.demo.responses.IngredientResponse;
import fr.fpage.kera.demo.usecases.CreateIngredientUseCase;
import fr.fpage.kera.demo.usecases.DeleteIngredientUseCase;
import fr.fpage.kera.demo.usecases.GetAllIngredientsUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import static fr.fpage.kera.demo.controllers.Constants.API;
import static fr.fpage.kera.demo.controllers.Constants.INGREDIENTS;

@RestController
@RequestMapping(API + INGREDIENTS)
public class IngredientController {
    private final CreateIngredientUseCase createIngredientUseCase;
    private final DeleteIngredientUseCase deleteIngredientUseCase;
    private final GetAllIngredientsUseCase getAllIngredientsUseCase;
    private final IngredientDomainMapper ingredientDomainMapper;

    public IngredientController(
            CreateIngredientUseCase createIngredientUseCase,
            DeleteIngredientUseCase deleteIngredientUseCase,
            GetAllIngredientsUseCase getAllIngredientsUseCase,
            IngredientDomainMapper ingredientDomainMapper
    ) {
        this.createIngredientUseCase = createIngredientUseCase;
        this.deleteIngredientUseCase = deleteIngredientUseCase;
        this.getAllIngredientsUseCase = getAllIngredientsUseCase;
        this.ingredientDomainMapper = ingredientDomainMapper;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Transactional(readOnly = true)
    public List<IngredientResponse> getAllIngredients() {
        return this.getAllIngredientsUseCase.execute().stream()
                .map(this.ingredientDomainMapper::toResponse)
                .toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public IngredientResponse createIngredient(@Valid @RequestBody CreateIngredientRequest request) {
        return this.ingredientDomainMapper.toResponse(
                this.createIngredientUseCase.execute(request.name())
        );
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public void deleteIngredient(@PathVariable("id") UUID id) {
        this.deleteIngredientUseCase.execute(id);
    }
}
