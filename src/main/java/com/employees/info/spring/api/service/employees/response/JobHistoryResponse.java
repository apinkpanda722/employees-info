package com.employees.info.spring.api.service.employees.response;

import com.employees.info.spring.api.controller.employees.dto.JobHistoryDto;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class JobHistoryResponse {

    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String jobTitle;
    private String departmentName;

    @Builder
    private JobHistoryResponse(LocalDateTime startDate, LocalDateTime endDate, String jobTitle, String departmentName) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.jobTitle = jobTitle;
        this.departmentName = departmentName;
    }

    public static JobHistoryResponse of(JobHistoryDto jobHistoryDto) {
        return JobHistoryResponse.builder()
                .startDate(jobHistoryDto.getStartDate())
                .endDate(jobHistoryDto.getEndDate())
                .jobTitle(jobHistoryDto.getJobTitle())
                .departmentName(jobHistoryDto.getDepartmentName())
                .build();
    }
}
