package com.loan.week7;

import java.util.PriorityQueue;

public class HeapBasicsPriorityQueue {

    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap =
                new PriorityQueue<>();

        minHeap.add(30);
        minHeap.add(10);
        minHeap.add(20);
        minHeap.add(5);
        minHeap.add(40);

        System.out.println(minHeap.peek()); // Prints 5
        System.out.println(minHeap.poll()); // Prints 5
        System.out.println(minHeap.poll()); // Prints 10

        minHeap.offer(7);
        System.out.println(minHeap.peek());



    }
}
