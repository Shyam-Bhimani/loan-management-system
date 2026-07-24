package com.loan.app;

public class HomeLoan extends Loan{

    @Override
    public void calculateInterest() {
        System.out.println("Calculating Home Loan Interest");
    }

    public HomeLoan(int id,
                    double amount,
                    double rate,
                    String status) {

        super(id, amount, rate, status);
    }
}
