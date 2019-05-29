package com.example.algorithm.microsoft;
class BSTreeNode{
    int val;
    BSTreeNode left;
    BSTreeNode right;

    public BSTreeNode(int val, BSTreeNode left, BSTreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class DoubleLinkedList {
    private static BSTreeNode head,tail;
    public static void traverseMid(BSTreeNode root){
        if(root == null){
            return;
        }
        traverseMid(root.left);
        changeNode(root);
        traverseMid(root.right);
    }
    public static void changeNode(BSTreeNode root){
        //初始时，双向链表中无节点，head及tail均为null
        if(head == null){
            head = root;
            tail = root;
        }else {
            //将新node的左指针指向当前tail,再将当前tail的右指针指向新node，最后将tail后移
            root.left = tail;
            tail.right = root;
            tail = root;
        }
    }
    public static void PrintHead(BSTreeNode head){
        System.out.println("PrintHead--");
        while (head != null){
            System.out.print(head.val+" ");
            head = head.right;
        }
        System.out.println();
    }
    public static void PrintTail(BSTreeNode tail){
        System.out.println("PrintTail--");
        while (tail != null){
            System.out.print(tail.val+" ");
            tail = tail.left;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        BSTreeNode node1 = new BSTreeNode(4,null,null);
        BSTreeNode node2 = new BSTreeNode(8,null,null);
        BSTreeNode node3 = new BSTreeNode(12,null,null);
        BSTreeNode node4 = new BSTreeNode(16,null,null);
        BSTreeNode node5 = new BSTreeNode(6,node1,node2);
        BSTreeNode node6 = new BSTreeNode(14,node3,node4);
        BSTreeNode node7 = new BSTreeNode(10,node5,node6);
        traverseMid(node7);
        System.out.println("双向链表从头结点向后遍历:");
        PrintHead(node1);
        System.out.println("双向链表从尾结点向前遍历:");
        PrintTail(node4);

    }
}
