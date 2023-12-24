package com.employees.info.spring.domain.jobHistory;

import com.employees.info.spring.api.controller.employees.dto.JobHistoryDto;

import java.util.List;

public interface JobHistoryRepositoryCustom {

    public List<JobHistoryDto> getJobHistoryById(
            Long employeeId
    );
}
