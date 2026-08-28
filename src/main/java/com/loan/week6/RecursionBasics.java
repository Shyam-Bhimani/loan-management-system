package com.loan.week6;

public class RecursionBasics {
    public static void printNumber(int n){
        if(n<0){
            return;
        }
        System.out.println(n);
        printNumber(n-1);
    }

    public static int factorial(int n){
        if(n==0 || n==1){
            return 1;
        }
        return n*factorial(n-1);
    }

    public static int sum(int n){
        if(n<=0){
            return 0;
        }
        return n+sum(n-1);
    }

    public static int fibonacci(int n){
        if(n==0) return 0;
        if(n==1) return 1;

        return fibonacci(n-1)+fibonacci(n-2);
    }
    public static void main(String[] args) {
        printNumber(5);
        System.out.println(factorial(3));
        System.out.println(sum(5));
        System.out.println(fibonacci(8));
    }
}
