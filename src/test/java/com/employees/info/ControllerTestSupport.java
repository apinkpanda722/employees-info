package com.employees.info;

import com.employees.info.spring.api.controller.openApi.OpenApiController;
import com.employees.info.spring.api.service.openApi.OpenApiService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = {
        OpenApiController.class
})
public abstract class ControllerTestSupport {

    @Autowired
    protected MockMvc mvc;

    @Autowired
    protected ObjectMapper objectMapper;

    @Autowired
    protected OpenApiService openApiService;
}
