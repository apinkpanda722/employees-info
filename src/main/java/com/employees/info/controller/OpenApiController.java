package com.employees.info.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "공공 데이터 API 조회 컨트롤러",
        description = "공공 데이터 포털(www.data.go.kr)에서 임의의 API 선택 후 조회 가능한 커스터마이징된 API를 다룹니다.")
@RequiredArgsConstructor
@RestController
public class OpenApiController {
}
