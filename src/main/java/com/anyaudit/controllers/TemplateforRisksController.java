package com.anyaudit.controllers;

import com.anyaudit.models.ProcessAuditTools;
import com.anyaudit.models.TemplateforRisks;
import com.anyaudit.service.TemplateforRisksManager;
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
@RequestMapping("/api/templateforrisks")
public class TemplateforRisksController {

    @Autowired
    private TemplateforRisksManager templateforRisksManager;

    @GetMapping("/list")
    public List<TemplateforRisks> getAll() {
        return templateforRisksManager.getAll();
    }
}
