package com.loan.week6;

public class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList =new MyLinkedList();
        myLinkedList.addLast(12);
        myLinkedList.addFirst(10);
        myLinkedList.addFirst(7);
        myLinkedList.printList();
        System.out.println(myLinkedList.search(7));
        System.out.println(myLinkedList.search(100));
        myLinkedList.delete(7);
        myLinkedList.delete(100);
        myLinkedList.printList();
    }
}
