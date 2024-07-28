package io.openAPI_test.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class CookRcp01 {
    @JsonProperty("total_count")
    private Integer totalCount;

    @JsonProperty("row")
    private List<RecipeDTO> recipeDTOList;
}
