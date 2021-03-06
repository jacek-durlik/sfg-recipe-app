package pl.anril.recipeapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.anril.recipeapp.domain.Ingredient;
import pl.anril.recipeapp.repositories.IngredientRepository;
import pl.anril.recipeapp.service.IngredientService;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class IngredientServiceJpa implements IngredientService {
    private final IngredientRepository ingredientRepository;

    @Override
    public Set<Ingredient> findAllByRecipeId(Long recipeId) {
        return ingredientRepository.findAllByRecipeId(recipeId);
    }

    @Override
    public Ingredient findById(Long id) {
        return ingredientRepository.findById(id).orElse(null);
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    @Override
    public void deleteById(Long id) {
        ingredientRepository.deleteById(id);
    }
}
