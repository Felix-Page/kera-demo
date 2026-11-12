package fr.fpage.kera.demo;

import fr.fpage.kera.persistence.GenericPortImpl;
import fr.fpage.kera.demo.domain.Ingredient;
import fr.fpage.kera.demo.entities.IngredientEntity;
import fr.fpage.kera.demo.mappers.IngredientEntityMapper;
import fr.fpage.kera.demo.repositories.IngredientJpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class IngredientPersistenceAdapter extends GenericPortImpl<UUID, Ingredient, IngredientEntity, IngredientJpaRepository, IngredientEntityMapper> {
    public IngredientPersistenceAdapter(IngredientJpaRepository repository, IngredientEntityMapper mapper) {
        super(repository, mapper);
    }
}
