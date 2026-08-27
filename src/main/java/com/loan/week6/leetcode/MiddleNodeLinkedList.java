package com.loan.week6.leetcode;

import com.loan.week6.ListNode;

public class MiddleNodeLinkedList {
    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    /*How It Works
    Initialize two pointers (slow and fast) at the head of the list.
    Move slow forward by one step at a time.
    Move fastforward by two steps at a time.
    When fast reaches the end, slow will be exactly at the middle node.
    If the list has an even number of nodes,
    it automatically returns the second middle node.
    */
    public static void main(String[] args) {
        ListNode listNode=new ListNode(1);
        listNode.next=new ListNode(2);
        listNode.next=new ListNode(3);
        listNode.next=new ListNode(4);
        listNode.next=new ListNode(5);

        ListNode ans = middleNode(listNode);
    }
}
