package io.openAPI_test.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RecipeApi {
    @JsonProperty("COOKRCP01")
    private RecipeApiDetail recipeApiDetail;
}
