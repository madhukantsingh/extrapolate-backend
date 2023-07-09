package com.anyaudit.service;


import com.anyaudit.models.Classifier;
import com.anyaudit.repository.ClassifiersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassifiersManager {

    @Autowired
    private ClassifiersRepository classifiersRepository;


    public List<Classifier> getAll() {
        List<com.anyaudit.models.Classifier> assignments = classifiersRepository.findAll();
        List<Classifier> result = new ArrayList<>();
        for (com.anyaudit.models.Classifier c : assignments) {
            Classifier assignment = new Classifier();
            assignment.setId(c.getId());
            assignment.setClassifierName(c.getClassifierName());
            assignment.setGroup(c.getGroup());
            assignment.setDiscription(c.getDiscription());
            assignment.setCreatedBy(c.getCreatedBy());
            assignment.setUpdatedBy(c.getUpdatedBy());
            assignment.setCreatedDate(c.getCreatedDate());
            assignment.setUpdatedDate(c.getUpdatedDate());

            result.add(assignment);
        }
        return result;
    }

}
