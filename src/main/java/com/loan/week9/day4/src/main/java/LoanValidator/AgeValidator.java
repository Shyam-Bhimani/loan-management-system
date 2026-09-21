package com.loan.week9.day4.src.main.java.LoanValidator;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class AgeValidator implements LoanValidator {

    @Override
    public void validate() {
        System.out.println("Age Validator!");
    }
}
