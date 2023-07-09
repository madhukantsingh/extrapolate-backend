package com.anyaudit.controllers;

import com.anyaudit.models.Conditions;
import com.anyaudit.models.Decisions;
import com.anyaudit.service.DecisionsManager;
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
@RequestMapping("/api/decision")
public class DecisionsController {
    @Autowired
    private DecisionsManager decisionsManager;


    @GetMapping("/list")
    public List<Decisions> getAll() {
        return decisionsManager.getAll();
    }
}
