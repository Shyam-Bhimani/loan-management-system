package com.loan.app;

public class HomeLoan extends Loan{

    @Override
    public void calculateInterest() {
        System.out.println("Calculating Home Loan Interest");
    }
}
