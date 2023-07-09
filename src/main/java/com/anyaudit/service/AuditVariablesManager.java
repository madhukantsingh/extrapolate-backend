package com.anyaudit.service;

import com.anyaudit.models.AuditVariables;
import com.anyaudit.models.Classifier;
import com.anyaudit.repository.AuditVariablesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuditVariablesManager {
    @Autowired
    private AuditVariablesRepository auditVariablesRepository;


    public List<AuditVariables> getAll() {
        List<com.anyaudit.models.AuditVariables> assignments = auditVariablesRepository.findAll();
        List<AuditVariables> result = new ArrayList<>();
        for (com.anyaudit.models.AuditVariables c : assignments) {
            AuditVariables assignment = new AuditVariables();
            assignment.setId(c.getId());
            assignment.setName(c.getName());
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
