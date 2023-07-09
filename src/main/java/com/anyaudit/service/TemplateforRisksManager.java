package com.anyaudit.service;

import com.anyaudit.models.ProcessAuditTools;
import com.anyaudit.models.TemplateforRisks;
import com.anyaudit.repository.TemplateforRisksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TemplateforRisksManager {
    @Autowired
    private TemplateforRisksRepository templateforRisksRepository;


    public List<TemplateforRisks> getAll() {
        List<TemplateforRisks> assignments = templateforRisksRepository.findAll();
        List<TemplateforRisks> result = new ArrayList<>();
        for (TemplateforRisks c : assignments) {
            TemplateforRisks assignment = new TemplateforRisks();
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
