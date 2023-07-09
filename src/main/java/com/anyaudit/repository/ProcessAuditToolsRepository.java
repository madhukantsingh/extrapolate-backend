package com.anyaudit.repository;

import com.anyaudit.models.ChecklistsQuestionnairesForms;
import com.anyaudit.models.ProcessAuditTools;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessAuditToolsRepository extends JpaRepository<ProcessAuditTools, Long> {
}
