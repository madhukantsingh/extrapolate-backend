package com.anyaudit.service;

import com.anyaudit.models.Framework;
import com.anyaudit.repository.FrameworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FrameworkManager {

    @Autowired
    private FrameworkRepository frameworkRepository;

    public List<Framework> getAllFramework() {
        return frameworkRepository.findAll();
    }
}
