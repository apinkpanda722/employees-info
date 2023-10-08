package com.employees.info.repository.querydsl;

import com.employees.info.entity.Employees;
import com.employees.info.repository.EmployeesRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesRepository extends
        JpaRepository<Employees, Long>,
        EmployeesRepositoryCustom {
}
