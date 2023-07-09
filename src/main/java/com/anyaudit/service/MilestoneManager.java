package com.anyaudit.service;

import com.anyaudit.exception.ClientNotFoundException;
import com.anyaudit.exception.UserNotFoundException;
import com.anyaudit.models.Assignment;
import com.anyaudit.models.Milestone;
import com.anyaudit.repository.MilestoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MilestoneManager {
    @Autowired
    private MilestoneRepository milestoneRepository;



    public List<Milestone> getAllMilestone() {
        List<Milestone> milestones = milestoneRepository.findAll();
        return milestones;
    }

    public Milestone getMilestoneById(Long id) {
        Optional<Milestone> milestone = milestoneRepository.findById(id);
        if (milestone.isPresent()) {
            return milestone.get();
        } else {
            throw new ClientNotFoundException(id);
        }
    }

    public Milestone createMilestone(Milestone milestone) {
        return milestoneRepository.save(milestone);
    }

    public Milestone updateMilestone(Long id, Milestone milestoneDetails) {
        Milestone milestone = getMilestoneById(id);

        milestone.setMilestoneName(milestoneDetails.getMilestoneName());
        milestone.setCheckerUser(milestoneDetails.getCheckerUser());
        milestone.setTeam(milestoneDetails.getTeam());
        milestone.setStartDate(milestoneDetails.getStartDate());
        milestone.setEndDate(milestoneDetails.getEndDate());
        milestone.setClient(milestoneDetails.getClient());
        milestone.setAssignment(milestoneDetails.getAssignment());

        return milestoneRepository.save(milestone);
    }

    public void deleteMilestone(Long id) {
        Milestone milestone = getMilestoneById(id);
        milestoneRepository.delete(milestone);
    }

    public List<Object[]> findMilestoneById(Long clientId) {
        return milestoneRepository.findbyMilstoneId(clientId);
    }
}
