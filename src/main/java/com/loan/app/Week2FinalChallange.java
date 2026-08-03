package com.loan.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Week2FinalChallange {
    public static void main(String[] args) {
        List<Customer> customers =new ArrayList<>();
        customers.add(new Customer(22,"Shyam","9876543210","shyam@gmail.com"));
        customers.add(new Customer(11,"Rohit","9879873210","rohit@gmail.com"));
        customers.add(new Customer(30,"Jerry","9872563210","jerry@gmail.com"));
        customers.add(new Customer(19,"John","98763289210","john@gmail.com"));
        customers.add(new Customer(12,"Tom","9872813210","tom@gmail.com"));

        customers.sort(Comparator.comparing(Customer::getCustomerId));
        System.out.println("sorted by id : \n"+customers);

        customers.sort((c1,c2)->c1.getName().compareTo(c2.getName()));
        System.out.println("sorted by name : \n"+customers);

        customers.sort(Comparator.comparing(Customer::getEmail));
        System.out.println("sorted by email : \n"+customers);

        customers.sort(Comparator.comparing(Customer::getCustomerId).reversed());
        System.out.println("sorted by ID desc : \n"+customers);

        customers.sort(Comparator.comparing(Customer::getName).thenComparing(Customer::getCustomerId));
        System.out.println("sorted by name and then id : \n"+customers);
    }
}
