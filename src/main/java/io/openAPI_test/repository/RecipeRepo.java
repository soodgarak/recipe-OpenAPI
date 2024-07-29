package io.openAPI_test.repository;

import io.openAPI_test.domain.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepo extends JpaRepository<Recipe, Long> {
    Recipe findBySerialNum(int serialNum);
}
