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
public class EmployeeControllerAspect {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSSSSS");

    //For Controller Layer
    @Before(value = "execution(* com.practice.controller.EmployeeController.*(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Request to " + joinPoint.getSignature() + " started at " + now.format(formatter));
    }

    // For Controller Layer
    @After(value = "execution(* com.practice.controller.EmployeeController.*(..))")
    public void afterAdvice(JoinPoint joinPoint) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Request to " + joinPoint.getSignature() + " ended at " + now.format(formatter) + "\n");
    }

/**
 * Other advices to explore
 *  @AfterReturning()
 *  @AfterThrowing
 *  https://websparrow.org/spring/spring-aop-aspectj-before-after-afterreturning-afterthrowing-and-around-annotation-example
 * Refer the above link to learn more about those annotations
 */

}