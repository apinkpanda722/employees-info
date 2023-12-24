package com.employees.info.spring.api.controller.employees.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeesDto {

    @JsonIgnore
    private Long employeeId;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private LocalDateTime hireDate;

    private String jobTitle;

    private BigDecimal salary;

    private BigDecimal commissionPct;

    private String departmentName;

    public EmployeesDto(String firstName,
                        String lastName,
                        String email,
                        String phoneNumber,
                        LocalDateTime hireDate,
                        String jobTitle,
                        BigDecimal salary,
                        BigDecimal commissionPct,
                        String departmentName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hireDate = hireDate;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.commissionPct = commissionPct;
        this.departmentName = departmentName;
    }

    public EmployeesDto(Long employeeId,
                        BigDecimal salary,
                        BigDecimal commissionPct)
    {
        this.employeeId = employeeId;
        this.salary = salary;
        this.commissionPct = commissionPct;
    }

}
