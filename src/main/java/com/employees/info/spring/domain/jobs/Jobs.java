package com.employees.info.spring.domain.jobs;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "jobs")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Jobs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String jobId;

    @Column(length = 35, nullable = false, name = "job_title")
    private String jobTitle;

    @Column(precision = 8, scale = 0, name = "min_salary")
    private BigDecimal minSalary;

    @Column(precision = 8, scale = 0, name = "max_salary")
    private BigDecimal maxSalary;
}
