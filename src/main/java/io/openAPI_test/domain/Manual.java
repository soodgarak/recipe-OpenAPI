package io.openAPI_test.domain;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Manual {
    @EmbeddedId
    private ManualId manualId;
    private String manual;    // 만드는 법
    private String manualImgUrl; // 만드는 법 이미지 URL

    private Manual (Long recipeId, Long manualId, String manual, String manualImgUrl) {
        this.manualId = new ManualId(recipeId, manualId);
        this.manual = manual;
        this.manualImgUrl = manualImgUrl;
    }

    public static Manual of(Long recipeId, Long manualId, String manual, String manualImgUrl) {
        return new Manual(recipeId, manualId, manual, manualImgUrl);
    }
}
