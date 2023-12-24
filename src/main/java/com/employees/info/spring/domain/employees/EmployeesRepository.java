package com.employees.info.spring.domain.employees;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesRepository extends
        JpaRepository<Employees, Long>,
        EmployeesRepositoryCustom {
}
