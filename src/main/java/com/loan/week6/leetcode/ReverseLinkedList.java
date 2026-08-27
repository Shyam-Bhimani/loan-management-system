package com.loan.week6.leetcode;

import com.loan.week6.ListNode;

public class ReverseLinkedList {
    public static ListNode reverseList(ListNode head) {
        ListNode prev=null;
        ListNode curr =head;

        while(curr!=null){
            ListNode nxt= curr.next;
            curr.next=prev;
            prev=curr;
            curr=nxt;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode listNode=new ListNode(1);
        listNode.next=new ListNode(2);
        listNode.next=new ListNode(3);
        listNode.next=new ListNode(4);
        listNode.next=new ListNode(5);

        ListNode ans = reverseList(listNode);
    }
}
