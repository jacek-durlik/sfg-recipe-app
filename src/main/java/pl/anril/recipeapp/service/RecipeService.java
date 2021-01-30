package pl.anril.recipeapp.service;

import pl.anril.recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> findAll();
    Recipe findById(Long id);
    Recipe save(Recipe recipe);
}
