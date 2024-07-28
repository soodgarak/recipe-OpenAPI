package io.openAPI_test.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.openAPI_test.domain.Recipe;
import io.openAPI_test.domain.RecipeApi;
import io.openAPI_test.repository.RecipeRepo;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeService {
    private final RecipeRepo recipeRepo;

    private List<Recipe> insertRecipe(List<Recipe> recipeList) {
        recipeRepo.saveAll(recipeList);

        return recipeList;
    }

    //private Recipe findRecipe()
    public List<Recipe> convertStringToRecipe(String recipeWithString) {
        RecipeApi recipeApi = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            recipeApi = objectMapper.readValue(recipeWithString, RecipeApi.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return insertRecipe(recipeApi.getRecipeApiDetail().getRecipeList());
    }

//    private RecipeApi convertStringToManualAndManualImage(String recipeWithString) {
//
//        JSONObject jsonObject = new JSONObject(recipeWithString);
//
//        JSONObject recipeApiDetail = jsonObject.getJSONObject("COOKRCP01");
//        JSONArray recipeList = recipeApiDetail.getJSONArray("row");
//        for (int i = 0; i < recipeList.length(); i++) {
//            JSONObject recipe = recipeList.getJSONObject(i);
//
//            Iterator<String> keys = recipe.keys();
//            while(keys.hasNext()) {
//                String key = keys.next();
//                if (key.startsWith("MANUAL") && key.contains("IMG") && recipe.getString(key) != null) {
//
//                }
//            }
//        }
//    }
}
