package io.openAPI_test.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RecipeApi {
    @JsonProperty("COOKRCP01")
    private RecipeApiDetail recipeApiDetail;
}
