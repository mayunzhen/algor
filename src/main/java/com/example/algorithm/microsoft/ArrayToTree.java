package com.example.algorithm.microsoft;
//有序数组转为二叉搜索树
public class ArrayToTree {
    static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
    public static Node sortedArrayToTree(int[] nums, int left, int right) {
        if (nums == null && nums.length == 0) return null;
        if(left > right )return null;
        if (right-left == 0)
            return new Node(nums[left], null, null);
        int mid = (left+right)/2;
        Node leftNode = sortedArrayToTree(nums,left,mid-1);
        Node rightNode = sortedArrayToTree(nums,mid+1,right);

        return new Node(nums[mid],leftNode,rightNode);
    }

    public static void main(String[] args) {
    int[] nums = {-10,-3,0,5,9};
       Node root = sortedArrayToTree(nums,0,nums.length-1);
        System.out.println(root.value);
    }
}
