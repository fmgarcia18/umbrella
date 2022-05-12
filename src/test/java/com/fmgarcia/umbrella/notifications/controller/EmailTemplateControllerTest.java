package com.fmgarcia.umbrella.notifications.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fmgarcia.umbrella.notifications.dtos.EmailTemplateNewRequest;
import com.fmgarcia.umbrella.notifications.service.EmailService;
import com.fmgarcia.umbrella.notifications.service.EmailTemplateService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = EmailTemplateController.class)
public class EmailTemplateControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * We use @MockBean to mock away the business logic, since we don’t want to test integration between controller and business logic,
     * but between controller and the HTTP layer.
     * @MockBean automatically replaces the bean of the same type in the application context with a Mockito mock.
     */
    @MockBean
    private EmailTemplateService emailTemplateService;

    @Test
    void whenEmailTemplateRequestIsInvalid_thenReturnStatus400() throws Exception {
        EmailTemplateNewRequest emailTemplateNewRequest = new EmailTemplateNewRequest();

        String body = objectMapper.writeValueAsString(emailTemplateNewRequest);

        mvc.perform(post("/emails")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(body))
                .andExpect(status().isBadRequest());
    }
}
