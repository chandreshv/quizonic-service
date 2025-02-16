package com.chandresh.quizonic.exception;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser
class GlobalExceptionHandlerTest {

  @Autowired private MockMvc mockMvc;

  @Test
  void shouldReturnExpectedMessageWhenOauth2AuthenticationExceptionIsThrown() throws Exception {
    mockMvc
        .perform(MockMvcRequestBuilders.get("/dashboard"))
        .andExpect(status().isUnauthorized())
        .andExpect(jsonPath("$").value("Authentication Failed: The user is not authenticated"));
  }

  @Test
  void shouldReturnExpectedMessageWhenNoResourceFoundExceptionIsThrown() throws Exception {
    mockMvc
        .perform(MockMvcRequestBuilders.get("/non-existing-resource"))
        .andExpect(status().isNotFound())
        .andExpect(jsonPath("$").value("Resource not found: non-existing-resource"));
  }
}
