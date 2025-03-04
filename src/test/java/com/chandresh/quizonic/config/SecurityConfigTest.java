package com.chandresh.quizonic.config;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
@Import(SecurityConfig.class)
@AutoConfigureMockMvc
class SecurityConfigTest {

  @Autowired private MockMvc mockMvc;

  @Test
  @DisplayName("Should allow public access to login")
  void shouldAllowPublicAccessToHomeAndLogin() throws Exception {
    mockMvc.perform(get("/")).andExpect(status().isOk());
    mockMvc.perform(get("/login")).andExpect(status().isOk());
  }

  @Test
  @WithAnonymousUser
  @DisplayName("Should secure all other endpoints")
  void shouldSecureAllOtherEndpoints() throws Exception {
    mockMvc.perform(get("/dashboard")).andExpect(status().is3xxRedirection());
  }
}
