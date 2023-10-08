package com.employees.info.repository;

import com.employees.info.dto.DepartmentsDto;
import com.employees.info.dto.JobHistoryDto;

import java.util.List;

public interface DepartmentsRepositoryCustom {

    public List<DepartmentsDto> getDepartments(
    );
}
