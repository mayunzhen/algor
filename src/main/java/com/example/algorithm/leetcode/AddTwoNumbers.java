package com.example.algorithm.leetcode;

/**
 2.You are given two non-empty linked lists representing two non-negative integers.
 The digits are stored in reverse order and each of their nodes contain a single digit.
 Add the two numbers and return it as a linked list.
 You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 Example:
 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 Explanation: 342 + 465 = 807.
 */

//  Definition for singly-linked list.
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }
public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(-1);
        ListNode prev = pre;
        int carray = 0;//进位
        while (l1 != null || l2 != null){
            int val1 = 0;
            int val2 = 0;
            if(l1 != null){
                val1 = l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
               val2 = l2.val;
               l2 = l2.next;
            }
            int current = val1 + val2 + carray;
            if(current >= 10) carray = 1;
            else carray = 0;
            current = current%10;
            ListNode node = new ListNode(current);
            prev.next = node;
            prev = prev.next;
        }
        if(carray == 1){
            ListNode node = new ListNode(1);
            prev.next = node;
        }
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(0);
        node1.next = node2;
        node2.next = node3;

        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(1);
        ListNode node6 = new ListNode(0);
        node4.next = node5;
        node5.next = node6;

        ListNode nodeRes = addTwoNumbers(node1,node4);
        while (nodeRes != null){
            System.out.print(nodeRes.val);
            nodeRes = nodeRes.next;
            if(nodeRes != null){
                System.out.print("->");
            }
        }
    }
}
