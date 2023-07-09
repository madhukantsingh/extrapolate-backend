package com.anyaudit.controllers;

import com.anyaudit.models.Framework;
import com.anyaudit.models.Milestone;
import com.anyaudit.service.FrameworkManager;
import com.anyaudit.service.MilestoneManager;
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
@RequestMapping("/api/framework")
public class FrameworkController {

    @Autowired
    private FrameworkManager frameworkManager;

    @GetMapping("/list")
    public List<Framework> getAllFramework() {
        return frameworkManager.getAllFramework();
    }
}
