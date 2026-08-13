package com.loan.app;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class MainWeek4 {

    public static List<Customer> customers = new ArrayList<>();
    public static List<Loan> loans = new ArrayList<>();
    public static HashMap<Integer, Optional<Customer>> data = new HashMap<>();


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

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //day 1
        System.out.println("##### day 1 #####");

        int num = Integer.parseInt("100");
        System.out.println(num);
        try {
            int nums = Integer.parseInt("abc");
            System.out.println(nums);
        } catch (NumberFormatException numberFormatException) {
            System.out.println("Invalid Number");
        } catch (Exception exception) {
            System.out.println("Something went wrong..");
        } finally {
            System.out.println("In Finally block");
        }

        //throw
        int age = 15;
        if (age < 18) {
            //  throw new IllegalArgumentException("Age must be at least 18");
        }

        customers.add(new Customer(1, "Shyam", "9876543210", "shyam@gmail.com"));
        customers.add(new Customer(2, "Rohit", "9876543210", "rohit@gmail.com"));
        customers.add(null);
        // comment below to execute next
//        System.out.println(findCustomer(2));
        loans.add(new HomeLoan(902, 2342344.00, 8.5, "Approved"));
        loans.add(new CarLoan(906, 345534.35, 8.9, "Sanctioned"));
        loans.add(null);
        // comment below to execute next
//        System.out.println(findLoan(2));

        //validateLoanAmount(0.0);

        data.put(1, Optional.of(new Customer(1, "+91 9898989987", "shyam", "shyam@gamil.com")));
        data.put(2, Optional.empty());
        MainWeek4 mainWeek4 = new MainWeek4();
        //comment below for run next
//        mainWeek4.findById(2);

        //day 2
        System.out.println("##### day 2 #####");

        Path path = Path.of("customer.txt");
        System.out.println(path);

        Path path1 = Paths.get("customer.txt");
        System.out.println(path1);

        System.out.println(Files.exists(path));
        System.out.println(Files.isRegularFile(path));
        System.out.println(Files.isDirectory(path));

        try {
            if (!Files.exists(path)) {
                Files.createFile(path);
            }
            System.out.println("File Created!");
        } catch (IOException ioException) {
            System.out.println("Unable to create file!");
        }

        String data = """
                101,Shyam,shyam@gmail.com
                102,Rahul,rahul@gmail.com
                103,Amit,amit@gmail.com
                """;

        try {
            Files.writeString(path, data);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        try {
            String data1 = Files.readString(path);
            System.out.println();
            System.out.println(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            List<String> lines = Files.readAllLines(path);
            for (String s : lines) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Files.readAllLines(path).stream()
                    .filter(line -> !line.isBlank())
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //try eith resources
        System.out.println();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


//        Path directory = Path.of("data");
//        try {
//            Files.createDirectory(directory);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        Path customerFile = Path.of("data","customer.txt");
        try{
            Files.writeString(customerFile,"101,Shyam\n102,Rahul\n");
        }catch (IOException e){
            e.printStackTrace();
        }

        //copy
        Path source = Path.of("data", "customer.txt");

        Path destination =
                Path.of("data", "customers-backup.txt");
        try{
            Files.copy(source,destination,StandardCopyOption.REPLACE_EXISTING);
        }catch (IOException e){
            e.printStackTrace();
        }

        //move
        Path source1 =
                Path.of("data", "customers-backup.txt");

        Path destination1 =
                Path.of("data", "backup", "customer.txt");
        try {
            Files.createDirectories(destination.getParent());
            Files.move(source, destination, StandardCopyOption.REPLACE_EXISTING);
        }catch (IOException e){
            e.printStackTrace();
        }

        //delete
        try{
            Files.deleteIfExists(source1);
        }catch (IOException e){
            e.printStackTrace();
        }


        //Practical with Customer class and loan class
        Path customersPath = Path.of("data/customers.txt");
        Path loansPath = Path.of("data/loans.txt");
        try {
            if (!Files.exists(customersPath))
                Files.createFile(customersPath);
            if (!Files.exists(loansPath))
                Files.createFile(loansPath);
        }catch (IOException e){
            e.printStackTrace();
        }

        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer(2,"9876543210","Shyam","shyam@gmail.com"));
        customerList.add(new Customer(1,"9876543210","Rohit","rohit@gmail.com"));
        customerList.add(new Customer(3,"9876543210","Ram","ram@gmail.com"));
        customerList.add(new Customer(8,"98765345210","Sneha","sneha@gmail.com"));
        customerList.add(new Customer(9,"9871143210","Priya","priya@gmail.com"));
        customerList.add(new Customer(10,"9871143210","Priya","priya@gmail.com"));

        List<Loan> loanList = new ArrayList<>();
        loanList.add(new HomeLoan(902,8342344.00,8.5,"Approved"));
        loanList.add(new CarLoan(906,345534.35,8.9,"Sanctioned"));
        loanList.add(new HomeLoan(905,2342344.00,8.5,"Approved"));
        loanList.add(new CarLoan(904,345534.35,8.9,"Sanctioned"));
        loanList.add(new HomeLoan(908,2342344.00,8.5,"Approved"));
        loanList.add(new CarLoan(910,345534.35,8.9,"Sanctioned"));

        for(Customer cl:customerList){
            try {
                Files.writeString(customersPath, cl.toString()+"\n", StandardOpenOption.APPEND);
                Files.readAllLines(customersPath).stream()
                        .filter(line->line.isBlank())
                        .forEach(System.out::println);
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        for(Loan ll:loanList){
            try {
                Files.writeString(loansPath, ll.toString()+"\n", StandardOpenOption.APPEND);
                Files.readAllLines(loansPath).stream()
                        .filter(line->line.isBlank())
                        .forEach(System.out::println);
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        try{
            Path custBackUpPath = Path.of("backup","customers-backup.txt");
            if(!Files.exists(custBackUpPath)){
                Files.createFile(custBackUpPath);
            }
            Files.copy(customersPath,custBackUpPath,StandardCopyOption.REPLACE_EXISTING);
        }catch (Exception e){
            e.printStackTrace();
        }

        try{
            Path loanBackUpPath = Path.of("backup","loans-backup.txt");
            if(!Files.exists(loanBackUpPath)){
                Files.createFile(loanBackUpPath);
            }
            Files.copy(loansPath,loanBackUpPath,StandardCopyOption.REPLACE_EXISTING);
        }catch (Exception e){
            e.printStackTrace();
        }

        //Day 3
        System.out.println("\n ##### Day 3 #####\n");
        MyThread myThread = new MyThread();
        myThread.start();

        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("Processing Loan");
            }
        };

        //Runnable is Functional interface so, we can use lamda as well

        Runnable task2 = ()-> System.out.println("Processing Loan");
        Thread thread = new Thread(task);
        //thread.start();

        Runnable task3 = ()->{
            for(int i=1;i<=5;i++){
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread thread1 = new Thread(task3);
        thread1.start();
        thread1.join();
        System.out.println("Main continues");

        thread.setName("LoanProcessor");
        thread.start();
        System.out.println(thread.getName());
        System.out.println(Thread.currentThread().getName());

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Callable<Integer> task1 =()-> {return 10*100;};
        Future<Integer> futureresult = executorService.submit(task1);
        System.out.println(futureresult.get());
        executorService.submit(()-> System.out.println("Task 2"));
        executorService.submit(()-> System.out.println("Task 3"));
        executorService.shutdown();

        //Main Project Exercise
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for(Loan loan:loanList){
            executor.submit(()->{
                System.out.println("Processing Loan : "
                +loan.getLoanId()
                +" | Thread : "
                +Thread.currentThread().getName());
            });
        }
        executor.shutdown();


        //strech task
        ExecutorService strechExecutor = Executors.newFixedThreadPool(3);
        List<String> s=new ArrayList<>();
        Callable<List<String>> strechTask = ()->{
            for(Loan loan:loanList){
                s.add(loan.getLoanId() + " : Loan Processed!\n");
            }
            return s;
        };


        Future<List<String>> future =strechExecutor.submit(strechTask);
        System.out.println(future.get());
        strechExecutor.shutdown();


        //day 4
        System.out.println("##### Day 4 #####");
        Counter counter = new Counter();
        Thread t1 = new Thread(()->{
            for(int i=0;i<1000;i++){
                counter.increment();
            }
        });

        Thread t2= new Thread(()->{
            for(int i=0;i<1000;i++){
                counter.increment();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(counter.getCount());

//Real Life example
        ExecutorService loanService= Executors.newFixedThreadPool(2);
        LoanAccount account = new LoanAccount();

        Future<Boolean> result = loanService.submit(()->account.approvedLoan(70000));
        Future<Boolean> result1 = loanService.submit(()->account.approvedLoan(50000));
        System.out.println(result.get());
        System.out.println(result1.get());

        loanService.shutdown();
    }
}
