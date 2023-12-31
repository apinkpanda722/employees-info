package com.employees.info.spring.api.service.employees.response;

import com.employees.info.spring.api.controller.employees.dto.DepartmentsDto;
import lombok.Builder;
import lombok.Getter;

@Getter
public class DepartmentsResponse {

    private Long departmentId;
    private String departmentName;
    private String streetAddress;
    private String postalCode;
    private String city;
    private String stateProvince;
    private String countryName;
    private String regionName;

    @Builder
    private DepartmentsResponse(Long departmentId,
                                String departmentName,
                                String streetAddress,
                                String postalCode,
                                String city,
                                String stateProvince,
                                String countryName,
                                String regionName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.streetAddress = streetAddress;
        this.postalCode = postalCode;
        this.city = city;
        this.stateProvince = stateProvince;
        this.countryName = countryName;
        this.regionName = regionName;
    }

    public static DepartmentsResponse of(DepartmentsDto departmentsDto) {
        return DepartmentsResponse.builder()
                .departmentId(departmentsDto.getDepartmentId())
                .departmentName(departmentsDto.getDepartmentName())
                .streetAddress(departmentsDto.getStreetAddress())
                .postalCode(departmentsDto.getPostalCode())
                .city(departmentsDto.getCity())
                .stateProvince(departmentsDto.getStateProvince())
                .countryName(departmentsDto.getCountryName())
                .regionName(departmentsDto.getRegionName())
                .build();
    }
}
