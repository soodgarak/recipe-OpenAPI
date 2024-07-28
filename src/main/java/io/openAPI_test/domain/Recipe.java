package io.openAPI_test.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("RCP_NM")
    private String menu;  // 메뉴명

    @JsonProperty("RCP_PARTS_DTLS")
    private String ingredient;  // 식재료

    @JsonProperty("RCP_WAY2")
    private String way;    // 조리 방법

    @JsonProperty("RCP_PAT2")
    private String category;    // 요리 종류

    @JsonProperty("ATT_FILE_NO_MK")
    private String mainImage;   // 요리 대표 이미지

    @JsonProperty("INFO_CAR")
    private Double carbohydrate; // 탄수화물

    @JsonProperty("INFO_PRO")
    private Double protein; // 단백질

    @JsonProperty("INFO_FAT")
    private Double fat; // 지방

    @JsonProperty("INFO_NA")
    private Double natrium; // 나트륨

    @JsonProperty("INFO_ENG")
    private Double calorie; // 열량

    @JsonProperty("RCP_NA_TIP")
    private String tip; // 저감 조리법 TIP
}
