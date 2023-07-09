package com.anyaudit.controllers;

import com.anyaudit.models.ChecklistsQuestionnairesForms;
import com.anyaudit.models.ProcessAuditTools;
import com.anyaudit.service.ProcessAuditToolsManager;
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
@RequestMapping("/api/processaudit")
public class ProcessAuditToolsController {

    @Autowired
    private ProcessAuditToolsManager processAuditToolsManager;

    @GetMapping("/list")
    public List<ProcessAuditTools> getAll() {
        return processAuditToolsManager.getAll();
    }
}
