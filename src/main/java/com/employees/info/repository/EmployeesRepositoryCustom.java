package com.employees.info.repository;

import com.employees.info.dto.EmployeesDto;

public interface EmployeesRepositoryCustom {

    public EmployeesDto getEmployeeById(
            Long employeeId
    );
}
