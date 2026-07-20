package com.loan.app;

public class Main {
    public static void displayCustomer(Customer customer){
        System.out.println(customer);
    }
    public static void displayLoan(Loan loan){
        System.out.println(loan);
    }

    public static void main(String[] args) {
        Customer customer1 = new Customer(1,"+91 9891911111","Same","same@gmail.com");
        Customer customer2 = new Customer(1,"+91 9891922222","John","john@gmail.com");
        Customer customer3 = new Customer(1,"+91 9891922222","Tom","tom@gmail.com");
        Customer customer4 = new Customer(1,"+91 9891922222","Jerry","jerry@gmail.com");

        Loan loan1 = new Loan(1234567,200000.00,8.25f,"Disbursed");
        Loan loan2 = new Loan(9876548,500000.00,8.25f,"Under Review");
        Loan loan3 = new Loan(7567345,600000.00,8.5f,"Application Received");
        Loan loan4 = new Loan(3457543,900000.00,8.10f,"Disbursed");

        System.out.println("Customer 1");
        displayCustomer(customer1);
        displayLoan(loan1);

        System.out.println("Customer 2");
        displayCustomer(customer2);
        displayLoan(loan2);

        System.out.println("Customer 3");
        displayCustomer(customer3);
        displayLoan(loan3);

        System.out.println("Customer 4");
        displayCustomer(customer4);
        displayLoan(loan4);

    }
}