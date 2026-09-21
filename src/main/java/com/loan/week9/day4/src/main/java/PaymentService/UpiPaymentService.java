package com.loan.week9.day4.src.main.java.PaymentService;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class UpiPaymentService implements PaymentService{
    @Override
    public void pay() {
        System.out.println("Paying via UPI");
    }
}