package com.loan.app;

import java.util.*;

import static com.loan.app.Customer.displayCustomers;

public class MainWeek3 {
    public static void main(String[] args) {
        //day 1
        System.out.println("###### week3 day1 ######");

        int age = 25;
        Integer wrapperAge = age; //Autoboxing

        int value = wrapperAge; // unboxing
        System.out.println(age);
        System.out.println(wrapperAge);
        System.out.println(value);

        // error with primitive
        // List<int> number = new ArrayList<>();

        List<Integer> numbers = new ArrayList<>();

        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        System.out.println(numbers);

        Box<Integer> IntegerBox = new Box<>();
        IntegerBox.setValue(100);
        System.out.println(IntegerBox.getValue());

        Box<String> StringBox = new Box<>();
        StringBox.setValue("Java");
        System.out.println(StringBox.getValue());

        Utility.print("Shyam");
        Utility.print(23.09);
        Utility.print(101);

        Pair<Integer,String> customer = new Pair<>(90,"Shyam");
        customer.printPair();

        NumberBox<Integer> integerNumberBox = new NumberBox<>(90);
        NumberBox<Double> doubleNumberBox = new NumberBox<>(43.43);

        //error
        //NumberBox<String> stringNumberBox = new NumberBox<String>("Java");

        Repository<Customer> customers = new Repository<>();
        customers.save(new Customer(101, "+919898989893","Shyam","shyam@gmail.com"));
        customers.save(new Customer(102, "+919898456893","Ram","ram@gmail.com"));
        customers.save(new Customer(103, "+919898753893","John","john@gmail.com"));
        customers.save(new Customer(104, "+919898346893","Jack","jack@gmail.com"));
        System.out.println("All Customer : \n"+customers.getAll());

        Repository<Loan> loans = new Repository<>();
        loans.save(new CarLoan(10001,123123.31,8.9,"Approved"));
        loans.save(new HomeLoan(10002,3423123.31,8.9,"Pending Doc"));
        loans.save(new CarLoan(10003,223123.31,8.9,"Disbursed"));
        loans.save(new HomeLoan(10004,1273123.31,8.9,"Approved"));
        System.out.println("All Loans : \n"+loans.getAll());
    }

}