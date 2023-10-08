package com.employees.info.service;

import com.employees.info.dto.DepartmentsDto;
import com.employees.info.dto.EmployeesDto;
import com.employees.info.dto.JobHistoryDto;
import com.employees.info.entity.Employees;
import com.employees.info.repository.querydsl.DepartmentsRepositoryCustomImpl;
import com.employees.info.repository.querydsl.EmployeesRepository;
import com.employees.info.repository.querydsl.EmployeesRepositoryCustomImpl;
import com.employees.info.repository.querydsl.JobHistoryRepositoryCustomImpl;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class EmployeesService {

    private final EmployeesRepository employeesRepository;

    private final EmployeesRepositoryCustomImpl employeesRepositoryCustomImpl;

    private final JobHistoryRepositoryCustomImpl jobHistoryRepositoryCustomImpl;

    private final DepartmentsRepositoryCustomImpl departmentsRepositoryCustomImpl;

    @Transactional
    public EmployeesDto getEmployeeById(Long employeeId) {
        return employeesRepositoryCustomImpl.getEmployeeById(employeeId);
    }

    @Transactional
    public List<JobHistoryDto> getJobHistoryById(Long employeeId) {
        return jobHistoryRepositoryCustomImpl.getJobHistoryById(employeeId);
    }

    @Transactional
    public List<DepartmentsDto> getDepartments() {
        return departmentsRepositoryCustomImpl.getDepartments();
    }

    @Transactional
    public void getARaise(Long departmentId,
                          BigDecimal salaryIncreasePercentage) {
        List<EmployeesDto> employeesByDepartment = employeesRepositoryCustomImpl.getEmployeesById(departmentId);

        for (EmployeesDto employee : employeesByDepartment) {
            BigDecimal salary = employee.getSalary();
            BigDecimal salaryIncreasedByCommission = salary.multiply(employee.getCommissionPct());
            BigDecimal salaryIncreasedBySalaryIncreasePercentage = salary.multiply(salaryIncreasePercentage);
            BigDecimal salaryIncreased = salary.add(salaryIncreasedByCommission).add(salaryIncreasedBySalaryIncreasePercentage);

            employeesRepositoryCustomImpl.updateSalary(employee.getEmployeeId(), salaryIncreased);
        }
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
