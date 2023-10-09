package com.employees.info.service;

import com.employees.info.core.util.ApiCaller;
import com.employees.info.dto.RequestBodyDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class OpenApiService {
    public JSONObject call(RequestBodyDto requestBodyDto) {
        return ApiCaller.sendGetRequest(requestBodyDto.getUrl(),
                requestBodyDto.getServiceKey(), requestBodyDto.getParameters());
    }
}
