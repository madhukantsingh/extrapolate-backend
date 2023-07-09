package com.anyaudit.controllers;

import com.anyaudit.models.Classifier;
import com.anyaudit.models.Conditions;
import com.anyaudit.service.ConditionsManager;
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
    @RequestMapping("/api/conditions")

public class ConditionsController {

    @Autowired
    private ConditionsManager conditionsManager;

    @GetMapping("/list")
    public List<Conditions> getAll() {
        return conditionsManager.getAll();
    }
}
