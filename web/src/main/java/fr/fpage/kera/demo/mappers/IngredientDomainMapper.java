package fr.fpage.kera.demo.mappers;

import fr.fpage.kera.web.WebMapperConfig;
import fr.fpage.kera.demo.domain.Ingredient;
import fr.fpage.kera.demo.responses.IngredientResponse;
import org.mapstruct.Mapper;

@Mapper(config = WebMapperConfig.class)
public interface IngredientDomainMapper {
    IngredientResponse toResponse(Ingredient domain);
}
