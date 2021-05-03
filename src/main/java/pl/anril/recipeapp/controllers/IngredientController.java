package pl.anril.recipeapp.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.anril.recipeapp.service.IngredientService;
import pl.anril.recipeapp.service.RecipeService;

@Controller
@RequiredArgsConstructor
public class IngredientController {
    private final RecipeService recipeService;
    private final IngredientService ingredientService;
    
    @RequestMapping("/recipe/{recipeId}/ingredients")
    public String listIngredients(Model model, @PathVariable Long recipeId) {
        model.addAttribute("recipe", recipeService.findById(recipeId));
        model.addAttribute("ingredients", ingredientService.findAllByRecipeId(recipeId));
        return "recipe/ingredient/list";
    }
}
