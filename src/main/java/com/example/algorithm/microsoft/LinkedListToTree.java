package com.example.algorithm.microsoft;

//链表转为二叉搜索树
public class LinkedListToTree {
    static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
        public TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
    static class ListNode{
        int value;
        ListNode next;
    }
    public static TreeNode ToTree(ListNode head){
        if(head == null) return null ;
        TreeNode root = helper(head,null);
        return root;
    }
    public static TreeNode helper(ListNode head, ListNode tail){
        if(head == null || head == tail) return null;

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != tail && fast.next.next != tail){
            slow = slow.next;
            fast = fast.next;
        }
        TreeNode leftNode = helper(head,slow);
        TreeNode rightNode = helper(slow.next,tail);
        TreeNode treeNode = new TreeNode(slow.value,leftNode,rightNode);
        return treeNode;
    }
    public static void main(String[] args) {

    }
}
