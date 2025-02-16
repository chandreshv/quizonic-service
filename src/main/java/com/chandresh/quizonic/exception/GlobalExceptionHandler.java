package com.chandresh.quizonic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.core.OAuth2AuthorizationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(OAuth2AuthorizationException.class)
  public ResponseEntity<String> handleOAuthException(OAuth2AuthorizationException ex) {
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
        .body("Authentication Failed: " + ex.getError().getDescription());
  }

  @ExceptionHandler(NoResourceFoundException.class)
  public ResponseEntity<String> handleGeneralException(NoResourceFoundException ex) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body("Resource not found: " + ex.getResourcePath());
  }
}
