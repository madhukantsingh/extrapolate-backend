package com.anyaudit.repository;


import com.anyaudit.models.TemplateforRisks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplateforRisksRepository extends JpaRepository<TemplateforRisks, Long> {
}
