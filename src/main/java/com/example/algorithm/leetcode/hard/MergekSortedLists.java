package com.example.algorithm.leetcode.hard;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergekSortedLists {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> heap = new PriorityQueue(new Comparator<ListNode>(){
            @Override public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });
        ListNode head = new ListNode(0), tail = head;
        for (ListNode node : lists) {
            if (node != null)
                heap.offer(node);
        }
        while (!heap.isEmpty()) {
            tail.next = heap.poll();
            tail = tail.next;
            if (tail.next != null)
                heap.offer(tail.next);
        }
        return head.next;
    }

    public static void main(String[] args) {
        /*
        [
            1->4->5,
            1->3->4,
            2->6
        ]
         */
        ListNode h1 = new ListNode(1);
        ListNode h2 = new ListNode(4);
        ListNode h3 = new ListNode(5);
        h1.next = h2;
        h2.next = h3;

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;

        ListNode w1 = new ListNode(2);
        ListNode w2 = new ListNode(6);
        w1.next = w2;
        ListNode[] listNodes = new ListNode[3];
        listNodes[0] = h1;
        listNodes[1] = n1;
        listNodes[2] = w1;
        listNodes = new ListNode[1];
        ListNode node = null;
        listNodes[0] = node;
        ListNode head = mergeKLists(listNodes);
        System.out.println();
        while (head!= null){
            System.out.print(head.val +" ");
            head = head.next;
        }
        System.out.println();
    }
}
