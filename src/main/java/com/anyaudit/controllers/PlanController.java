package com.anyaudit.controllers;

import com.anyaudit.models.Milestone;
import com.anyaudit.models.Plan;
import com.anyaudit.service.MilestoneManager;
import com.anyaudit.service.PlanManager;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Getter
@Setter
@RequestMapping("/api/plan")
public class PlanController {
    @Autowired
    private PlanManager planManager;
    @GetMapping("/list")
    public ResponseEntity<List<Plan>> getAllPlans() {
        List<Plan> plans = planManager.getAllPlans();
        return ResponseEntity.ok(plans);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plan> getPlanById(@PathVariable("id") Long id) {
        Optional<Plan> plan = planManager.getPlanById(id);
        return plan.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/save")
    public ResponseEntity<Plan> createPlan(@RequestBody Plan plan) {
        Plan savedPlan = planManager.savePlan(plan);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPlan);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Plan> updatePlan(@PathVariable("id") Long id, @RequestBody Plan plan) {
        Optional<Plan> existingPlan = planManager.getPlanById(id);
        if (existingPlan.isPresent()) {
            Plan updatedPlan = existingPlan.get();
            updatedPlan.setClient(plan.getClient());
            updatedPlan.setAssignment(plan.getAssignment());
            updatedPlan.setMilestone(plan.getMilestone());
            updatedPlan.setDate(plan.getDate());
            updatedPlan.setUser(plan.getUser());
            updatedPlan.setPlanHour(plan.getPlanHour());
            updatedPlan.setPlanDesc(plan.getPlanDesc());
            planManager.savePlan(updatedPlan);
            return ResponseEntity.ok(updatedPlan);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlan(@PathVariable("id") Long id) {
        Optional<Plan> existingPlan = planManager.getPlanById(id);
        if (existingPlan.isPresent()) {
            planManager.deletePlanById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}



