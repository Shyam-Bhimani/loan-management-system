package com.loan.week9.day2.src.main.java;

import org.springframework.stereotype.Repository;

@Repository
public class LoanRepository {
    public void save() {
        System.out.println("Loan saved");
    }
}
