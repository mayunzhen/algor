package com.example.algorithm.leetcode.easy;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x){val = x;}
}
public class MergeTwoSortedLists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode head = new ListNode(0);
        ListNode dummy = head;
        while (l1 != null && l2 !=null){
            if(l1.val > l2.val){
                ListNode newNode = new ListNode(l2.val);
                dummy.next = newNode;
                dummy = dummy.next;
                l2 = l2.next;
            }else {
                ListNode newNode = new ListNode(l1.val);
                dummy.next = newNode;
                dummy = dummy.next;
                l1 = l1.next;
            }

        }
        while (l1 != null){
            ListNode newNode = new ListNode(l1.val);
            dummy.next = newNode;
            dummy = dummy.next;
            l1 = l1.next;
        }
        while (l2 != null){
            ListNode newNode = new ListNode(l2.val);
            dummy.next = newNode;
            dummy = dummy.next;
            l2 = l2.next;
        }
        return head.next;
    }
    //recursive method
    public static ListNode mergeTwoLists1(ListNode l1,ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoLists1(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists1(l1,l2.next);
           return l2;
        }
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);
        l1.next = node2;
        node2.next = node3;

        ListNode l2 = new ListNode(2);
        ListNode node22 = new ListNode(4);
        ListNode node32 = new ListNode(6);
        l2.next = node22;
        node22.next = node32;
        ListNode listNode = mergeTwoLists1(l1,l2);
        System.out.println(listNode);
    }
}
