package pl.anril.recipeapp.service.impl;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.anril.recipeapp.domain.Recipe;
import pl.anril.recipeapp.repositories.RecipeRepository;

import java.util.Arrays;
import java.util.Optional;
import java.util.Set;

class RecipeServiceJpaTest {
    RecipeServiceJpa recipeServiceJpa;

    @Mock
    RecipeRepository recipeRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        recipeServiceJpa = new RecipeServiceJpa(recipeRepository);
        when(recipeRepository.findAll()).thenReturn(Arrays.asList(new Recipe()));
        when(recipeRepository.findById(any())).thenReturn(Optional.of(new Recipe()));
    }

    @Test
    void findAll() {
        Set<Recipe> recipes = recipeServiceJpa.findAll();
        assertThat(recipes.size(), equalTo(1));
        verify(recipeRepository, times(1)).findAll();
    }

    @Test
    void getRecipeByIdTest() {
        Recipe recipe = recipeServiceJpa.findById(1L);
        assertThat(recipe, notNullValue());
        verify(recipeRepository).findById(any());
    }
}