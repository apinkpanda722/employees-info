package com.employees.info.repository;

import com.employees.info.dto.JobHistoryDto;

import java.util.List;

public interface JobHistoryRepositoryCustom {

    public List<JobHistoryDto> getJobHistoryById(
            Long employeeId
    );
}
