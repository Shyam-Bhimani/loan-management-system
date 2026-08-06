package com.loan.app;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

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

        //day 2
        Greeting greeting = ()-> System.out.println("Hello Java!");
        greeting.sayHello();

        Calculator calculator = (x,y)-> x+y;
        calculator.add(1,5);

        List<String> names = new ArrayList<>();
        names.add("Shyam");
        names.add("Ram");
        names.add("John");
        names.add("Jack");

        names.forEach(name->System.out.println(name));

        //method reference
        names.forEach(System.out::println);

        //Consumer
        Consumer<String> consumer = name-> System.out.println(name);
        consumer.accept("Shyam");
        //Supplier
        Supplier<String> supplier = ()->"Welcome";
        System.out.println(supplier.get());
        //predicate
        Predicate<Integer> even = number ->number%2==0;
        System.out.println(even.test(20));
        //Function
        Function<String,Integer> length = String::length;
        System.out.println(length.apply("Shyam"));

        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer(2,"9876543210","Shyam","shyam@gmail.com"));
        customerList.add(new Customer(1,"9876543210","Rohit","rohit@gmail.com"));
        customerList.add(new Customer(3,"9876543210","Ram","ram@gmail.com"));
        customerList.add(new Customer(8,"98765345210","Sneha","sneha@gmail.com"));
        customerList.add(new Customer(9,"9871143210","Priya","priya@gmail.com"));
        customerList.add(new Customer(10,"9871143210","Priya","priya@gmail.com"));

        System.out.println();
        customerList.forEach(cust-> System.out.println(cust));
        System.out.println();
        customerList.forEach(System.out::println);

        customerList.sort(Comparator.comparing(Customer::getName));

        customerList.stream().filter(cust->cust.getName().startsWith("S")).forEach(System.out::println);

        //day 3
        //print cust name

        System.out.println("##### day 3 #####");
        customerList.
                stream().map(Customer::getName)
                .forEach(System.out::println);

        //print cust name sorted
        customerList.stream().sorted(Comparator.comparing(Customer::getName)).forEach(System.out::println);

        System.out.println();
        customerList.stream().map(Customer::getName).distinct().forEach(System.out::println);
        //disinct
        System.out.println();
        System.out.println(customerList.stream().map(Customer::getName).distinct().count());
        //collect
        System.out.println();
        List<Customer> listDistinct = customerList.stream()
                .filter(s->s.getName().startsWith("R"))
                        .collect(Collectors.toList());

        System.out.println(listDistinct);
        //find first
        customerList.stream().findFirst().ifPresent(System.out::println);
        //any match
        boolean hasShyam = customerList.stream().anyMatch(cust1->cust1.getName().equalsIgnoreCase("Shyam"));
        System.out.println(hasShyam);
        //all match
        boolean allhaveEmail = customerList.stream().allMatch(cust2->cust2.getEmail().contains("@"));
        System.out.println(allhaveEmail);

        //chain calls
        customerList.stream()
                .filter(custom->custom.getCustomerId()<10)
                .sorted(Comparator.comparing(Customer::getName))
                .map(Customer::getName)
                .forEach(System.out::println);

        //day 4
        System.out.println("##### day4 ####");
        //flat map
        List<List<String>> nameList = Arrays.asList(
                Arrays.asList("Shyam","Ram"),
                Arrays.asList("Amit", "Sneha")
        );

        nameList.stream().flatMap(List::stream).forEach(System.out::println);

        //reduce()
        List<Integer> loanAmount = Arrays.asList(10000,20000,30000);

        int total=loanAmount.stream().reduce(0,Integer::sum);
        System.out.println("Total loan amount sum"+total);

        //groupingBy
        Map<Character,List<Customer>> groupedCust = customerList.stream()
                .collect(Collectors.groupingBy(c->c.getName().charAt(0)));

        System.out.println(groupedCust);
        System.out.println();
        //partitioningBy
        Map<Boolean,List<Customer>> patisionedCust = customerList.stream()
                .collect(Collectors.partitioningBy(c->c.getCustomerId()>2));
        System.out.println(patisionedCust);

        //joining
        String custNames = customerList.stream()
                .map(Customer::getName)
                .collect(Collectors.joining(",","[","]"));
        System.out.println("\n"+custNames);

        //peek
        customerList.stream()
                .peek(c-> System.out.println("Before : "+c))
                .filter(c->c.getCustomerId()>2)
                .forEach(System.out::println);

        List<Loan> loanList = new ArrayList<>();
        loanList.add(new HomeLoan(902,8342344.00,8.5,"Approved"));
        loanList.add(new CarLoan(906,345534.35,8.9,"Sanctioned"));
        loanList.add(new HomeLoan(905,2342344.00,8.5,"Approved"));
        loanList.add(new CarLoan(904,345534.35,8.9,"Sanctioned"));
        loanList.add(new HomeLoan(908,2342344.00,8.5,"Approved"));
        loanList.add(new CarLoan(910,345534.35,8.9,"Sanctioned"));

        //calculate total loan amount
        Double sum = loanList.stream().map(Loan::getAmount).reduce(0.0, Double::sum);
        System.out.println(sum);
        //max loan amount
        Optional<Double> collect = loanList.stream().map(Loan::getAmount).max(Comparator.naturalOrder());
        System.out.println(collect.get());
        //group by laon type
        Map<String, List<Loan>> collect1 = loanList.stream().collect(Collectors.groupingBy(c -> c.getClass().getName()));
        System.out.println(collect1);
        //print only loan id
        loanList.stream().map(Loan::getLoanId).forEach(System.out::println);

    }


}