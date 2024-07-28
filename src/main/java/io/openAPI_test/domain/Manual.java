package io.openAPI_test.domain;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Manual {
    @EmbeddedId
    private ManualId manualId;
    private String manual;    // 만드는 법

    private Manual (Recipe recipe, Long manualId, String manual) {
        this.manualId = new ManualId(recipe.getId(), manualId);
        this.manual = manual;
    }

    public static Manual of(Recipe recipe, Long manualId, String manual) {
        return new Manual(recipe, manualId, manual);
    }
}
