package com.employees.info.spring.domain.departments;

import com.employees.info.spring.api.controller.employees.dto.DepartmentsDto;
import com.employees.info.entity.*;
import com.querydsl.core.types.Projections;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class DepartmentsRepositoryCustomImpl extends QuerydslRepositorySupport
        implements DepartmentsRepositoryCustom {

    public DepartmentsRepositoryCustomImpl() {super(Departments.class);}

    QDepartments departments = QDepartments.departments;
    QLocations locations = QLocations.locations;
    QCountries countries = QCountries.countries;
    QRegions regions = QRegions.regions;
    @Override
    public List<DepartmentsDto> getDepartments(
    ) {
        return from(departments)
                .select(Projections.constructor(
                        DepartmentsDto.class,
                        departments.departmentId,
                        departments.departmentName,
                        locations.streetAddress,
                        locations.postalCode,
                        locations.city,
                        locations.stateProvince,
                        countries.countryName,
                        regions.regionName
                ))
                .join(locations).on(departments.locationId.eq(locations.locationId))
                .join(countries).on(locations.countryId.eq(countries.countryId))
                .join(regions).on(countries.regionId.eq(regions.regionId))
                .fetch();
    }
}
