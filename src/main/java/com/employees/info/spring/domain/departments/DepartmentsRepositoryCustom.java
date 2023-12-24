package com.employees.info.spring.domain.departments;

import com.employees.info.spring.api.controller.employees.dto.DepartmentsDto;

import java.util.List;

public interface DepartmentsRepositoryCustom {

    public List<DepartmentsDto> getDepartments(
    );
}
