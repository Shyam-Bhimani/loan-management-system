package com.loan.week6;

public class MyLinkedList {
    private Node head;
    public void addFirst(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        if(head==null){
            head=newNode;
            return;
        }
        Node current = head;
        while(current.next!=null){
            current = current.next;
        }
        current.next=newNode;
    }
    public void printList(){
        Node current = head;
        while(current!=null){
            System.out.println(current.data+"->");
            current=current.next;
        }
        System.out.println("null");
    }
    public boolean search(int key){
        Node current =head;
        while(current!=null){
            if(current.data==key){
                return true;
            }
            current=current.next;
        }
        return false;
    }
    public void delete(int key){
        if(head==null) return;
        if(head.data==key){
            head=head.next;
            return;
        }
        Node current = head;
        while(current.next !=null && current.next.data!=key){
            current=current.next;
        }
        if(current.next!=null){
            current.next=current.next.next;
        }
    }
}
