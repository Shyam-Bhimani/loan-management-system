package com.loan.week6;

public class StackDemo {
    public static void main(String[] args) {
        MyStack myStack = new MyStack(6);
        myStack.push(10);
        myStack.push(20);
        myStack.push(30);
        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
        System.out.println(myStack.isEmpty());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.isEmpty());

    }
}
