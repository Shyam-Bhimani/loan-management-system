package com.loan.week9.day1.src.main.java;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class LoanService {
    private final LoanRepository repository;

    // Dependency is injected here
    public LoanService(LoanRepository repository) {
        this.repository = repository;
        System.out.println("3. Service Constructor");
    }

    @PostConstruct
    public void init() { System.out.println("4. Service PostConstruct"); }
}
