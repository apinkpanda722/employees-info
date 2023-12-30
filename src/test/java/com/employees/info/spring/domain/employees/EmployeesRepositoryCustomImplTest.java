package com.employees.info.spring.domain.employees;

import com.employees.info.IntegrationTestSupport;
import com.employees.info.spring.api.controller.employees.dto.EmployeesDto;
import com.employees.info.spring.domain.departments.Departments;
import com.employees.info.spring.domain.departments.DepartmentsRepository;
import com.employees.info.spring.domain.jobs.Jobs;
import com.employees.info.spring.domain.jobs.JobsRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

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
        Employees employee1 = createEmployees("Julia", "Nayer", "JNAYER", "650.124.1214", hireDate, "ST_CLERK", BigDecimal.valueOf(3200, 2), null, null, 1L);
        Departments departments = createDepartments("Shipping", null, null);
        Jobs jobs = createJobs("ST_CLERK", "Stock Clerk", BigDecimal.valueOf(2000), BigDecimal.valueOf(5000));

        departmentsRepository.save(departments);
        jobsRepository.save(jobs);
        employeesRepository.save(employee1);

        // when
        EmployeesDto employee = employeesRepositoryCustomImpl.getEmployeeById(1L);

        // then
        assertThat(employee)
                .extracting("firstName", "lastName", "email", "phoneNumber", "hireDate", "jobTitle", "salary", "commissionPct", "departmentName")
                .contains("Julia", "Nayer", "JNAYER", "650.124.1214", hireDate, "Stock Clerk", BigDecimal.valueOf(3200, 2), null, "Shipping");
    }

    @DisplayName("특정 부서에 속한 사원들을 조회합니다.")
    @Test
    void getEmployeesByDepartmentId() {
        // given
        String hireDate = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDateTime.now());
        Employees employee1 = createEmployees("Julia", "Nayer", "JNAYER", "650.124.1214", hireDate, "ST_CLERK", BigDecimal.valueOf(3200, 2), null, null, 1L);
        Employees employee2 = createEmployees("Irene", "Mikkilineni", "IMIKKILI", "650.124.1224", hireDate, "ST_CLERK", BigDecimal.valueOf(2700, 2), null, null, 1L);
        Departments departments = createDepartments("Shipping", null, null);

        departmentsRepository.save(departments);
        employeesRepository.saveAll(List.of(employee1, employee2));

        // when
        List<EmployeesDto> employees = employeesRepositoryCustomImpl.getEmployeesByDepartmentId(1L);

        // then
        assertThat(employees).hasSize(2)
                .extracting("employeeId", "salary", "commissionPct")
                .containsExactlyInAnyOrder(
                        tuple(1L, BigDecimal.valueOf(3200, 2), BigDecimal.valueOf(0, 0)),
                        tuple(2L, BigDecimal.valueOf(2700, 2), BigDecimal.valueOf(0, 0))
                );
    }

    @DisplayName("특정 사원의 연봉을 인상합니다.")
    @Test
    void updateSalary() {
        // given
        String hireDate = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDateTime.now());
        Employees employee = createEmployees("Julia", "Nayer", "JNAYER", "650.124.1214", hireDate, "ST_CLERK", BigDecimal.valueOf(3200, 2), null, null, 1L);
        Departments departments = createDepartments("Shipping", null, null);
        Jobs jobs = createJobs("ST_CLERK", "Stock Clerk", BigDecimal.valueOf(2000), BigDecimal.valueOf(5000));

        departmentsRepository.save(departments);
        jobsRepository.save(jobs);
        employeesRepository.save(employee);

        // when
        employeesRepositoryCustomImpl.updateSalary(1L, BigDecimal.valueOf(3800, 2));

        // then
        EmployeesDto salaryRaisedEmployee = employeesRepositoryCustomImpl.getEmployeeById(1L);
        assertThat(salaryRaisedEmployee)
                .extracting("employeeId", "salary")
                .contains(1L, BigDecimal.valueOf(3800, 2));
    }

    @DisplayName("특정 사원의 정보를 업데이트합니다.")
    @Test
    void updateEmployeeByEmployeeId() {
        // given
        String hireDate = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDateTime.now());
        Employees employee = createEmployees("Julia", "Nayer", "JNAYER", "650.124.1214", hireDate, "ST_CLERK", BigDecimal.valueOf(3200, 2), null, null, 1L);
        Departments department1 = createDepartments("Shipping", null, null);
        Departments department2 = createDepartments("Public Relations", null, null);
        Jobs jobs = createJobs("ST_CLERK", "Stock Clerk", BigDecimal.valueOf(2000), BigDecimal.valueOf(5000));

        departmentsRepository.save(department1);
        departmentsRepository.save(department2);
        jobsRepository.save(jobs);
        employeesRepository.save(employee);

        // when
        employeesRepositoryCustomImpl.updateEmployeeByEmployeeId(1L, "LBISSOT", "650.127.1934", null, 2L);

        // then
        EmployeesDto salaryRaisedEmployee = employeesRepositoryCustomImpl.getEmployeeById(1L);
        assertThat(salaryRaisedEmployee)
                .extracting("employeeId", "email", "phoneNumber", "departmentName")
                .contains(1L, "LBISSOT", "650.127.1934", "Public Relations");
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