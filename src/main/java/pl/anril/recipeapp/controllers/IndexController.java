package pl.anril.recipeapp.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.anril.recipeapp.domain.Category;
import pl.anril.recipeapp.domain.UnitOfMeasure;
import pl.anril.recipeapp.repositories.CategoryRepository;
import pl.anril.recipeapp.repositories.UOMRepository;
import pl.anril.recipeapp.service.RecipeService;

import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final RecipeService recipeService;

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {

        model.addAttribute("recipes", recipeService.findAll());

        return "index";
    }
}
