package com.employees.info.spring.domain.jobHistory;

import com.employees.info.IntegrationTestSupport;
import com.employees.info.spring.api.controller.employees.dto.EmployeesDto;
import com.employees.info.spring.api.controller.employees.dto.JobHistoryDto;
import com.employees.info.spring.domain.departments.Departments;
import com.employees.info.spring.domain.departments.DepartmentsRepository;
import com.employees.info.spring.domain.employees.Employees;
import com.employees.info.spring.domain.employees.EmployeesRepository;
import com.employees.info.spring.domain.jobs.Jobs;
import com.employees.info.spring.domain.jobs.JobsRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

class JobHistoryRepositoryCustomImplTest extends IntegrationTestSupport {

    @Autowired
    private EmployeesRepository employeesRepository;

    @Autowired
    private DepartmentsRepository departmentsRepository;

    @Autowired
    private JobsRepository jobsRepository;

    @Autowired
    private JobHistoryRepository jobHistoryRepository;

    @Autowired
    private JobHistoryRepositoryCustomImpl jobHistoryRepositoryCustomImpl;

    @DisplayName("특정 사원의 이력 정보를 조회합니다.")
    @Test
    void getJobHistoryById() {
        // given
        String hireDate = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDateTime.now());
        LocalDateTime now = LocalDateTime.of(2022, 12, 25, 0, 0);
        Employees employee1 = createEmployees("Julia", "Nayer", "JNAYER", "650.124.1214", hireDate, "AD_VP", BigDecimal.valueOf(3200, 2), null, null, 1L);
        Departments departments = createDepartments("Shipping", null, null);
        Jobs jobs1 = createJobs("ST_CLERK", "Stock Clerk", BigDecimal.valueOf(2000), BigDecimal.valueOf(5000));
        Jobs jobs2 = createJobs("ST_MAN", "Stock Manager", BigDecimal.valueOf(5500), BigDecimal.valueOf(8500));
        Jobs jobs3 = createJobs("AD_VP", "Administration Vice President", BigDecimal.valueOf(15000), BigDecimal.valueOf(30000));
        JobHistory jobHistory1 = createJobsHistory(1L, now.minusYears(5), now.minusYears(4), "ST_CLERK", 1L);
        JobHistory jobHistory2 = createJobsHistory(1L, now.minusYears(3), now.minusYears(1), "ST_MAN", 1L);

        Departments save = departmentsRepository.save(departments);
        List<Jobs> jobs = jobsRepository.saveAll(List.of(jobs1, jobs2, jobs3));
        Employees save1 = employeesRepository.save(employee1);
        List<JobHistory> jobHistories = jobHistoryRepository.saveAll(List.of(jobHistory1, jobHistory2));

        // when
        List<JobHistoryDto> jobHistory = jobHistoryRepositoryCustomImpl.getJobHistoryById(1L);

        // then
        assertThat(jobHistory).hasSize(2)
                .extracting("startDate", "endDate", "jobTitle", "departmentName")
                .containsExactlyInAnyOrder(
                        tuple(now.minusYears(5), now.minusYears(4), "Stock Clerk", "Shipping"),
                        tuple(now.minusYears(3), now.minusYears(1), "Stock Manager", "Shipping")
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

    private Jobs createJobs(String jobId, String jobTitle, BigDecimal minSalary, BigDecimal maxSalary) {
        return Jobs.builder()
                .jobId(jobId)
                .jobTitle(jobTitle)
                .minSalary(minSalary)
                .maxSalary(maxSalary)
                .build();
    }

    private JobHistory createJobsHistory(Long employeeId,
                                         LocalDateTime startDate,
                                         LocalDateTime endDate,
                                         String jobId,
                                         Long departmentId) {
        return JobHistory.builder()
                .employeeId(employeeId)
                .startDate(startDate)
                .endDate(endDate)
                .jobId(jobId)
                .departmentId(departmentId)
                .build();
    }
}