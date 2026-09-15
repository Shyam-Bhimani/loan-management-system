package com.loan.week9.day1.src.main.java;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.loan.week9.day1.src.main.java") // Replace with your actual package name
public class SpringMain {

    public static void main(String[] args) {
        // 1. Create the Spring context (This triggers the creation of your beans)
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringMain.class);


        //_____________________Singletone example

        // 2. Retrieve the managed Service bean from the Spring context
        LoanService loanService1 = context.getBean(LoanService.class);
        LoanService loanService2 = context.getBean(LoanService.class);

        // 3. Call the method to verify it works
       // System.out.println(loanService.getLoan());

        boolean isSame= loanService1==loanService2;

        System.out.println("Service 1: " + loanService1.hashCode());
        System.out.println("Service 2: " + loanService2.hashCode());
        System.out.println("Are they the same instance? "+isSame);



        //__________________________________Prototype Example
        LoanProcessor p1 = context.getBean(LoanProcessor.class);
        LoanProcessor p2 = context.getBean(LoanProcessor.class);

        boolean isSameProcessor = p1==p2;
        System.out.println("Processor 1: " + p1.hashCode());
        System.out.println("Processor 2: " + p2.hashCode());
        System.out.println("Are they the same instance? "+isSameProcessor);
        // 4. Close the context
        context.close();

        //-----------LifeCycle Example
        System.out.println("\n");
        System.out.println("--- Starting Context ---");

        // Initialize context (triggers Constructor & @PostConstruct)
        AnnotationConfigApplicationContext context1 =
                new AnnotationConfigApplicationContext(LoanProcessor.class);

        // Registers a JVM shutdown hook to close the context automatically on exit
        context1.registerShutdownHook();

        System.out.println("--- Application running ---");

        // Force a close to explicitly see PreDestroy instantly in the logs
        context1.close();
    }
}
