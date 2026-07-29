package com.loan.app;

import java.util.*;

import static com.loan.app.Customer.displayCustomers;

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

        //day 6

        System.out.println("\n################ Day 6 ################\n");

        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer(1,"Shyam","9876543210","shyam@gmail.com"));
        customerList.add(new Customer(2,"Rohit","9876543210","rohit@gmail.com"));
        customerList.add(new Customer(3,"Ram","9876543210","ram@gmail.com"));

        //for loop
        for(int i=0;i<customerList.size();i++){
            System.out.println(customerList.get(i));
        }

        //foreach loop
        for(Customer cust:customerList){
            System.out.println(cust);
        }

        //iterator
        Iterator<Customer> iterator = customerList.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        List<Customer> customers_linkedList = new LinkedList<>();
        customers_linkedList.add(new Customer(4,"Priya","9873443210","priya@gmail.com"));
        customers_linkedList.add(new Customer(5,"Neha","98345443210","neha@gmail.com"));


        List<Loan> loans = new ArrayList<>();
        loans.add(new HomeLoan(902,2342344.00,8.5,"Approved"));
        loans.add(new CarLoan(906,345534.35,8.9,"Sanctioned"));

        for(Loan loan:loans){
            loan.calculateInterest();
        }

        displayCustomers(customerList);

        //day 7

        System.out.println("\n################ Day 7 ################\n");

        Set<Customer> customerSet = new HashSet<>();
        customerSet.add(new Customer(1,"Shyam","9876543210","shyam@gmail.com"));
        customerSet.add(new Customer(2,"Rohit","9876543210","rohit@gmail.com"));
        customerSet.add(new Customer(3,"Ram","9876543210","ram@gmail.com"));
        customerSet.add(new Customer(3,"Ram","9876543210","ram@gmail.com"));
        customerSet.add(new Customer(3,"Ram","9876543210","ram@gmail.com"));

        System.out.println(customerSet);
        customerSet.remove(new Customer(2,
                "Rohit",
                "9876543210",
                "rohit@gmail.com"));

        System.out.println(customerSet);

        Set<Customer> linkedCustomers = new LinkedHashSet<>();
        linkedCustomers.add(new Customer(1,"Shyam","9876543210","shyam@gmail.com"));
        linkedCustomers.add(new Customer(2,"Rohit","9876543210","rohit@gmail.com"));
        linkedCustomers.add(new Customer(3,"Ram","9876543210","ram@gmail.com"));
        linkedCustomers.add(new Customer(3,"Ram","9876543210","ram@gmail.com"));
        linkedCustomers.add(new Customer(3,"Ram","9876543210","ram@gmail.com"));

        Set<String> customerNames = new TreeSet<>();
        customerNames.add("Shyam");
        customerNames.add("Rahul");
        customerNames.add("Amit");
        customerNames.add("Neha");

        System.out.println("name ascending : "+customerNames);

        Set<String> descCustomerNames = new TreeSet<>(Comparator.reverseOrder());
        descCustomerNames.add("Shyam");
        descCustomerNames.add("Rahul");
        descCustomerNames.add("Amit");
        descCustomerNames.add("Neha");

        System.out.println("name ascending : "+descCustomerNames);

        Set<Integer> custIds = new TreeSet<>();
        custIds.add(2);
        custIds.add(9);
        custIds.add(5);
        custIds.add(3);
        custIds.add(1);
        System.out.println(custIds);


        Set<Customer> sortedCustomers = new TreeSet<>();
        sortedCustomers.add(new Customer(1,"Shyam","9876543210","shyam@gmail.com"));
        sortedCustomers.add(new Customer(9,"Rohit","9876543210","rohit@gmail.com"));
        sortedCustomers.add(new Customer(2,"Ram","9876543210","ram@gmail.com"));
        sortedCustomers.add(new Customer(5,"Priya","9876543210","priya@gmail.com"));
        sortedCustomers.add(new Customer(8,"Neha","9876543210","neha@gmail.com"));

        System.out.println(sortedCustomers);

        //day 8

        System.out.println("\n################ Day 8 ################\n");

        Map<Integer, Customer> customerMap = new HashMap<>();
        customerMap.put(101,new Customer(1,"Shyam","9876543210","shyam@gmail.com"));
        customerMap.put(109,new Customer(9,"Ram","9876453210","ram@gmail.com"));
        customerMap.put(102,new Customer(2,"Priya","98458743210","priya@gmail.com"));
        customerMap.put(105,new Customer(5,"Neha","98765743210","neha@gmail.com"));

        Customer cust = customerMap.get(102);
        System.out.println(cust);

        for(Map.Entry<Integer,Customer> entry : customerMap.entrySet()){
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }

        for(Integer id : customerMap.keySet()){
            System.out.println(id);
        }

        for(Customer cust1:customerMap.values()){
            System.out.println(cust1);
        }

        customerMap.put(105,new Customer(5,"Sneha","98762343210","sneha@gmail.com"));
        System.out.println("\n"+customerMap);

        System.out.println(customerMap.containsKey(102));
        System.out.println(customerMap.containsKey(103));
        System.out.println(customerMap.containsValue(cust));

        //Stretch goal
        Map<Integer,Loan> loanMap = new HashMap<>();
        loanMap.put(101,new HomeLoan(101,23424434.44,8.3,"Disbursed"));
        loanMap.put(801,new CarLoan(102,345345.35,9.3,"Approved"));
        loanMap.put(105,new HomeLoan(103,23424434.44,8.3,"Disbursed"));
        loanMap.put(802,new CarLoan(104,345345.35,9.3,"Pending Doc"));

        loanMap.get(801).calculateInterest();

        //day 9

        System.out.println("\n################ Day 9 ################\n");

        Queue<Customer> customerQueue = new LinkedList<>();
        customerQueue.offer(new Customer(1,"Shyam","9876543210","shyam@gmail.com"));
        customerQueue.offer(new Customer(2,"Ram","9871113210","ram@gmail.com"));
        customerQueue.offer(new Customer(3,"John","9876323210","john@gmail.com"));

        System.out.println(customerQueue);

        System.out.println(customerQueue.peek());
        System.out.println(customerQueue.poll());
        System.out.println(customerQueue.peek());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(123);
        priorityQueue.offer(12);
        priorityQueue.offer(18);
        priorityQueue.offer(1);
        priorityQueue.offer(112);
        priorityQueue.offer(100);

        System.out.println(priorityQueue);

        while(!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.poll());
        }

        Deque<String> tasks = new ArrayDeque<>();
        tasks.offerLast("Verify Loan");
        tasks.offerLast("Approve Loan");
        tasks.offerLast("Generate Report");

        System.out.println(tasks.pollFirst());

        //Use Deque as Stack

        Deque<String> stackHistory = new ArrayDeque<>();
        stackHistory.push("Home");
        stackHistory.push("Customer");
        stackHistory.push("Loan");

        System.out.println(stackHistory.pop());
        System.out.println(stackHistory.peek());

        //stretch goal
        Queue<Loan> loanQueue = new LinkedList<>();
        loanQueue.offer(new HomeLoan(101,23424434.44,8.3,"Disbursed"));
        loanQueue.offer(new CarLoan(102,345345.35,9.3,"Approved"));
        loanQueue.offer(new HomeLoan(103,23424434.44,8.3,"Disbursed"));
        loanQueue.offer(new CarLoan(104,345345.35,9.3,"Pending Doc"));

        while(!loanQueue.isEmpty()){
            Loan loan =loanQueue.poll();
            loan.calculateInterest();
        }
    }
}