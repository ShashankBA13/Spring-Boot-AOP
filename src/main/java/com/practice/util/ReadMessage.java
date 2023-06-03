package com.practice.util;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("application-dev.yml")
@Profile("dev") // Creates this bean only if the active profile is dev
public class ReadMessage {

    @Value("${message}")
    private String message;

    @Value("${dev-message}")
    private String devMessage;

    @PostConstruct
    private void printMessage() {
        System.out.println("Message: " + message);
        System.out.println("Message from dev profile: " + devMessage);
    }

    @PreDestroy
    private void doStuff() {
        System.out.println("cleanup process or some task here");
    }
}