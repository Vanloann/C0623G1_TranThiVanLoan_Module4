package com.example.bookrent.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
public class AspectLog {
    @Pointcut("within(com.example.bookrent.controller.BookCodeController.*)")
    public void allMethodPointCut() {}

    @After("allMethodPointCut()")
    public void history(JoinPoint joinPoint) {
        System.out.println("Book was rented " + joinPoint.getSignature().getName() + " at " + LocalDateTime.now());
    }
}
