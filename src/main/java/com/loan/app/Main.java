package com.loan.app;

public class Main {
    public static void displayCustomer(Customer customer){
        System.out.println(customer);
    }
    public static void displayLoan(Loan loan){
        System.out.println(loan);
    }

    public static void main(String[] args) {
//        Customer customer1 = new Customer(1,"+91 9891911111","Same","same@gmail.com");
//        Customer customer2 = new Customer(2,"+91 9891922222","John","john@gmail.com");
//        Customer customer3 = new Customer(3,"+91 9891922222","Tom","tom@gmail.com");
//        Customer customer4 = new Customer(4,"+91 9891922222","Jerry","jerry@gmail.com");
//
//        Loan loan1 = new Loan(1234567,200000.00,8.25,"Disbursed");
//        Loan loan2 = new Loan(9876548,500000.00,8.25,"Under Review");
//        Loan loan3 = new Loan(7567345,600000.00,8.5,"Application Received");
//        Loan loan4 = new Loan(3457543,900000.00,8.10,"Disbursed");
//
//        System.out.println("Customer 1");
//        displayCustomer(customer1);
//        displayLoan(loan1);
//
//        System.out.println("Customer 2");
//        displayCustomer(customer2);
//        displayLoan(loan2);
//
//        System.out.println("Customer 3");
//        displayCustomer(customer3);
//        displayLoan(loan3);
//
//        System.out.println("Customer 4");
//        displayCustomer(customer4);
//        displayLoan(loan4);

//        Person person = new Person("+91 9090909090","John Wick","wick.john@gmail.com");
//
//        Customer customer = new Customer(1,"+91 9080808080","Christopher nolen","chris.n@gmail.com");
//
//        Employee employee = new Employee(101,"Admin","+91 9003030030","Rambo K","rembo.k@gmail.com");
//
//        Admin admin = new Admin(101,"Admin","+91 9003030030","Rambo K","rembo.k@gmail.com");
//        System.out.println(admin);
//
//        person.displayDetails();
//        System.out.println(person);
//
//        customer.displayDetails();
//        System.out.println(customer);
//
//        employee.displayDetails();
//        System.out.println(employee);
//
//        Person[] persons = {
//                new Customer(1, "+91...", "Shyam", "shyam@gmail.com"),
//                new Employee(101, "Admin", "+91...", "Amit", "amit@gmail.com"),
//                new Admin(201, "IT", "+91...", "John", "john@gmail.com")
//        };
//
//        for (Person p : persons) {
//            p.displayDetails();
//        }
//
        Person customer = new Customer(1, "+91 9897869584", "Shyam", "shyam@gmail.com");
        Person employee = new Employee(101, "Admin", "+91 3459453453", "Amit", "amit@gmail.com") ;

        customer.displayDetails();

        employee.displayDetails();

        LoanCalculator loanCalculator=new LoanCalculator();
        System.out.println(loanCalculator.calculateEMI(200000));
        System.out.println(loanCalculator.calculateEMI(200000, 8.5));
        System.out.println(loanCalculator.calculateEMI(200000, 8.5, 20));

        //DownCasting
        Person person=new Customer();

        Customer customer1=(Customer) person;
        customer1.displayDetails();

        Person admin =new Admin(101, "Admin", "+91 3459453453", "Amit", "amit@gmail.com");
        admin.displayDetails();

        LoanCalculator loanCalculator1=new LoanCalculator();
        loanCalculator1.printCalculationMessage();
        System.out.println(loanCalculator1.calculateEMI(200000, 8.5, 20));
        EMICalculator.version();
        loanCalculator1.sendNotification();

        Loan homeLoan = new HomeLoan(1001,200000,8.5,"sanctioned");
        Loan carLoan = new CarLoan(2002,200000,9.8,"disbursed");

        homeLoan.calculateInterest();
        carLoan.calculateInterest();

        //day 5

        System.out.println("\n################ Day 5 ################\n");
        LoanCounter loan1 = new LoanCounter();
        LoanCounter loan2 = new LoanCounter();
        LoanCounter loan3 = new LoanCounter();

        System.out.println(LoanCounter.getTotalLoans());

        System.out.println(Constants.MIN_INTEREST);

        System.out.println("\n***** equals() *****\n");
        Customer c1 = new Customer(1,"Shyam","9876543210","shyam@gmail.com");
        Customer c2 = new Customer(1,"ShyamA","9876543210","shyam@gmail.com");
        Customer c3 = new Customer(2,"ShyamB","9876543210","shyam@gmail.com");
        System.out.println("c1.equals(c2) : "+c1.equals(c2));
        System.out.println("c1.equals(c3) : "+c1.equals(c3));

        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());

        System.out.print("c1==c2");
        System.out.println(c1==c2);
        System.out.println("c1.equals(c2) : "+c1.equals(c2));

        System.out.println(LoanUtility.calculateGST(10000));
    }
}