package com.loan.week9.day3.src.main.java.PaymentService;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class CardPaymentService implements PaymentService{

    @Override
    public void pay() {
        System.out.println("Paying via Card");
    }
}
