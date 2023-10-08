package com.employees.info.dto;

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

    public EmployeesDto(Long employeeId,
                        BigDecimal salary,
                        BigDecimal commissionPct
                        )
    {
        this.employeeId = employeeId;
        this.salary = salary;
        this.commissionPct = commissionPct;
    }

}
