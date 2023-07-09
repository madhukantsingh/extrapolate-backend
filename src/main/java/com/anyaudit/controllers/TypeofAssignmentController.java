package com.anyaudit.controllers;

import com.anyaudit.models.TypeofAssignment;
import com.anyaudit.models.Year;
import com.anyaudit.service.TypeofAssignmentManager;
import com.anyaudit.service.YearManager;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Getter
@Setter
@RequestMapping("/api/assignmentype")
public class TypeofAssignmentController {

    @Autowired
    private TypeofAssignmentManager typeofAssignmentManager;

    @GetMapping("/list")
    public List<TypeofAssignment> getAllTypeofAssignment() {
        return typeofAssignmentManager.getAllTypeofAssignment();

    }
}
