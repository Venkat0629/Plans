package com.nisum.plans.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long planId;
    private String code;
    private String caption;
    private String planPrice;
    private String monthlyCost;
    private Integer trialDuration;
    private Boolean isDiscountedPrice;
}
