package com.chandresh.quizonic.home.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

    @RequestMapping("/")
    public ResponseEntity<String> home() {
        return ResponseEntity.ok("Welcome to Quizonic!");
    }
}
