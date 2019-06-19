package com.example.algorithm.leetcode.medium;

public class SwapNodesinPairs {
    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = new ListNode(-1);
        ListNode h = head;
        ListNode next = head.next;

        ListNode new_h = next;
        while (h != null && h.next != null) {
            next = h.next;
            ListNode t = next.next;

            pre.next = next;
            next.next = h;
            h.next = t;

            pre = h;
            h = t;
        }

//        ListNode next = head.next;
//        head.next = swapPairs(next.next);
//        next.next = head;
        return new_h;
    }
    public static void main(String[] args) {
        //Given 1->2->3->4, you should return the list as 2->1->4->3.
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode head_new = swapPairs(head);
        System.out.println(head_new.val);
    }
}
