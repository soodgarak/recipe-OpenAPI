package io.openAPI_test.domain;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String RCP_NM;  // 메뉴명
    @Column(nullable = false)
    private String RCP_PARTS_DTLS;  // 식재료

    private String RCP_WAY2;    // 조리 방법

    private String RCP_PAT2;    // 요리 종류
    private List<String> MANUAL;    // 만드는 법
    private List<String> MANUAL_IMG; // 만드는 법 이미지
    private String ATT_FILE_NO_MK;   // 요리 대표 이미지

    private Integer INFO_CAR; // 탄수화물
    private Integer INFO_PRO; // 단백질
    private Integer INFO_FAT; // 지방
    private Integer INFO_NA; // 나트륨
    private Integer INFO_ENG; // 열량
}
