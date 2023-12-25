package com.employees.info.spring.domain.jobs;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JobsRepository extends
        JpaRepository<Jobs, String> {
}
