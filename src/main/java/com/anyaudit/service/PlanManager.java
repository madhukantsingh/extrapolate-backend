package com.anyaudit.service;

import com.anyaudit.exception.ClientNotFoundException;
import com.anyaudit.exception.UserNotFoundException;
import com.anyaudit.models.*;
import com.anyaudit.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlanManager {
    private PlanRepository planRepository;

    @Autowired
    public PlanManager(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    public List<Plan> getAllPlans() {
        return planRepository.findAll();
    }

    public Optional<Plan> getPlanById(Long id) {
        return planRepository.findById(id);
    }

    public Plan savePlan(Plan plan) {
        return planRepository.save(plan);
    }

    public void deletePlanById(Long id) {
        planRepository.deleteById(id);
    }


}
