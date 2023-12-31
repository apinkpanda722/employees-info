package com.employees.info.spring.api.service.employees.response;

import com.employees.info.spring.api.controller.employees.dto.EmployeesDto;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class EmployeesResponse {

    private Long employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String hireDate;
    private String jobId;
    private String jobTitle;
    private BigDecimal salary;
    private BigDecimal commissionPct;
    private String departmentName;
    private Long managerId;
    private Long departmentId;

    @Builder
    private EmployeesResponse(Long employeeId,
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
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hireDate = hireDate;
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.commissionPct = commissionPct;
        this.departmentName = departmentName;
        this.managerId = managerId;
        this.departmentId = departmentId;
    }

    public static EmployeesResponse of(EmployeesDto employeesDto) {
        return EmployeesResponse.builder()
                .employeeId(employeesDto.getEmployeeId())
                .firstName(employeesDto.getFirstName())
                .lastName(employeesDto.getLastName())
                .email(employeesDto.getEmail())
                .phoneNumber(employeesDto.getPhoneNumber())
                .hireDate(employeesDto.getHireDate())
                .jobId(employeesDto.getJobId())
                .jobTitle(employeesDto.getJobTitle())
                .salary(employeesDto.getSalary())
                .commissionPct(employeesDto.getCommissionPct())
                .departmentName(employeesDto.getDepartmentName())
                .managerId(employeesDto.getManagerId())
                .departmentId(employeesDto.getDepartmentId())
                .build();
    }
}
