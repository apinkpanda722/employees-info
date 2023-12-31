package com.employees.info.spring.api.service.employees;

import com.employees.info.spring.api.ApiResponse;
import com.employees.info.spring.api.controller.employees.dto.DepartmentsDto;
import com.employees.info.spring.api.controller.employees.dto.EmployeesDto;
import com.employees.info.spring.api.controller.employees.dto.JobHistoryDto;
import com.employees.info.spring.api.service.employees.response.DepartmentsResponse;
import com.employees.info.spring.api.service.employees.response.EmployeesResponse;
import com.employees.info.spring.api.service.employees.response.JobHistoryResponse;
import com.employees.info.spring.domain.departments.DepartmentsRepositoryCustomImpl;
import com.employees.info.spring.domain.employees.EmployeesRepository;
import com.employees.info.spring.domain.employees.EmployeesRepositoryCustomImpl;
import com.employees.info.spring.domain.jobHistory.JobHistoryRepositoryCustomImpl;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class EmployeesService {

    private final EmployeesRepository employeesRepository;

    private final EmployeesRepositoryCustomImpl employeesRepositoryCustomImpl;

    private final JobHistoryRepositoryCustomImpl jobHistoryRepositoryCustomImpl;

    private final DepartmentsRepositoryCustomImpl departmentsRepositoryCustomImpl;

    @Transactional
    public EmployeesResponse getEmployeeById(Long employeeId) {
        EmployeesDto employee = employeesRepositoryCustomImpl.getEmployeeById(employeeId);
        return EmployeesResponse.of(employee);
    }

    @Transactional
    public List<JobHistoryResponse> getJobHistoryById(Long employeeId) {
        List<JobHistoryDto> jobHistory = jobHistoryRepositoryCustomImpl.getJobHistoryById(employeeId);
        return jobHistory.stream()
                .map(JobHistoryResponse::of)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<DepartmentsResponse> getDepartments() {
        List<DepartmentsDto> departments = departmentsRepositoryCustomImpl.getDepartments();
        return departments.stream()
                .map(DepartmentsResponse::of)
                .collect(Collectors.toList());
    }

    @Transactional
    public ApiResponse getARaise(Long departmentId,
                          BigDecimal salaryIncreasePercentage) {
        List<EmployeesDto> employeesByDepartment = employeesRepositoryCustomImpl.getEmployeesByDepartmentId(departmentId);
        if (employeesByDepartment.size() == 0) {
            return ApiResponse.fail();
        }

        for (EmployeesDto employee : employeesByDepartment) {
            BigDecimal salary = employee.getSalary();
            BigDecimal salaryIncreasedByCommission = salary.multiply(employee.getCommissionPct());
            BigDecimal salaryIncreasedBySalaryIncreasePercentage = salary.multiply(salaryIncreasePercentage);
            BigDecimal salaryIncreased = salary.add(salaryIncreasedByCommission).add(salaryIncreasedBySalaryIncreasePercentage);

            employeesRepositoryCustomImpl.updateSalary(employee.getEmployeeId(), salaryIncreased);
        }

        List<EmployeesDto> modifiedEmployeesByDepartment = employeesRepositoryCustomImpl.getEmployeesByDepartmentId(departmentId);
        List<EmployeesDto> notRaisedSalaryEmployees = employeesByDepartment.stream()
                .filter(x -> modifiedEmployeesByDepartment.stream()
                        .anyMatch(Predicate.isEqual(x)))
                        .collect(Collectors.toList());

        if (notRaisedSalaryEmployees.size() == 0) {
            return ApiResponse.ok(null);
        }
        return ApiResponse.fail();
    }

    @Transactional
    public void updateEmployeeByEmployeeId(Long employeeId,
                                           String email,
                                           String phoneNumber,
                                           BigDecimal commissionPct,
                                           Long departmentId) {
        employeesRepositoryCustomImpl.updateEmployeeByEmployeeId(employeeId, email, phoneNumber, commissionPct, departmentId);
    }
}
