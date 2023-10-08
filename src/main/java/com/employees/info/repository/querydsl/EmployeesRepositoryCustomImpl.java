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

import java.math.BigDecimal;
import java.util.List;

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

    @Override
    public List<EmployeesDto> getEmployeesById(
            Long departmentId
    ) {
        return from(employees)
                .select(Projections.constructor(
                        EmployeesDto.class,
                        employees.employeeId,
                        employees.salary,
                        employees.commissionPct.coalesce(BigDecimal.ZERO).as("commissionPct")
                ))
                .join(departments).on(employees.departmentId.eq(departments.departmentId))
                .where(
                        eqDepartmentId(departmentId)
                )
                .fetch();
    }

    @Override
    public void updateSalary(
            Long employeeId,
            BigDecimal salaryIncreased
    ) {
        update(employees)
                .set(employees.salary, salaryIncreased)
                .where(employees.employeeId.eq(employeeId))
                .execute();
    }

    private BooleanExpression eqEmployeeId(Long employeeId) {
        if (employeeId == null || employeeId == 0) {
            return null;
        }
        return employees.employeeId.eq(employeeId);
    }

    private BooleanExpression eqDepartmentId(Long departmentId) {
        if (departmentId == null || departmentId == 0) {
            return null;
        }
        return departments.departmentId.eq(departmentId);
    }

}
