package io.openAPI_test.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RecipeDTO {
    @JsonProperty("RCP_NM")
    private String menu;  // 메뉴명

    @JsonProperty("RCP_PARTS_DTLS")
    private String ingredient;  // 식재료

    @JsonProperty("RCP_WAY2")
    private String way;    // 조리 방법

    @JsonProperty("RCP_PAT2")
    private String category;    // 요리 종류

    @JsonProperty("MANUAL")
    private List<String> manual;    // 만드는 법

    @JsonProperty("MANUAL_IMG")
    private List<String> manualImg; // 만드는 법 이미지

    @JsonProperty("ATT_FILE_NO_MK")
    private String mainImage;   // 요리 대표 이미지

    @JsonProperty("INFO_CAR")
    private Integer carbohydrate; // 탄수화물

    @JsonProperty("INFO_PRO")
    private Integer protein; // 단백질

    @JsonProperty("INFO_FAT")
    private Integer fat; // 지방

    @JsonProperty("INFO_NA")
    private Integer natrium; // 나트륨

    @JsonProperty("INFO_ENG")
    private Integer calorie; // 열량
}
