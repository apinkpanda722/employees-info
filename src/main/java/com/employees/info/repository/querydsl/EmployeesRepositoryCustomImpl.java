package com.employees.info.repository.querydsl;

import com.employees.info.dto.EmployeesDto;
import com.employees.info.entity.Employees;
import com.employees.info.entity.QDepartments;
import com.employees.info.entity.QEmployees;
import com.employees.info.entity.QJobs;
import com.employees.info.repository.EmployeesRepositoryCustom;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class EmployeesRepositoryCustomImpl extends QuerydslRepositorySupport
        implements EmployeesRepositoryCustom {

    public EmployeesRepositoryCustomImpl() {super(Employees.class);}

    QEmployees employees = QEmployees.employees;
    QJobs jobs = QJobs.jobs;
    QDepartments departments = QDepartments.departments;
    @Override
    public EmployeesDto getEmployeeById(
            Long employeeId
    ) {
        return from(employees)
                .select(Projections.constructor(
                        EmployeesDto.class,
                        employees.firstName,
                        employees.lastName,
                        employees.email,
                        employees.phoneNumber,
                        employees.hireDate,
                        jobs.jobTitle,
                        employees.salary,
                        employees.commissionPct,
                        departments.departmentName
                ))
                .join(jobs).on(employees.jobId.eq(jobs.jobId))
                .join(departments).on(employees.departmentId.eq(departments.departmentId))
                .where(
                        eqEmployeeId(employeeId)
                )
                .fetchOne();
    }

    private BooleanExpression eqEmployeeId(Long employeeId) {
        if (employeeId == null || employeeId == 0) {
            return null;
        }
        return employees.employeeId.eq(employeeId);
    }

}
