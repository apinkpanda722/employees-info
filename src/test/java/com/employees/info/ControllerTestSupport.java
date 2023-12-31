package com.employees.info;

import com.employees.info.spring.api.controller.employees.EmployeesController;
import com.employees.info.spring.api.controller.openApi.OpenApiController;
import com.employees.info.spring.api.service.employees.EmployeesService;
import com.employees.info.spring.api.service.openApi.OpenApiService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = {
        EmployeesController.class,
        OpenApiController.class
})
public abstract class ControllerTestSupport {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    @MockBean
    protected EmployeesService employeesService;

    @MockBean
    protected OpenApiService openApiService;
}
