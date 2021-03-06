package pl.anril.recipeapp.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import pl.anril.recipeapp.domain.Recipe;
import pl.anril.recipeapp.service.RecipeService;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

class IndexControllerTest {
    IndexController indexController;
    @Mock
    RecipeService recipeService;
    @Mock
    Model model;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        indexController = new IndexController(recipeService);
    }

    @Test
    void testMockMVC() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
}

    @Test
    void getIndexPage() {

        Set<Recipe> recipes = new HashSet<>();
        recipes.add(new Recipe());
        Recipe recipe = new Recipe();
        recipe.setDescription("test");
        recipes.add(recipe);

        when(recipeService.findAll()).thenReturn(recipes);
        ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

        assertThat(indexController.getIndexPage(model), equalTo("index"));
        verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());
        verify(recipeService, times(1)).findAll();

        Set<Recipe> setInController = argumentCaptor.getValue();
        assertThat(setInController.size(), equalTo(2));
    }
}