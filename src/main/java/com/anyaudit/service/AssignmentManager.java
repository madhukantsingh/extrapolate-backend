package com.anyaudit.service;

import com.anyaudit.exception.UserNotFoundException;
import com.anyaudit.models.Assignment;
import com.anyaudit.models.Milestone;
import com.anyaudit.repository.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssignmentManager {

    @Autowired
    private AssignmentRepository assignmentRepository;

    public AssignmentManager(AssignmentRepository assignmentRepository) {
        this.assignmentRepository = assignmentRepository;
    }

    public Assignment saveAssignment(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    public List<Assignment> getAllAssignments() {
        return assignmentRepository.findAll();
    }

    public Assignment getAssignmentById(Long id) {
        return assignmentRepository.findById(id).orElse(null);
    }

    public void deleteAssignment(Long id) {
        assignmentRepository.deleteById(id);
    }

    public List<Object[]> findAssignmentsByClientId(Long userId) {
        return assignmentRepository.findAssignmentsByClientId(userId);
    }

    public List<Object[]> findAssignmentNameAndId() {
        return assignmentRepository.findAssignmentNameAndId();
    }
}
