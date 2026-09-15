package com.loan.week9.day1.src.main.java;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class LoanController {
    private final LoanService service;

    // Dependency is injected here
    public LoanController(LoanService service) {
        this.service = service;
        System.out.println("5. Controller Constructor");
    }

    @PostConstruct
    public void init() { System.out.println("6. Controller PostConstruct"); }
}