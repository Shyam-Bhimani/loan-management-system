package com.loan.week9.day1.src.main.java;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;



@Component
//@Scope("prototype")
public class LoanProcessor {

    public LoanProcessor() {
        System.out.println("Constructor");
    }
    @PostConstruct
    public void init() {
        System.out.println("PostConstruct");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("PreDestroy");
    }
}
