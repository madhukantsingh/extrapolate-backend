package com.anyaudit.repository;

import com.anyaudit.models.AuditVariables;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditVariablesRepository extends JpaRepository<AuditVariables, Long> {
}
