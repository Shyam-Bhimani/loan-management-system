package com.loan.app;

public class InvalidLoanAmountException extends RuntimeException {
    public  InvalidLoanAmountException(String message){
        super(message);
    }
}
