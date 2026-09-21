package com.loan.week9.day4.src.main.java.LoanValidator;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class IncomeValidator implements LoanValidator{
    @Override
    public void validate() {
        System.out.println("Income Validator!");
    }
}
