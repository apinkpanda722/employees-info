package com.employees.info.repository;

import com.employees.info.dto.EmployeesDto;

import java.math.BigDecimal;
import java.util.List;

public interface EmployeesRepositoryCustom {

    public EmployeesDto getEmployeeById(
            Long employeeId
    );

    public List<EmployeesDto> getEmployeesById(
            Long departmentId
    );

    public void updateSalary(
            Long employeeId,
            BigDecimal salaryIncreased
    );

    public void updateEmployeeByEmployeeId(
            Long employeeId,
            String email,
            String phoneNumber,
            BigDecimal commissionPct,
            Long departmentId
    );
}
