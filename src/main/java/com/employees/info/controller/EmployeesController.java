package com.employees.info.controller;

import com.employees.info.dto.DepartmentsDto;
import com.employees.info.dto.EmployeesDto;
import com.employees.info.dto.JobHistoryDto;
import com.employees.info.service.EmployeesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
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

    @GetMapping("/departments")
    public ResponseEntity<List<DepartmentsDto>> getDepartments() {
        return ResponseEntity.ok(employeeService.getDepartments());
    }

    @PutMapping("/departments/pay-raise")
    public void getARaise(
            @RequestParam(value = "departmentId", required = false) Long departmentId,
            @RequestParam(value = "salaryIncreasePercentage", required = false) BigDecimal salaryIncreasePercentage
    ) {
        employeeService.getARaise(departmentId, salaryIncreasePercentage);
    }

    @PutMapping("/employees/{employee-id}")
    public void updateEmployeeByEmployeeId(
            @PathVariable("employee-id") Long employeeId,
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "phoneNumber", required = false) String phoneNumber,
            @RequestParam(value = "commissionPct", required = false) BigDecimal commissionPct,
            @RequestParam(value = "departmentId", required = false) Long departmentId
    ) {
        employeeService.updateEmployeeByEmployeeId(employeeId, email, phoneNumber, commissionPct, departmentId);
    }
}
