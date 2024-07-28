package io.openAPI_test.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String menu;  // 메뉴명

    @Column(nullable = false)
    private String ingredient;  // 식재료

    private String way;    // 조리 방법

    private String category;    // 요리 종류

    @Column(nullable = false)
    private List<String> manual;    // 만드는 법

    private List<String> manualImg; // 만드는 법 이미지

    private String mainImage;   // 요리 대표 이미지

    private Integer carbohydrate; // 탄수화물

    private Integer protein; // 단백질

    private Integer fat; // 지방

    private Integer natrium; // 나트륨

    private Integer calorie; // 열량
}
