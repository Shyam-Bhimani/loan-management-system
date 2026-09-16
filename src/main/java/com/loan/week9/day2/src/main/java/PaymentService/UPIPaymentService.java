package com.loan.week9.day2.src.main.java.PaymentService;

import org.springframework.stereotype.Service;

@Service
public class UPIPaymentService implements PaymentService{

    @Override
    public void pay() {
        System.out.println("Paying via UPI");
    }
}
