package com.employees.info.controller;

import com.employees.info.dto.EmployeesDto;
import com.employees.info.dto.JobHistoryDto;
import com.employees.info.service.EmployeesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class EmployeesController {

    private final EmployeesService employeeService;

    @GetMapping("/employees/{employee-id}")
    public ResponseEntity<EmployeesDto> getEmployeeInfo(
    @PathVariable("employee-id") Long employeeId) {
        return ResponseEntity.ok(employeeService.getEmployeeById(employeeId));
    }

    @GetMapping("/employees/job-history/{employee-id}")
    public ResponseEntity<List<JobHistoryDto>> getEmployeeJobHistory(
            @PathVariable("employee-id") Long employeeId) {
        return ResponseEntity.ok(employeeService.getJobHistoryById(employeeId));
    }
}
