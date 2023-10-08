package com.employees.info.repository.querydsl;

import com.employees.info.entity.JobHistory;
import com.employees.info.repository.JobHistoryRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobHistoryRepository extends
        JpaRepository<JobHistory, Long>,
        JobHistoryRepositoryCustom {
}
