package fr.fpage.kera.demo;

import fr.fpage.kera.persistence.GenericPortImpl;
import fr.fpage.kera.demo.domain.Recipe;
import fr.fpage.kera.demo.entities.RecipeEntity;
import fr.fpage.kera.demo.mappers.RecipeEntityMapper;
import fr.fpage.kera.demo.repositories.RecipeJpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RecipePersistenceAdapter extends GenericPortImpl<UUID, Recipe, RecipeEntity, RecipeJpaRepository, RecipeEntityMapper> {
    public RecipePersistenceAdapter(RecipeJpaRepository repository, RecipeEntityMapper mapper) {
        super(repository, mapper);
    }
}
