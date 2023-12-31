package com.employees.info.spring.api.controller.openApi;

import com.employees.info.ControllerTestSupport;
import com.employees.info.spring.api.controller.RequestBodyDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import java.util.HashMap;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class OpenApiControllerTest extends ControllerTestSupport {

    @DisplayName("Request Body로 받은 url, serviceKey, parameters를 사용해 임의의 공공데이터 API를 조회한다.")
    @Test
    void getOpenApiData() throws Exception {
        // given
        HashMap<String, String> parameters = new HashMap<>();
        parameters.put("numOfRows", "2");
        parameters.put("pageNo", "1");
        parameters.put("MobileOS", "IOS");
        parameters.put("MobileApp", "AppTest");

        RequestBodyDto request = RequestBodyDto.builder()
                .url("https://apis.data.go.kr/B551011/PhotoGalleryService1/galleryList1")
                .serviceKey("jEIrt7Smf5IMFrn65l99DegsRF5rusgCpOpV6yV8DIPezaaV6gblD4m2")
                .parameters(parameters)
                .build();

        // when // then
        mockMvc.perform(
                        post("/open-api")
                                .content(objectMapper.writeValueAsBytes(request))
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("200"))
                .andExpect(jsonPath("$.status").value("OK"))
                .andExpect(jsonPath("$.message").value("OK"))
                .andExpect(jsonPath("$.data").isEmpty())
        ;
    }

}