package pl.anril.recipeapp.service;

import pl.anril.recipeapp.domain.Ingredient;

import java.util.Set;

public interface IngredientService {
    Set<Ingredient> findAllByRecipeId(Long recipeId);
}
