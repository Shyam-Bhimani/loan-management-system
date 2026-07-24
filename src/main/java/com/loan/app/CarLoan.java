package com.loan.app;

public class CarLoan extends Loan{

    @Override
    public void calculateInterest() {
        System.out.println("Calculating Car Loan Interest");
    }

    public CarLoan(int id,
                    double amount,
                    double rate,
                    String status) {

        super(id, amount, rate, status);
    }
}
