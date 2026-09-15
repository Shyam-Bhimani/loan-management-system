package com.loan.week9.day1.src.main.java;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;


@Repository
public class LoanRepository {
    public LoanRepository() { System.out.println("1. Repository Constructor"); }

    @PostConstruct
    public void init() { System.out.println("2. Repository PostConstruct"); }
}