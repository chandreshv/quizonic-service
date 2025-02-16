package com.chandresh.quizonic.dashboard.controller;

import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.OAuth2AuthorizationException;
import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

  @GetMapping("/dashboard")
  public ResponseEntity<Map<String, Object>> showDashboard(
      @AuthenticationPrincipal OAuth2User user) {
    if (user == null || user.getAttributes().isEmpty()) {
      throw new OAuth2AuthorizationException(
          new OAuth2Error("invalid_token", "The user is not authenticated", null));
    }
    return ResponseEntity.ok(user.getAttributes());
  }
}
