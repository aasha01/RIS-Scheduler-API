package com.devskrol.appointment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.r2dbc.R2dbcAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication()
public class HelloWorldApplication {
    public static void main(String[] args) {
        SpringApplication.run(HelloWorldApplication.class, args);
    }
}

@RestController
class HelloController {
    
    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }
    
    @GetMapping("/")
    public String home() {
        return "Welcome to Spring Boot Hello World API!";
    }
}