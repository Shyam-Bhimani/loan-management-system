package com.loan.week6;

public class MyQueue {
    int rear;
    int front;
    int[]arr;
    int size;

    MyQueue(int capacity) {
        arr = new int[capacity];
        front = -1;
        rear = -1;
        size = 0;
    }

    public boolean isEmpty(){
        return front==-1;
    }

    public boolean isFull() {
        return rear == arr.length - 1;
    }

    public void offer(int value){
        if(!isFull()){
            if(isEmpty()){
                front=0;
            }

            rear++;
            arr[rear]=value;
            size++;
        }else{
            throw new RuntimeException("Queue Overflow");
        }
    }

    public int poll(){
        if(!isEmpty()){
            int value=arr[front];
            size--;
            if(front==rear){
                front=-1;
                rear=-1;
            }else{
                front++;
            }
            return value;
        }
        else {
            throw new RuntimeException("Queue Underflow");
        }
    }

    public int peek(){
        if(!isEmpty()){
            return arr[front];
        }else {
            return -1;
        }
    }

    public int size(){
        return size;
    }
}
