package pl.anril.recipeapp.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.anril.recipeapp.domain.Ingredient;
import pl.anril.recipeapp.domain.Recipe;
import pl.anril.recipeapp.domain.UnitOfMeasure;
import pl.anril.recipeapp.service.IngredientService;
import pl.anril.recipeapp.service.RecipeService;
import pl.anril.recipeapp.service.UOMService;

@Controller
@RequiredArgsConstructor
public class IngredientController {
    private final RecipeService recipeService;
    private final IngredientService ingredientService;
    private final UOMService uomService;

    @RequestMapping("/recipe/{recipeId}/ingredients")
    public String listIngredients(Model model, @PathVariable Long recipeId) {
        model.addAttribute("recipe", recipeService.findById(recipeId));
        model.addAttribute("ingredients", ingredientService.findAllByRecipeId(recipeId));
        return "recipe/ingredient/list";
    }

    @RequestMapping("/recipe/{recipeId}/ingredient/{ingredientId}/show")
    public String showIngredient(Model model, @PathVariable Long recipeId, @PathVariable Long ingredientId) {
        model.addAttribute("recipe", recipeService.findById(recipeId));
        model.addAttribute("ingredient", ingredientService.findById(ingredientId));
        model.addAttribute("uomList", uomService.findAll());
        return "recipe/ingredient/show";
    }

    @RequestMapping("/recipe/{recipeId}/ingredient/{ingredientId}/update")
    public String updateIngredient (Model model, @PathVariable Long recipeId, @PathVariable Long ingredientId) {
        model.addAttribute("recipe", recipeService.findById(recipeId));
        model.addAttribute("ingredient", ingredientService.findById(ingredientId));
        model.addAttribute("uomList", uomService.findAll());
        return "recipe/ingredient/ingredientform";
    }

    @PostMapping
    @RequestMapping("/recipe/{recipeId}/ingredient")
    public String saveIngredient(@ModelAttribute Ingredient ingredient, @PathVariable Long recipeId) {
        final Recipe recipe = recipeService.findById(recipeId);
        final UnitOfMeasure uom = uomService.findById(ingredient.getUomId());
        ingredient.setUnitOfMeasure(uom);
        ingredient.setRecipe(recipe);
        Ingredient savedIngredient = ingredientService.save(ingredient);
        recipe.getIngredients().add(savedIngredient);
        return "redirect:/recipe/" + recipeId + "/ingredient/" + savedIngredient.getId() + "/show";
    }

    @RequestMapping("/recipe/{recipeId}/ingredient/new")
    public String newIngredient(Model model, @PathVariable Long recipeId) {
        final Recipe recipe = recipeService.findById(recipeId);
        final Ingredient ingredient = new Ingredient();
        ingredient.setRecipe(recipe);
        model.addAttribute("recipe", recipe);
        model.addAttribute("ingredient", ingredient);
        model.addAttribute("uomList", uomService.findAll());
        return "recipe/ingredient/ingredientform";
    }
}
