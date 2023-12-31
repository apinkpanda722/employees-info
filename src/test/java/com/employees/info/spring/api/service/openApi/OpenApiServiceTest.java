package com.employees.info.spring.api.service.openApi;

import com.employees.info.spring.api.controller.RequestBodyDto;
import com.employees.info.spring.core.util.ApiCaller;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class OpenApiServiceTest {

    @Mock
    private ApiCaller apiCaller;

    @InjectMocks
    private OpenApiService openApiService;

    @DisplayName("OpenApi 호출 테스트")
    @Test
    void test() {
        // given
        var data = new JSONObject();
        BDDMockito.given(apiCaller.sendGetRequest(anyString(), anyString(), any()))
                .willReturn(data);

        // when
        JSONObject result = openApiService.call(RequestBodyDto.builder()
                    .url("")
                    .serviceKey("")
                    .parameters(new HashMap<>())
                    .build());

        // then
        assertThat(result).isNull();
        verify(apiCaller, times(1)).sendGetRequest(anyString(), anyString(), any());
    }
}