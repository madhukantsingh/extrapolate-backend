package com.anyaudit.controllers;

import com.anyaudit.models.TemplateforControls;
import com.anyaudit.models.TemplateforRisks;
import com.anyaudit.service.TemplateforControlsManager;
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
@RequestMapping("/api/Templateforcontrols")
public class TemplateforControlsController {

    @Autowired
    private TemplateforControlsManager templateforControlsManager;


    @GetMapping("/list")
    public List<TemplateforControls> getAll() {
        return templateforControlsManager.getAll();
    }
}
