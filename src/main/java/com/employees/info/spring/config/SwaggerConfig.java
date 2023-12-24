package com.employees.info.spring.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(title = "사원의 각종 Info 및 부서 및 위치 정보 조회 API 명세서",
                description = "공공 데이터 포털의 임의의 API 조회 가능한 커스터마이징 API 구현 추가")
)
@Configuration
public class SwaggerConfig {
}
