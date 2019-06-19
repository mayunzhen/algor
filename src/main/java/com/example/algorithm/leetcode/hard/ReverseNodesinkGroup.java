package com.example.algorithm.leetcode.hard;

import java.util.Stack;

/*
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

 */
public class ReverseNodesinkGroup {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    //用stack来存储这K个需要反转的链表
    public static ListNode reverseKGroupByStack(ListNode head, int k){
        Stack<ListNode> stack = new Stack<>();
        ListNode h = head;
        for (int i = 0; i < k; i++) {
            if(h != null){
                stack.push(h);
                h = h.next;
            }else {
                return head;
            }
        }
       ListNode res =  stack.peek();
        ListNode first = stack.pop();
        while (!stack.isEmpty()){
            ListNode t = stack.pop();
            first.next = t;
            first = t;
        }
        first.next = reverseKGroup(h,k);
        return res;
    }

    public static ListNode reverseKGroupT(ListNode head, int k) {
        ListNode root = new ListNode(-1);
        root.next = head;
        ListNode res = root;
        ListNode temp = head;
        int i = 0;
        while (temp != null) {
            i++;
            temp = temp.next;
        }
        while (i >= k) {
            for (int j = 0; j < k - 1; j++) {
                ListNode node = root.next;
                root.next = head.next;
                head.next = root.next.next;
                root.next.next = node;
            }
            root = head;
            head = head.next;
            i -= k;
        }
        return res.next;
    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode root = new ListNode(-1);
        root.next = head;
        ListNode res = root;

        ListNode temp = head;
        int len = 0;
        while (temp != null){
            temp = temp.next;
            len++;
        }

        while (len>=k){
            for (int i = 0; i < k-1; i++) {
                ListNode node = root.next;
                root.next = head.next;
                head.next = root.next.next;
                root.next.next = node;
            }
            root = head;
            head = head.next;
            len = len-k;
        }

        return res.next;
    }
    //反转链表
    public static ListNode reverseByDefault(ListNode head){
        if(head == null) return null;
        ListNode new_h = null;
        while (head!=null){
            ListNode t = head.next;
            head.next = new_h;
            new_h = head;
            head = t;
        }
        return new_h;
    }
    public static ListNode reverseByStack(ListNode head){
        if(head == null) return null;
        Stack<ListNode> stack = new Stack<>();
        while (head!=null){
            stack.push(head);
            head = head.next;
        }
        ListNode new_h = stack.peek();
        ListNode first =  stack.pop();
        while (!stack.isEmpty()){
            first.next = stack.pop();
            first = first.next;
        }
        return new_h;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println(reverseKGroup(head,3).val);
    }
}
