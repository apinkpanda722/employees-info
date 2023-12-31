package com.employees.info.spring.api.service.openApi;

import com.employees.info.spring.core.util.ApiCaller;
import com.employees.info.spring.api.controller.RequestBodyDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class OpenApiService {

    private final ApiCaller apiCaller;

    public JSONObject call(RequestBodyDto requestBodyDto) {
        return apiCaller.sendGetRequest(requestBodyDto.getUrl(),
                requestBodyDto.getServiceKey(), requestBodyDto.getParameters());
    }
}
