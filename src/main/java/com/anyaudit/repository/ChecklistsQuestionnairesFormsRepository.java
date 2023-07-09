package com.anyaudit.repository;
import com.anyaudit.models.ChecklistsQuestionnairesForms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository


public interface ChecklistsQuestionnairesFormsRepository extends JpaRepository<ChecklistsQuestionnairesForms, Long>{
}
