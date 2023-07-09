package com.anyaudit.service;

import com.anyaudit.models.Classifier;
import com.anyaudit.models.Conditions;
import com.anyaudit.repository.ConditionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConditionsManager {

    @Autowired
    private ConditionsRepository conditionsRepository;

    public List<Conditions> getAll() {
        List<com.anyaudit.models.Conditions> assignments = conditionsRepository.findAll();
        List<Conditions> result = new ArrayList<>();
        for (com.anyaudit.models.Conditions c : assignments) {
            Conditions assignment = new Conditions();
            assignment.setId(c.getId());
            assignment.setName(c.getName());
            assignment.setTypes(c.getTypes());
            assignment.setImapct(c.getImapct());
            assignment.setOperater(c.getOperater());
            assignment.setValue1(c.getValue1());
            assignment.setValue2(c.getValue2());
            assignment.setCreatedBy(c.getCreatedBy());
            assignment.setUpdatedBy(c.getUpdatedBy());
            assignment.setCreatedDate(c.getCreatedDate());
            assignment.setUpdatedDate(c.getUpdatedDate());

            result.add(assignment);
        }
        return result;
    }
}
