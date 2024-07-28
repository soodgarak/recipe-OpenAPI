package io.openAPI_test.domain;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class ManualImage {
    @EmbeddedId
    private ManualImageId manualImageId;
    private String manualImgUrl; // 만드는 법 이미지 URL

    private ManualImage (Recipe recipe, Long manualImageId, String manualImgUrl) {
        this.manualImageId = new ManualImageId(recipe.getId(), manualImageId);
        this.manualImgUrl = manualImgUrl;
    }

    public static ManualImage of(Recipe recipe, Long manualImageId, String manualImgUrl) {
        return new ManualImage(recipe, manualImageId, manualImgUrl);
    }
}
