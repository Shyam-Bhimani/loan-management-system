package com.loan.app;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter{
    private int count = 0;
//    public synchronized void increment(){
//        count++;
//    }
//
//    //synchronized block
////    public void increment(){
////        synchronized (this) {
////            count++;
////        }
////    }
//    public int getCount(){
//        return count;
//    }


    //AtomicInteger
//    private final AtomicInteger count = new AtomicInteger(0);
//    public void increment() {
//        count.incrementAndGet();
//    }
//
//    public int getCount() {
//        return count.get();
//    }

    //lock
    private final Lock lock =
            new ReentrantLock();

    public void increment() {

        lock.lock();

        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    public int getCount(){
        return count;
    }
}
