package io.openAPI_test.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.openAPI_test.domain.Manual;
import io.openAPI_test.domain.Recipe;
import io.openAPI_test.domain.RecipeApi;
import io.openAPI_test.repository.RecipeRepo;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class RecipeService {
    private final RecipeRepo recipeRepo;

    private List<Recipe> insertRecipe(List<Recipe> recipeList) {
         recipeRepo.saveAll(recipeList);

        return recipeList;
    }

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

    /*
        < Manual 저장 과정 정리 >
        1. List<Manual> allManualList, List<Manual> oneManualList 생성
        2. "MANUAL_IMG"로 시작하고, 내용이 null이 아닐 때
        3. recipeId = recipeId
        4. manualId = "MANUAL_IMG" 뒤의 숫자 2개
        5. manualImgUrl = value
        6. key = manualImgkey - "_IMG" / manual = value
        7. 3,4,6 필드로 Entity 생성 -> of() -> oneManualList에 추가
        8. oneManualList 정렬 (manualId 기반 compareTo())
        9. 정렬된 oneManualList를 allManualList에 추가
        10. recipeRepo.saveAll(allManualList);
    */
    public List<Manual> convertStringToManual(String recipeWithString) {
        List<Manual> allManualList = new ArrayList<>();

        JSONObject jsonObject = new JSONObject(recipeWithString);
        JSONObject recipeApiDetail = jsonObject.getJSONObject("COOKRCP01");
        JSONArray recipeList = recipeApiDetail.getJSONArray("row");

        for (Long recipeId = 1L; recipeId <= recipeList.length(); recipeId++) {
            List<Manual> oneManualList = new ArrayList<>();

            JSONObject recipe = recipeList.getJSONObject(recipeId.intValue() - 1);

            Iterator<String> keys = recipe.keys();
            while(keys.hasNext()) {
                Long manualId = 0L;

                String key = keys.next();
                if (key.startsWith("MANUAL_IMG") && recipe.getString(key) != "") {
                    manualId = Long.parseLong(key.replaceAll("MANUAL_IMG",""));

                    Manual manual = Manual.of(
                            recipeId,
                            manualId,
                            recipe.getString(key.replaceAll("_IMG", "")),
                            recipe.getString(key));

                    oneManualList.add(manual);
                }
            }
            sortManualList(oneManualList);
            allManualList.addAll(oneManualList);
        }

        return allManualList;
    }

    private List<Manual> sortManualList(List<Manual> manualList) {
        Collections.sort(manualList, new Comparator<Manual>() {
                    @Override
                    public int compare(Manual m1, Manual m2) {
                        if (m1.getManualId().getManualId() < m2.getManualId().getManualId()) {
                            return -1;
                        } else if (m1.getManualId().getManualId() > m2.getManualId().getManualId())
                        {
                            return 1;
                        } else {
                            return 0;
                        }
                    }
                }
        );

        return manualList;
    }
}
