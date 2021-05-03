package pl.anril.recipeapp.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.anril.recipeapp.domain.Ingredient;

import java.util.Set;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
    Set<Ingredient> findAllByRecipeId(Long recipeId);
}
