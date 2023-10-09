package com.employees.info.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashMap;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class RequestBodyDto {

    private String url;

    private String serviceKey;

    private HashMap<String, String> parameters;
}
