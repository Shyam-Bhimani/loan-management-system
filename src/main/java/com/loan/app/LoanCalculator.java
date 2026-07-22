package com.loan.app;

public class LoanCalculator {
    public double calculateEMI(double amount) {
        return amount * 0.10;
    }

    public double calculateEMI(double amount, double interestRate) {
        return amount * interestRate / 100;
    }

    public double calculateEMI(double amount,
                               double interestRate,
                               int years) {
        return amount * interestRate * years / 100;
    }
}
