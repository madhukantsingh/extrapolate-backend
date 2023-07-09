package com.anyaudit.service;

import com.anyaudit.models.TemplateforControls;
import com.anyaudit.models.TemplateforRisks;
import com.anyaudit.repository.TemplateforControlsRepository;
import com.anyaudit.repository.TemplateforRisksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TemplateforControlsManager {
    @Autowired
    private TemplateforControlsRepository templateforControlsRepository;

    public List<TemplateforControls> getAll() {
        List<TemplateforControls> assignments = templateforControlsRepository.findAll();
        List<TemplateforControls> result = new ArrayList<>();
        for (TemplateforControls c : assignments) {
            TemplateforControls assignment = new TemplateforControls();
            assignment.setId(c.getId());
            assignment.setAutomation(c.getAutomation());
            assignment.setFrequency(c.getFrequency());
            assignment.setShortAnswer(c.getShortAnswer());
            assignment.setCreatedBy(c.getCreatedBy());
            assignment.setUpdatedBy(c.getUpdatedBy());
            assignment.setCreatedDate(c.getCreatedDate());
            assignment.setUpdatedDate(c.getUpdatedDate());

            result.add(assignment);
        }
        return result;
    }

}
