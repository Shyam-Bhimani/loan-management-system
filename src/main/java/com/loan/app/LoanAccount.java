package com.loan.app;

public class LoanAccount {
    private int balance = 100000;

    public synchronized boolean approvedLoan(int amount){
        if(balance>=amount){
            balance-=amount;
            System.out.println("Loan approved : "+amount);
            return true;
        }
            System.out.println("Insufficient balance");
            return false;
    }

    public int getBalance(){
        return balance;
    }
}
