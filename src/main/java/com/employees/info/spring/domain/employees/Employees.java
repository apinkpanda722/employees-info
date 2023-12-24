package com.employees.info.spring.domain.employees;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "employees")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @Column(length = 20, name = "first_name")
    private String firstName;

    @Column(length = 25, nullable = false, name = "last_name")
    private String lastName;

    @Column(length = 25, nullable = false, name = "email")
    private String email;

    @Column(length = 20, name = "phone_number")
    private String phoneNumber;

    @Column(nullable = false, name = "hire_date")
    private LocalDateTime hireDate;

    @Column(length = 10, nullable = false, name = "job_id")
    private String jobId;

    @Column(precision = 8, scale = 2, nullable = false, name = "salary")
    private BigDecimal salary;

    @Column(precision = 2, scale = 2, name = "commission_pct")
    private BigDecimal commissionPct;

    @Column(length = 11, name = "manager_id")
    private Long managerId;

    @Column(length = 11, name = "department_id")
    private Long departmentId;

}
