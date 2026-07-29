package com.loan.leetCode;

import java.util.LinkedList;
import java.util.Queue;

class RecentCounter {

    private Queue<Integer> requests;
    public RecentCounter() {
        requests =new LinkedList<>();
    }

    public int ping(int t) {
        requests.add(t);
        while(!requests.isEmpty()&& requests.peek()<t-3000){
            requests.poll();
        }return requests.size();
    }

    public static void main(String[] args) {
        // 1. Initialize the RecentCounter object
        RecentCounter obj = new RecentCounter();

        // 2. Define an array of sample millisecond timestamps (must be strictly increasing)
        int[] inputTimestamps = {1, 100, 3001, 3002};

        System.out.println("Processing Pings:");
        System.out.println("-----------------");

        // 3. Process each timestamp and print out the active window queue size
        for (int t : inputTimestamps) {
            int activeRequests = obj.ping(t);
            System.out.println("ping(" + t + ") -> Returns: " + activeRequests);
        }
    }

}
