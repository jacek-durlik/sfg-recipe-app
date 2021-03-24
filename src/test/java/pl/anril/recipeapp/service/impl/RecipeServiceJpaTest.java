package pl.anril.recipeapp.service.impl;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.anril.recipeapp.domain.Recipe;
import pl.anril.recipeapp.repositories.RecipeRepository;

import java.util.Arrays;
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
    }

    @Test
    void findAll() {
        Set<Recipe> recipes = recipeServiceJpa.findAll();
        assertThat(recipes.size(), equalTo(1));
        verify(recipeRepository, times(1)).findAll();
    }
}