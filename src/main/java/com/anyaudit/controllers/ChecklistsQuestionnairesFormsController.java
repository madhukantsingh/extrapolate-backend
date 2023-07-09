package com.anyaudit.controllers;


import com.anyaudit.models.ChecklistsQuestionnairesForms;
import com.anyaudit.models.Client;
import com.anyaudit.service.ChecklistsQuestionnairesFormsManager;
import com.anyaudit.service.ClientManager;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Getter
@Setter
@RequestMapping("/api/CLQF")
public class ChecklistsQuestionnairesFormsController {

    @Autowired
    private ChecklistsQuestionnairesFormsManager checklistsQuestionnairesFormsManager;

    @GetMapping("/list")
    public List<ChecklistsQuestionnairesForms> getAllCLQF() {
        return checklistsQuestionnairesFormsManager.getAllCLQF();
    }
}
