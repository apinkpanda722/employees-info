package com.employees.info.spring.api.controller.employees.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class JobHistoryDto {

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private String jobTitle;

    private String departmentName;
}
