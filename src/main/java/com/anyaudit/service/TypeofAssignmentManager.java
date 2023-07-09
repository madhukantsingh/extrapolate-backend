package com.anyaudit.service;

import com.anyaudit.models.TypeofAssignment;
import com.anyaudit.models.Year;
import com.anyaudit.repository.TypeofAssignmentRepository;
import com.anyaudit.repository.YearRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TypeofAssignmentManager {
    @Autowired
    private TypeofAssignmentRepository typeofAssignmentRepository;

    public List<TypeofAssignment> getAllTypeofAssignment() {
        return typeofAssignmentRepository.findAll();
    }
}
