package com.anyaudit.service;

import com.anyaudit.models.ChecklistsQuestionnairesForms;
import com.anyaudit.models.Client;
import com.anyaudit.repository.ChecklistsQuestionnairesFormsRepository;
import com.anyaudit.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class ChecklistsQuestionnairesFormsManager {

    @Autowired
    private ChecklistsQuestionnairesFormsRepository checklistsQuestionnairesFormsRepository;



    public List<ChecklistsQuestionnairesForms> getAllCLQF() {
        List<com.anyaudit.models.ChecklistsQuestionnairesForms> assignments = checklistsQuestionnairesFormsRepository.findAll();
        List<ChecklistsQuestionnairesForms> result = new ArrayList<>();
        for (com.anyaudit.models.ChecklistsQuestionnairesForms c : assignments) {
            ChecklistsQuestionnairesForms assignment = new ChecklistsQuestionnairesForms();
            assignment.setId(c.getId());
            assignment.setName(c.getName());
            assignment.setChapter(c.getChapter());
            assignment.setScope(c.getScope());
            assignment.setType(c.getType());
            assignment.setCreatedBy(c.getCreatedBy());
            assignment.setUpdatedBy(c.getUpdatedBy());
            assignment.setCreatedDate(c.getCreatedDate());
            assignment.setUpdatedDate(c.getUpdatedDate());

            result.add(assignment);
        }
        return result;
    }

}
