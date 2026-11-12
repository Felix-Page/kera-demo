package fr.fpage.kera.demo.mappers;

import fr.fpage.kera.persistence.AbstractEntityMapper;
import fr.fpage.kera.persistence.PersistenceMapperConfig;
import fr.fpage.kera.demo.domain.Ingredient;
import fr.fpage.kera.demo.entities.IngredientEntity;
import org.mapstruct.Mapper;

import java.util.UUID;

@Mapper(config = PersistenceMapperConfig.class)
public interface IngredientEntityMapper extends AbstractEntityMapper<UUID, IngredientEntity, Ingredient> {
}
