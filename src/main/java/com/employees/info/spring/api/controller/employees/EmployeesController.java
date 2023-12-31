package com.employees.info.spring.api.controller.employees;

import com.employees.info.spring.api.ApiResponse;
import com.employees.info.spring.api.service.employees.EmployeesService;
import com.employees.info.spring.api.service.employees.response.DepartmentsResponse;
import com.employees.info.spring.api.service.employees.response.EmployeesResponse;
import com.employees.info.spring.api.service.employees.response.JobHistoryResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Tag(name = "Employees(사원) 컨트롤러", description = "특정 사원의 정보 조회 및 수정, 부서 및 위치 정보 조회 API를 다룹니다.")
@RequiredArgsConstructor
@RestController
public class EmployeesController {

    private final EmployeesService employeesService;

    @Operation(summary = "특정 사원 현재 정보 조회", description = "특정 사원의 현재 정보를 조회합니다.")
    @GetMapping("/employees/{employee-id}")
    public ApiResponse<EmployeesResponse> getEmployeeInfo(
            @PathVariable("employee-id") Long employeeId) {
        return ApiResponse.ok(employeesService.getEmployeeById(employeeId));
    }

    @Operation(summary = "특정 사원 이력 정보 조회", description = "특정 사원의 이력 정보를 조회합니다.")
    @GetMapping("/employees/job-history/{employee-id}")
    public ApiResponse<List<JobHistoryResponse>> getEmployeeJobHistory(
            @PathVariable("employee-id") Long employeeId) {
        return ApiResponse.ok(employeesService.getJobHistoryById(employeeId));
    }

    @Operation(summary = "부서 및 위치 정보 조회", description = "부서 및 위치 정보를 조회합니다.")
    @GetMapping("/departments")
    public ApiResponse<List<DepartmentsResponse>> getDepartments() {
        return ApiResponse.ok(employeesService.getDepartments());
    }

    @Operation(summary = "특정 부서의 급여를 특정 비율로 인상", description = "특정 부서에 속한 사원들의 급여를 특정 비율로 인상합니다.")
    @PutMapping("/departments/pay-raise")
    public ApiResponse getARaise(
            @RequestParam(value = "departmentId", required = false) Long departmentId,
            @RequestParam(value = "salaryIncreasePercentage", required = false) BigDecimal salaryIncreasePercentage
    ) {
        return employeesService.getARaise(departmentId, salaryIncreasePercentage);
    }

    @Operation(summary = "특정 사원 정보 업데이트", description = "특정 사원의 정보를 업데이트합니다.")
    @PutMapping("/employees/{employee-id}")
    public void updateEmployeeByEmployeeId(
            @PathVariable("employee-id") Long employeeId,
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "phoneNumber", required = false) String phoneNumber,
            @RequestParam(value = "commissionPct", required = false) BigDecimal commissionPct,
            @RequestParam(value = "departmentId", required = false) Long departmentId
    ) {
        employeesService.updateEmployeeByEmployeeId(employeeId, email, phoneNumber, commissionPct, departmentId);
    }
}
