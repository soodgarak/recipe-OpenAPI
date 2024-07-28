package io.openAPI_test.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.openAPI_test.domain.Recipe;
import io.openAPI_test.domain.RecipeApi;
import io.openAPI_test.repository.RecipeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeService {
    private final RecipeRepo recipeRepo;

    public List<Recipe> convertStringToRecipe(String recipeWithString) {
        RecipeApi recipeApi = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            recipeApi = objectMapper.readValue(recipeWithString, RecipeApi.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return recipeApi.getRecipeApiDetail().getRecipeList();
    }
}
