package com.loan.week9.day4.src.main.java.LoanValidator;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class CreditScoreValidator implements LoanValidator{

    @Override
    public void validate() {
        System.out.println("Credit Validator!");
    }
}
