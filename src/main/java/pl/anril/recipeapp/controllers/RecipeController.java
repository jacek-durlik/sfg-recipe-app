package pl.anril.recipeapp.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.anril.recipeapp.repositories.RecipeRepository;

@RequestMapping("/recipe")
@Controller
@RequiredArgsConstructor
public class RecipeController {
    private final RecipeRepository recipeRepository;

    @RequestMapping("/show/{recipeId}")
    public String showRecipe(Model model, @PathVariable String recipeId) {
        model.addAttribute("recipe", recipeRepository.findById(Long.valueOf(recipeId)).orElse(null));
        return "recipe/show";
    }
}
