package com.loan.app;

public interface EMICalculator {

    default void printCalculationMessage(){
        System.out.println("Calculating EMI...");
    }

    static void version(){
        System.out.println("EMI Calculator v1");
    }
    double calculateEMI(double amount, double interestRate,int year);
}
