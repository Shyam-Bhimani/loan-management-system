package com.loan.app;

public class LoanCounter {
    private static int totalLoans = 0;
    public LoanCounter() {
        totalLoans++;
    }
    public static int getTotalLoans() {
        return totalLoans;
    }
}