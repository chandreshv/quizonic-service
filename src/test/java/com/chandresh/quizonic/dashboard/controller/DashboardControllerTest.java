package com.chandresh.quizonic.dashboard.controller;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.oauth2Login;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = DashboardController.class)
@AutoConfigureMockMvc
@WithMockUser
class DashboardControllerTest {

  @Autowired private MockMvc mockMvc;

  @Test
  void showDashboardToAnAuthenticatedUser() throws Exception {
    mockMvc
        .perform(
            get("/dashboard")
                .with(
                    oauth2Login()
                        .attributes(
                            attrs -> {
                              attrs.put("email", "test@example.com");
                            })))
        .andExpect(status().isOk());
  }
}
