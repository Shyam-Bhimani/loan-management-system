package com.loan.week6;

public class MyStack {
    private int[] arr;
    private int top;

    MyStack(int capacity){
        arr = new int[capacity];
        top=-1;
    }

    void push(int value){
        if(top==arr.length-1){
            throw new RuntimeException("Stack Overflow");
        }
        arr[++top]=value;
    }

    int pop(){
        if(top==-1){
            throw new RuntimeException("Stack Underflow");
        }
        return arr[top--];
    }

    int peek(){
        if(top==-1){
            throw new RuntimeException("Stack is Empty");
        }
        return arr[top];
    }

    boolean isEmpty(){
        return top==-1;
    }
}
