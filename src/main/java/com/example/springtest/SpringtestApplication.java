package com.example.springtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.springtest.controller")
public class SpringtestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringtestApplication.class, args);
    }

}