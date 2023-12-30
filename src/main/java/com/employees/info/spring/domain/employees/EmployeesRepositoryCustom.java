package com.employees.info.spring.domain.employees;

import com.employees.info.spring.api.controller.employees.dto.EmployeesDto;

import java.math.BigDecimal;
import java.util.List;

public interface EmployeesRepositoryCustom {

    public EmployeesDto getEmployeeById(
            Long employeeId
    );

    public List<EmployeesDto> getEmployeesByDepartmentId(
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
