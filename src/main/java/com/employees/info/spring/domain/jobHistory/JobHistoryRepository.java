package com.employees.info.spring.domain.jobHistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobHistoryRepository extends
        JpaRepository<JobHistory, Long>,
        JobHistoryRepositoryCustom {
}
