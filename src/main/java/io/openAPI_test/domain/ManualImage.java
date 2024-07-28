package io.openAPI_test.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ManualImage {
    @Id
    private Long manualImageId;

    private String manualImg; // 만드는 법 이미지 URL
}
