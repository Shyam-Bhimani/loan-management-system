package com.loan.week9.day4.src.main.java;

import org.springframework.boot.web.context.reactive.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@Configuration
public class SpringMain {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigReactiveWebApplicationContext(SpringMain.class);
        LoanRepository lr = context.getBean(LoanRepository.class);
        LoanService ls = context.getBean(LoanService.class);
        LoanValidationService loanValidationService = context.getBean(LoanValidationService.class);

        loanValidationService.runAllValidators();
        loanValidationService.printValidatorMap();
        ls.fetchLoanDetails();


    }

}
