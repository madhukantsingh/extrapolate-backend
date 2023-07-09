package com.anyaudit.controllers;

import com.anyaudit.models.AuditVariables;
import com.anyaudit.models.Classifier;
import com.anyaudit.service.AuditVariablesManager;
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
@RequestMapping("/api/auditvariables")

public class AuditVariablesController {


    @Autowired
    private AuditVariablesManager auditVariablesManager;


    @GetMapping("/list")
    public List<AuditVariables> getAll() {
        return auditVariablesManager.getAll();
    }

}
