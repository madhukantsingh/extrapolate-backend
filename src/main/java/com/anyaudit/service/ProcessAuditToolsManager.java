package com.anyaudit.service;

import com.anyaudit.models.ChecklistsQuestionnairesForms;
import com.anyaudit.models.ProcessAuditTools;
import com.anyaudit.repository.ProcessAuditToolsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProcessAuditToolsManager {

    @Autowired
    private ProcessAuditToolsRepository processAuditToolsRepository;

    public List<ProcessAuditTools> getAll() {
        List<com.anyaudit.models.ProcessAuditTools> assignments = processAuditToolsRepository.findAll();
        List<ProcessAuditTools> result = new ArrayList<>();
        for (com.anyaudit.models.ProcessAuditTools c : assignments) {
            ProcessAuditTools assignment = new ProcessAuditTools();
            assignment.setId(c.getId());
            assignment.setName(c.getName());
            assignment.setDiscription(c.getDiscription());
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
