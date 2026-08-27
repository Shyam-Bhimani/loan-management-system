package com.loan.week6;

public class MyCircularQueue {
    int rear;
    int front;
    int[]arr;
    int size;

    MyCircularQueue(int capacity) {
        arr = new int[capacity];
        front = 0;
        rear = 0;
        size = 0;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public boolean isFull() {
        return size == arr.length;
    }

    public void offer(int value){
        if(!isFull()){
            arr[rear]=value;
            rear=(rear+1)%arr.length;
            size++;
        }else{
            throw new RuntimeException("Queue Overflow");
        }
    }

    public int poll(){
        if(!isEmpty()){
            int value=arr[front];
            front = (front+1)%arr.length;
            size--;
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
