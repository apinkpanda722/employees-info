package com.employees.info.spring.api.controller.openApi;

import com.employees.info.spring.api.ApiResponse;
import com.employees.info.spring.api.controller.RequestBodyDto;
import com.employees.info.spring.api.service.openApi.OpenApiService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "공공 데이터 API 조회 컨트롤러",
        description = "공공 데이터 포털(www.data.go.kr)에서 임의의 API 선택 후 조회 가능한 커스터마이징된 API를 다룹니다.")
@RequiredArgsConstructor
@RestController
public class OpenApiController {

    private final OpenApiService openApiService;

    @Operation(summary = "공공 데이터 API 조회",
            description = "Request Body로 받은 url, serviceKey, parameters를 사용해 임의의 공공데이터 API를 조회한다.")
    @PostMapping("/open-api")
    public ApiResponse<JSONObject> getARaise(
            @RequestBody @Valid RequestBodyDto requestBodyDto
    ) {
        return ApiResponse.ok(openApiService.call(requestBodyDto));
    }
}
