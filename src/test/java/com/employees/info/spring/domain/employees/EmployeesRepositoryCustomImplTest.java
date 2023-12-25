package com.employees.info.spring.domain.employees;

import com.employees.info.IntegrationTestSupport;
import com.employees.info.spring.api.controller.employees.dto.EmployeesDto;
import com.employees.info.spring.domain.departments.Departments;
import com.employees.info.spring.domain.departments.DepartmentsRepository;
import com.employees.info.spring.domain.jobs.Jobs;
import com.employees.info.spring.domain.jobs.JobsRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
class EmployeesRepositoryCustomImplTest extends IntegrationTestSupport {

    @Autowired
    private EmployeesRepositoryCustomImpl employeesRepositoryCustomImpl;

    @Autowired
    private EmployeesRepository employeesRepository;

    @Autowired
    private DepartmentsRepository departmentsRepository;

    @Autowired
    private JobsRepository jobsRepository;

    @DisplayName("특정 사원의 현재 정보를 조회합니다.")
    @Test
    void getEmployeeById() {
        // given
        String hireDate = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDateTime.now());
        Employees employees = createEmployees("Julia", "Nayer", "JNAYER", "650.124.1214", hireDate, "ST_CLERK", BigDecimal.valueOf(3200, 2), null, null, 1L);
        Departments departments = createDepartments("Shipping", null, null);
        Jobs jobs = createJobs("ST_CLERK", "Stock Clerk", BigDecimal.valueOf(2000), BigDecimal.valueOf(5000));

        departmentsRepository.save(departments);
        jobsRepository.save(jobs);
        employeesRepository.save(employees);

        // when
        EmployeesDto employee = employeesRepositoryCustomImpl.getEmployeeById(1L);

        // then
        assertThat(employee)
                .extracting("firstName", "lastName", "email", "phoneNumber", "hireDate", "jobTitle", "salary", "commissionPct", "departmentName")
                .contains("Julia", "Nayer", "JNAYER", "650.124.1214", hireDate, "Stock Clerk", BigDecimal.valueOf(3200, 2), null, "Shipping");
    }

    private Employees createEmployees(String firstName,
                                      String lastName,
                                      String email,
                                      String phoneNumber,
                                      String hireDate,
                                      String jobId,
                                      BigDecimal salary,
                                      BigDecimal commissionPct,
                                      Long managerId,
                                      Long departmentId) {
        return Employees.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .phoneNumber(phoneNumber)
                .hireDate(hireDate)
                .jobId(jobId)
                .salary(salary)
                .commissionPct(commissionPct)
                .managerId(managerId)
                .departmentId(departmentId)
                .build();
    }

    private Departments createDepartments(String departmentName, Long managerId, Long locationId) {
        return Departments.builder()
                .departmentName(departmentName)
                .managerId(managerId)
                .locationId(locationId)
                .build();
    }

    private Jobs createJobs(String jobId, String jobTitle, BigDecimal minSalary, BigDecimal maxSalary) {
        return Jobs.builder()
                .jobId(jobId)
                .jobTitle(jobTitle)
                .minSalary(minSalary)
                .maxSalary(maxSalary)
                .build();
    }
}