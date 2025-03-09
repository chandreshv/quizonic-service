package com.chandresh.quizonic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class QuizonicApplication {

  public static void main(String[] args) {
    SpringApplication.run(QuizonicApplication.class, args);
  }
}
