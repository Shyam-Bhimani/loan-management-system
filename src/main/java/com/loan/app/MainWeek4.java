package com.loan.app;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class MainWeek4 {

    public static List<Customer> customers = new ArrayList<>();
    public static List<Loan> loans = new ArrayList<>();
    public static HashMap<Integer, Optional<Customer>> data = new HashMap<>();

    public static void main(String[] args) {
        //day 1
        System.out.println("##### day 1 #####");

        int num = Integer.parseInt("100");
        System.out.println(num);
        try {
            int nums = Integer.parseInt("abc");
            System.out.println(nums);
        }catch (NumberFormatException numberFormatException){
            System.out.println("Invalid Number");
        }catch (Exception exception){
            System.out.println("Something went wrong..");
        }finally{
            System.out.println("In Finally block");
        }

        //throw
        int age = 15;
        if(age<18){
          //  throw new IllegalArgumentException("Age must be at least 18");
        }

        customers.add(new Customer(1,"Shyam","9876543210","shyam@gmail.com"));
        customers.add(new Customer(2,"Rohit","9876543210","rohit@gmail.com"));
        customers.add(null);
        // comment below to execute next
//        System.out.println(findCustomer(2));
        loans.add(new HomeLoan(902,2342344.00,8.5,"Approved"));
        loans.add(new CarLoan(906,345534.35,8.9,"Sanctioned"));
        loans.add(null);
        // comment below to execute next
//        System.out.println(findLoan(2));

        //validateLoanAmount(0.0);

        data.put(1, Optional.of(new Customer(1, "+91 9898989987", "shyam", "shyam@gamil.com")));
        data.put(2, Optional.empty());
        MainWeek4 mainWeek4 = new MainWeek4();
       //comment below for run next
//        mainWeek4.findById(2);
    }

    public void readFile() throws FileNotFoundException {
        FileReader fileReader = new FileReader("abc.txt");
    }
    public static Customer findCustomer(int customerId) {

        Customer customer = customers.get(customerId);

        if (customer == null) {
            throw new CustomerNotFoundException(
                    "Customer not found: " + customerId
            );
        }
        return customer;
    }

    public static Loan findLoan(int loanId){
        Loan loan =loans.get(loanId);
        if(loan==null){
            throw new LoanNotFoundException("Loan not Found : "+loanId);
        }
        return loan;
    }

    public static void validateLoanAmount(double amount){
        if(amount<=0){
            throw new InvalidLoanAmountException("Loan amount must be greater than zero");
        }
    }

    public Customer findById(int id){
        return data.get(id).orElseThrow(()->new RuntimeException("Object Not Found"));
    }
}
