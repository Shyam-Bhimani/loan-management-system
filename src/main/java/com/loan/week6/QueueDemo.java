package com.loan.week6;

public class QueueDemo {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue(6);
        queue.offer(6);
        queue.offer(5);
        queue.offer(4);
        queue.offer(3);
        queue.offer(2);
        queue.offer(1);

        System.out.println("Size : "+queue.size());

        System.out.println("Poll : "+queue.poll());
        System.out.println("Poll : "+queue.poll());
//        queue.offer(7); do it intentionally to check the simple queue limitation
        System.out.println("Size after 2 poll: "+queue.size());
        System.out.println("Peek : "+queue.peek());


        System.out.println("\n#### Circular Queue ####\n");
        MyCircularQueue circularQueue = new MyCircularQueue(6);
        circularQueue.offer(6);
        circularQueue.offer(5);
        circularQueue.offer(4);
        circularQueue.offer(3);
        circularQueue.offer(2);
        circularQueue.offer(1);

        System.out.println("Size : "+circularQueue.size());

        System.out.println("Poll : "+circularQueue.poll());
        System.out.println("Poll : "+circularQueue.poll());
        circularQueue.offer(7);
        System.out.println("Size after 2 poll: "+circularQueue.size());
        System.out.println("Peek : "+circularQueue.peek());

    }
}
