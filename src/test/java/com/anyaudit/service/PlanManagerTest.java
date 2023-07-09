package com.anyaudit.service;

import com.anyaudit.CoreAppConfig;
import com.anyaudit.models.*;
import com.anyaudit.repository.PlanRepository;
import com.anyaudit.util.CreateTestData;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;


@ActiveProfiles("test")
@ContextConfiguration(classes = { CoreAppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class PlanManagerTest {


    @Autowired
    private PlanManager planManager;


    @Autowired
    private PlanRepository planRepository;


    @Autowired
    private CreateTestData createTestData;

    @Before
    @After
    public void setup() {

    }
    @Test
    void savePlan() {
        Milestone m = createTestData.createMilestone();
        User u = createTestData.CreateUser();
        Plan plan = new Plan();
        plan.setDate(new Date());
        plan.setPlanHour(8);
        plan.setPlanDesc("Team");
        plan.setMilestone(m);
        plan.setUser(u);
        plan.setClient(m.getClient());
        plan.setAssignment(m.getAssignment());

        Plan p = planManager.savePlan(plan);
        assertNotNull(p);
    }


    @Test
    void getAllPlan() {
        Plan m1 = createTestData.createPlan();

        planRepository.saveAll(Arrays.asList(m1));
        System.out.println("Milestones saved to repository: " + Arrays.asList(m1));


        List<Plan> plan = planManager.getAllPlan();
        System.out.println("Milestones returned by getAllMilestone(): " + plan);

        assertEquals(1, plan.size());
    }


    @Test
    void getPlanById() {

        // Create a sample milestone
        Plan m1 = createTestData.createPlan();

        // Save it to the repository
        Plan savedPlan = planRepository.save(m1);

        // Call the getMilestoneById method
        Optional<Plan> optionalPlan = planManager.getPlanById(savedPlan.getId());

        // Check that the milestone was found
        assertTrue(optionalPlan.isPresent());

        // Get the milestone from the Optional
        Plan retrievedPlan = optionalPlan.get();

        // Check that the retrieved milestone has the same ID as the saved one
        assertEquals(savedPlan.getId(), retrievedPlan.getId());

    }


    @Test
    void updatePlan() {
        // Create a sample milestone
        Plan p1 = createTestData.createPlan();

        // Save it to the repository
        Plan savedPlan = planRepository.save(p1);

        // Update the milestone's name and team
        savedPlan.setPlanDesc("Updated name");
        savedPlan.setPlanHour(8);

        // Call the updateMilestone method with the ID and updated milestone
        Plan updatedPlan = planManager.updatePlan(savedPlan.getId(), savedPlan);

        // Check that the updated milestone has the correct values
        assertEquals("Updated name", updatedPlan.getPlanDesc());
        assertEquals("8", updatedPlan.getPlanHour().toString());
    }

}