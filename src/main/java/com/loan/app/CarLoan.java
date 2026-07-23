package com.loan.app;

public class CarLoan extends Loan{

    @Override
    public void calculateInterest() {
        System.out.println("Calculating Car Loan Interest");
    }
}
