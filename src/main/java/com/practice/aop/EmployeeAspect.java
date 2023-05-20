package com.practice.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SuppressWarnings("SpellCheckingInspection")
@Aspect
@Component
public class EmployeeAspect {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSSSSS");

    @Before(value = "execution(* com.practice.controller.EmployeeController.*(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Request to " + joinPoint.getSignature() + " started at " +now.format(formatter));
    }

    @After(value = "execution(* com.practice.controller.EmployeeController.*(..))")
    public void afterAdvice(JoinPoint joinPoint) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Request to " + joinPoint.getSignature() + " ended at " + now.format(formatter));
    }
}