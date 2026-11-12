package fr.fpage.kera.demo.mappers;

import fr.fpage.kera.web.WebMapperConfig;
import fr.fpage.kera.demo.domain.Recipe;
import fr.fpage.kera.demo.responses.RecipeDetailResponse;
import fr.fpage.kera.demo.responses.SimpleRecipeResponse;
import fr.fpage.kera.demo.usecases.GetRecipeByIdUseCase;
import org.mapstruct.Mapper;

@Mapper(config = WebMapperConfig.class)
public interface RecipeDomainMapper {
    SimpleRecipeResponse toSimpleResponse(Recipe domain);

    RecipeDetailResponse toDetailResponse(GetRecipeByIdUseCase.Result result);
}
