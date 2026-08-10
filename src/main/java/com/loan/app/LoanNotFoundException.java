package com.loan.app;

public class LoanNotFoundException extends RuntimeException{
    public LoanNotFoundException(String message){
        super(message);
    }
}
