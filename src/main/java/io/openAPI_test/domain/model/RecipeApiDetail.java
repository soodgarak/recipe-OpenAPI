package io.openAPI_test.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RecipeApiDetail {
    @JsonProperty("total_count")
    private Integer totalCount;

    @JsonProperty("row")
    private List<RecipeVo> recipeVoList;
}
