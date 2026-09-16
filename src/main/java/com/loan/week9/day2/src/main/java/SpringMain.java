package com.loan.week9.day2.src.main.java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = "com.loan.week9.day2.src.main.java")
public class SpringMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LoanConfig.class);
        LoanService l1 = context.getBean(LoanService.class);

        l1.createLoan();
    }


}
