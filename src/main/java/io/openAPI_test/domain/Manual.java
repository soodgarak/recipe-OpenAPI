package io.openAPI_test.domain;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Manual {
    @EmbeddedId
    private ManualId manualId;
    private String manual;    // 만드는 법
    private String manualImgUrl; // 만드는 법 이미지 URL

    private Manual (Recipe recipe, Long manualId, String manual, String manualImgUrl) {
        this.manualId = new ManualId(recipe.getId(), manualId);
        this.manual = manual;
        this.manualImgUrl = manualImgUrl;
    }

    public static Manual of(Recipe recipe, Long manualId, String manual, String manualImgUrl) {
        return new Manual(recipe, manualId, manual, manualImgUrl);
    }
}
