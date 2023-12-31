package com.employees.info.spring.api.controller.employees;

import com.employees.info.ControllerTestSupport;
import com.employees.info.spring.api.service.employees.response.DepartmentsResponse;
import com.employees.info.spring.api.service.employees.response.EmployeesResponse;
import com.employees.info.spring.api.service.employees.response.JobHistoryResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class EmployeesControllerTest extends ControllerTestSupport {

    @DisplayName("특정 사원의 현재 정보를 조회합니다.")
    @Test
    void getEmployeeInfo() throws Exception {
        // given
        String hireDate = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDateTime.now());
        EmployeesResponse employeesResponse = createEmployeesResponse(1L,"Julia", "Nayer", "JNAYER", "650.124.1214", hireDate, "ST_CLERK", "Stock Clerk", BigDecimal.valueOf(3200, 2), BigDecimal.valueOf(0.50), "Shipping", null, 1L);

        when(employeesService.getEmployeeById(anyLong())).thenReturn(employeesResponse);

        // when // then
        mockMvc.perform(
                    get("/employees/1")
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("200"))
                .andExpect(jsonPath("$.status").value("OK"))
                .andExpect(jsonPath("$.message").value("OK"))
                .andExpect(jsonPath("$.data").exists())
        ;
    }

    @DisplayName("특정 사원의 이력 정보를 조회합니다.")
    @Test
    void getEmployeeJobHistory() throws Exception {
        // given
        LocalDateTime now = LocalDateTime.of(2022, 12, 25, 0, 0);
        JobHistoryResponse jobHistoryResponse1 = createJobHistoryResponse(now.minusYears(5), now.minusYears(4), "Stock Clerk", "Shipping");
        JobHistoryResponse jobHistoryResponse2 = createJobHistoryResponse(now.minusYears(3), now.minusYears(2), "Stock Manager", "Shipping");

        when(employeesService.getJobHistoryById(anyLong())).thenReturn(List.of(jobHistoryResponse1, jobHistoryResponse2));

        // when // then
        mockMvc.perform(
                    get("/employees/job-history/1")
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("200"))
                .andExpect(jsonPath("$.status").value("OK"))
                .andExpect(jsonPath("$.message").value("OK"))
                .andExpect(jsonPath("$.data").isArray())
        ;
    }

    @DisplayName("부서 및 위치 정보를 조회합니다.")
    @Test
    void getDepartments() throws Exception {
        // given
        DepartmentsResponse departmentsResponse1 = createDepartmentsResponse(1L, "Shipping", "1297 Via Cola di Rie", "00989", "Roma", null, "Italy", "Europe");
        DepartmentsResponse departmentsResponse2 = createDepartmentsResponse(2L, "IT Support", "93091 Calle della Testa", "10934", "Venice", null, "Italy", "Europe");

        when(employeesService.getDepartments()).thenReturn(List.of(departmentsResponse1, departmentsResponse2));

        // when // then
        mockMvc.perform(
                    get("/departments")
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("200"))
                .andExpect(jsonPath("$.status").value("OK"))
                .andExpect(jsonPath("$.message").value("OK"))
                .andExpect(jsonPath("$.data").isArray())
        ;
    }


    private EmployeesResponse createEmployeesResponse(Long employeeId,
                                                      String firstName,
                                                      String lastName,
                                                      String email,
                                                      String phoneNumber,
                                                      String hireDate,
                                                      String jobId,
                                                      String jobTitle,
                                                      BigDecimal salary,
                                                      BigDecimal commissionPct,
                                                      String departmentName,
                                                      Long managerId,
                                                      Long departmentId) {
        return EmployeesResponse.builder()
                .employeeId(employeeId)
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .phoneNumber(phoneNumber)
                .hireDate(hireDate)
                .jobId(jobId)
                .jobTitle(jobTitle)
                .salary(salary)
                .commissionPct(commissionPct)
                .departmentName(departmentName)
                .managerId(managerId)
                .departmentId(departmentId)
                .build();
    }

    private JobHistoryResponse createJobHistoryResponse(LocalDateTime startDate, LocalDateTime endDate, String jobTitle, String departmentName) {
        return JobHistoryResponse.builder()
                .startDate(startDate)
                .endDate(endDate)
                .jobTitle(jobTitle)
                .departmentName(departmentName)
                .build();
    }

    private DepartmentsResponse createDepartmentsResponse(Long departmentId,
                                                          String departmentName,
                                                          String streetAddress,
                                                          String postalCode,
                                                          String city,
                                                          String stateProvince,
                                                          String countryName,
                                                          String regionName) {
        return DepartmentsResponse.builder()
                .departmentId(departmentId)
                .departmentName(departmentName)
                .streetAddress(streetAddress)
                .postalCode(postalCode)
                .city(city)
                .stateProvince(stateProvince)
                .countryName(countryName)
                .regionName(regionName)
                .build();
    }

}