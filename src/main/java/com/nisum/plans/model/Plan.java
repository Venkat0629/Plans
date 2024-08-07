package com.nisum.plans.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "plans", schema = "nisum")
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long planId;
    private String code;
    private String planType;
    private Double price;
    private Integer duration;
    private Boolean discount;
}
