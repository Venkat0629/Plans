package com.nisum.plans.service;

import com.nisum.plans.dao.PlanRepository;
import com.nisum.plans.model.Plan;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PlanService {
    private PlanRepository planRepository;

    public PlanService(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    public List<Plan> getPlans() {
        return planRepository.findAll();
    }

    public Plan createPlan(Plan plan) {
        return planRepository.save(plan);
    }

    public Plan updatePlan(Long id, Plan plan) {
        Optional<Plan> fetchedPlan = planRepository.findById(id);
        if (fetchedPlan.isPresent()) {
            plan.setPlanId(id);
            return planRepository.save(plan);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Plan " + id + " not found");
        }
    }

    public Plan getPlanById(Long id) {
        Optional<Plan> plan = planRepository.findById(id);
        if (plan.isPresent()) {
            return plan.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Plan " + id + " not found");
        }
    }

    public void deletePlan(Long id) {
        Optional<Plan> plan = planRepository.findById(id);
        if (plan.isPresent()) {
            planRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Plan " + id + " not found");
        }
    }
}