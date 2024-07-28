package io.openAPI_test.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Manual {
    @Id
    private Long manualId;
    private String manual;    // 만드는 법
}
