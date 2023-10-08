package com.employees.info.service;

import com.employees.info.dto.EmployeesDto;
import com.employees.info.dto.JobHistoryDto;
import com.employees.info.repository.querydsl.EmployeesRepositoryCustomImpl;
import com.employees.info.repository.querydsl.JobHistoryRepositoryCustomImpl;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class EmployeesService {

    private final EmployeesRepositoryCustomImpl employeesRepositoryCustomImpl;

    private final JobHistoryRepositoryCustomImpl jobHistoryRepositoryCustomImpl;

    @Transactional
    public EmployeesDto getEmployeeById(Long employeeId) {
        return employeesRepositoryCustomImpl.getEmployeeById(employeeId);
    }

    @Transactional
    public List<JobHistoryDto> getJobHistoryById(Long employeeId) {
        return jobHistoryRepositoryCustomImpl.getJobHistoryById(employeeId);
    }
}
