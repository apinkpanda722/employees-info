package com.employees.info.spring.api.service.employees;

import com.employees.info.spring.api.controller.employees.dto.DepartmentsDto;
import com.employees.info.spring.api.controller.employees.dto.EmployeesDto;
import com.employees.info.spring.api.controller.employees.dto.JobHistoryDto;
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
        List<EmployeesDto> employeesByDepartment = employeesRepositoryCustomImpl.getEmployeesByDepartmentId(departmentId);

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
