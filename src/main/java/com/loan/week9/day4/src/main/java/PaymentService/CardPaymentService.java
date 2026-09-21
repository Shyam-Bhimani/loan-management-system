package com.loan.week9.day4.src.main.java.PaymentService;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class CardPaymentService implements PaymentService{
    @Override
    public void pay() {
        System.out.println("Paying via Card");
    }
}
