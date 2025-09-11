package com.example.springtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.springtest.GetDb;

@SpringBootApplication
public class SpringtestApplication {

    public static void main(String[] args) {
        GetDb getDb = new GetDb();
        getDb.manageDatabaseSession();
        SpringApplication.run(SpringtestApplication.class, args);
    }

}