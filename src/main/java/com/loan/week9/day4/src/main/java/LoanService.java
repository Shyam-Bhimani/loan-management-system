package com.loan.week9.day4.src.main.java;

import com.loan.week9.day4.src.main.java.LoanValidator.LoanValidator;
import com.loan.week9.day4.src.main.java.PaymentService.PaymentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class LoanService {
    LoanRepository repository;
    PaymentService paymentService;

    public LoanService(LoanRepository loanRepository,@Qualifier("upiPaymentService") PaymentService paymentService){
        this.repository=loanRepository;
        this.paymentService = paymentService;
    }

    public void fetchLoanDetails(){
        repository.LoanDetails();
        paymentService.pay();
        System.out.println("Loan Details Fetched!");
    }
}
