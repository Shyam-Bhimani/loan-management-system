package com.loan.week7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class HeapBasicsArrayList {
    private ArrayList<Integer> heap = new ArrayList<>();

    public void offer(int val){
        heap.add(val);
        siftUp(heap.size()-1);
    }

    public Integer peek(){
        if(heap.isEmpty())
            return null;
        return heap.get(0);
    }

    public Integer poll(){
        if(heap.isEmpty()) return null;
        int minVal = heap.get(0);
        int lastVal = heap.remove(heap.size()-1);

        if(!heap.isEmpty()){
            heap.set(0,lastVal);
            siftDown(0);
        }
        return minVal;
    }

    private void siftUp(int index){
        while(index>0){
            int parentIndex = (index-1)/2;
            if(heap.get(index)>=heap.get(parentIndex)) break;
            swap(index,parentIndex);
            index=parentIndex;
        }
    }

    private void siftDown(int index){
        int size=heap.size();
        while(2*index+1<size) {
            int leftChild = 2 * index + 1;
            int rightChild = leftChild + 1;
            int smallest = leftChild;

            if (rightChild < size && heap.get(rightChild) < heap.get(leftChild)){
                smallest = rightChild;
        }
        if(heap.get(index)<=heap.get(smallest)) break;
        swap(index,smallest);
        index=smallest;
        }
    }

    private void swap(int i,int j){
        int temp=heap.get(i);
        heap.set(i,heap.get(j));
        heap.set(j,temp);
    }

    public static void main(String[] args) {
        HeapBasicsArrayList minHeap = new HeapBasicsArrayList();

        // Add step
        minHeap.offer(30); minHeap.offer(10); minHeap.offer(20); minHeap.offer(5); minHeap.offer(40);

        // Verification steps matching your trace
        System.out.println("peek(): " + minHeap.peek()); // Expected: 5
        System.out.println("poll(): " + minHeap.poll()); // Expected: 5
        System.out.println("poll(): " + minHeap.poll()); // Expected: 10

        minHeap.offer(7);
        System.out.println("peek() after offer(7): " + minHeap.peek()); // Expected: 7
    }
}
