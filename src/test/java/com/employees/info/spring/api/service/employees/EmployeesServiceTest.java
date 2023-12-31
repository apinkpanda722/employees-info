package com.employees.info.spring.api.service.employees;

import com.employees.info.IntegrationTestSupport;
import com.employees.info.spring.api.controller.employees.dto.EmployeesDto;
import com.employees.info.spring.domain.departments.Departments;
import com.employees.info.spring.domain.departments.DepartmentsRepository;
import com.employees.info.spring.domain.employees.Employees;
import com.employees.info.spring.domain.employees.EmployeesRepository;
import com.employees.info.spring.domain.employees.EmployeesRepositoryCustomImpl;
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
import static org.junit.jupiter.api.Assertions.*;

class EmployeesServiceTest extends IntegrationTestSupport {

    @Autowired
    private EmployeesService employeesService;

    @Autowired
    private EmployeesRepository employeesRepository;

    @Autowired
    private EmployeesRepositoryCustomImpl employeesRepositoryCustomImpl;

    @Autowired
    private DepartmentsRepository departmentsRepository;

    @AfterEach
    void tearDown() {employeesRepository.deleteAllInBatch();}

    @DisplayName("특정 부서에 속한 사원들의 급여를 특정 비율로 인사합니다.")
    @Test
    void getARaise() {
        // given
        String hireDate = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDateTime.now());
        Employees employee1 = createEmployees("Julia", "Nayer", "JNAYER", "650.124.1214", hireDate, "ST_CLERK", BigDecimal.valueOf(3200, 2), BigDecimal.valueOf(0.50), null, 1L);
        Employees employee2 = createEmployees("Irene", "Mikkilineni", "IMIKKILI", "650.124.1224", hireDate, "ST_CLERK", BigDecimal.valueOf(2700, 2), BigDecimal.valueOf(0.50), null, 1L);
        Departments departments = createDepartments("Shipping", null, null);

        departmentsRepository.save(departments);
        employeesRepository.saveAll(List.of(employee1, employee2));

        // when
        employeesService.getARaise(1L, BigDecimal.valueOf(0.50));

        // then
        List<EmployeesDto> employees = employeesRepositoryCustomImpl.getEmployeesByDepartmentId(1L);
        assertThat(employees).hasSize(2)
                .extracting("salary")
                .containsExactlyInAnyOrder(
                        BigDecimal.valueOf(6400, 2),
                        BigDecimal.valueOf(5400, 2)
                );
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

}