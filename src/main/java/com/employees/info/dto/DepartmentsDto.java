package com.employees.info.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class DepartmentsDto {

    private Long departmentId;

    private String departmentName;

    private String streetAddress;

    private String postalCode;

    private String city;

    private String stateProvince;

    private String countryName;

    private String regionName;
}
