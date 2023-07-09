package com.anyaudit.controllers;


import com.anyaudit.dto.AssignmentNameIDDTO;
import com.anyaudit.exception.UserNotFoundException;
import com.anyaudit.models.Assignment;
import com.anyaudit.models.Milestone;
import com.anyaudit.repository.AssignmentRepository;
import com.anyaudit.service.AssignmentManager;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Getter
@Setter
@RequestMapping("/api/assignment")
public class AssignmentController {

    @Autowired
    private AssignmentManager assignmentManager;
    @Autowired
    private AssignmentRepository assignmentRepository;

    public AssignmentController(AssignmentManager assignmentService) {
        this.assignmentManager = assignmentService;
    }

    @GetMapping("/list")
    public List<Assignment> getAllAssignments() {
        return assignmentManager.getAllAssignments();
    }

    @GetMapping("/{id}")
    public Assignment getAssignmentById(@PathVariable Long id) {
        return assignmentManager.getAssignmentById(id);
    }


    @PostMapping("/save")
    public Assignment saveAssignment(@RequestBody Assignment assignment) {
        return assignmentManager.saveAssignment(assignment);
    }


    @PutMapping("/{id}")
    public Assignment updateAssignment(@PathVariable Long id, @RequestBody Assignment assignment) {
        Assignment existingAssignment = assignmentManager.getAssignmentById(id);

        if (existingAssignment != null) {
            existingAssignment.setAssignmentName(assignment.getAssignmentName());
            existingAssignment.setTypeofAssignment(assignment.getTypeofAssignment());
            existingAssignment.setYear(assignment.getYear());
            existingAssignment.setEngagementPartner(assignment.getEngagementPartner());
            existingAssignment.setReviewPartner(assignment.getReviewPartner());
            existingAssignment.setUsers(assignment.getUsers());
            existingAssignment.setValue(assignment.getValue());
            existingAssignment.setStartDate(assignment.getStartDate());
            existingAssignment.setEndDate(assignment.getEndDate());
            existingAssignment.setClient(assignment.getClient());

            return assignmentManager.saveAssignment(existingAssignment);
        }

        return null;
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAssignment(@PathVariable Long id) {
        Assignment existingAssignment = assignmentManager.getAssignmentById(id);

        if (existingAssignment != null) {
            assignmentManager.deleteAssignment(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.notFound().build();
    }


//    @GetMapping("/findByClientId/{id}")
//    public List<AssignmentNameIDDTO> getClientAssignmentNames(@PathVariable("id") Long id) {
//        List<Assignment> assignments = assignmentManager.findAssignmentsByClientId(id);
//        List<AssignmentNameIDDTO> resultList = new ArrayList<>();
//        for (Assignment assignment : assignments) {
//            resultList.add(new AssignmentNameIDDTO(assignment));
//        }
//        return resultList;
//    }
@GetMapping("/findByuserId/{id}")
public List<Map<String, Object>> getClientAssignment(@PathVariable("id") Long id) {
    List<Object[]> assignments = assignmentManager.findAssignmentsByClientId(id);
    List<Map<String, Object>> resultList = new ArrayList<>();
    for (Object[] assignment : assignments) {
        Map<String, Object> clientMap = new HashMap<>();
        clientMap.put("client_count", assignment[0]);
        clientMap.put("assignment_count", assignment[1]);
        resultList.add(clientMap);
    }
    return resultList;
}

    @GetMapping("/count/{userId}")
    public ResponseEntity<Map<String, Integer>> countDistinctAssignmentsByUser(@PathVariable int userId) {
        int count = assignmentRepository.countDistinctAssignmentsByUser(userId);
        Map<String, Integer> response = new HashMap<>();
        response.put("count", count);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/names")
    public List<Map<String, Object>> findNameAndId() {
        List<Object[]> clients = assignmentManager.findAssignmentNameAndId();
        List<Map<String, Object>> resultList = new ArrayList<>();
        for (Object[] client : clients) {
            Map<String, Object> clientMap = new HashMap<>();
            clientMap.put("assi_id", client[0]);
            clientMap.put("name", client[1]);
            resultList.add(clientMap);
        }
        return resultList;

    }

}

