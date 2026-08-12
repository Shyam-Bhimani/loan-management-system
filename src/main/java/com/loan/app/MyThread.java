package com.loan.app;

import java.sql.SQLOutput;

public class MyThread extends Thread{
    @Override
    public void run(){
        System.out.println("Thread is Running : "+Thread.currentThread().getName());
    }
}
