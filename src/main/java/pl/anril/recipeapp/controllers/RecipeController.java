package pl.anril.recipeapp.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.anril.recipeapp.domain.Recipe;
import pl.anril.recipeapp.repositories.RecipeRepository;

@RequestMapping("/recipe")
@Controller
@RequiredArgsConstructor
public class RecipeController {
    private final RecipeRepository recipeRepository;

    @RequestMapping("/{recipeId}/show")
    public String showRecipe(Model model, @PathVariable String recipeId) {
        model.addAttribute("recipe", recipeRepository.findById(Long.valueOf(recipeId)).orElse(null));
        return "recipe/show";
    }

    @RequestMapping("/{recipeId}/update")
    public String updateRecipe(Model model, @PathVariable String recipeId) {
        model.addAttribute("recipe", recipeRepository.findById(Long.valueOf(recipeId)).orElse(null));
        return "recipe/recipeform";
    }

    @RequestMapping("/new")
    public String newRecipe(Model model) {
        model.addAttribute("recipe", new Recipe());
        return "recipe/recipeform";
    }

    @PostMapping
    @RequestMapping("/")
    public String saveOrUpdateRecipe(@ModelAttribute Recipe recipe) {
        Recipe savedRecipe = recipeRepository.save(recipe);

        return "redirect:/recipe/" + savedRecipe.getId() + "/show";
    }
}
