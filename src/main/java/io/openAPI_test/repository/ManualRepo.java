package io.openAPI_test.repository;

import io.openAPI_test.domain.Manual;
import io.openAPI_test.domain.ManualId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManualRepo extends JpaRepository<Manual, ManualId> {
}
