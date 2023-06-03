package com.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.function.Function;

@SpringBootApplication
@ComponentScan("com.practice")
@EnableCaching
public class SpringBootAopApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAopApplication.class, args);
    }

}