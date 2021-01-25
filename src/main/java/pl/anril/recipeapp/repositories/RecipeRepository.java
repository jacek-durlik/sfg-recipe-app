package pl.anril.recipeapp.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.anril.recipeapp.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
