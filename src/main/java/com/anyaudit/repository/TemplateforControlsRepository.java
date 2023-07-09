package com.anyaudit.repository;

import com.anyaudit.models.TemplateforControls;
import com.anyaudit.models.TemplateforRisks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplateforControlsRepository extends JpaRepository<TemplateforControls, Long> {
}

