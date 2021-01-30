package pl.anril.recipeapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.anril.recipeapp.domain.Recipe;
import pl.anril.recipeapp.repositories.RecipeRepository;
import pl.anril.recipeapp.service.RecipeService;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class RecipeServiceJpa implements RecipeService {
    private final RecipeRepository recipeRepository;
    @Override
    public Set<Recipe> findAll() {
        Set<Recipe> ret = new HashSet<>();
        recipeRepository.findAll().forEach(ret::add);
        return ret;
    }

    @Override
    public Recipe findById(Long id) {
        return recipeRepository.findById(id).orElse(null);
    }

    @Override
    public Recipe save(Recipe recipe) {
        return recipeRepository.save(recipe);
    }
}
