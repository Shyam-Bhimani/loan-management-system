package com.loan.week9.day3.src.main.java;

import com.loan.week9.day3.src.main.java.PaymentService.PaymentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class LoanService {

    private final LoanRepository repository;

    private final PaymentService paymentService;


    public LoanService(LoanRepository repository,@Qualifier("UPIPaymentService") PaymentService paymentService) {
        this.repository = repository;
        this.paymentService = paymentService;
    }

    public void createLoan() {
        repository.save();
        paymentService.pay();
    }
}
