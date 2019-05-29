package com.example.algorithm.leetcode.easy;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class leetcode110 {
    public static boolean isBalanced(TreeNode root){
        if(root == null)return true;
        int left = getHeight(root.left);
        int right = getHeight(root.right);

        if(Math.abs(left-right) >1)
            return false;
        else
            return isBalanced(root.left) && isBalanced(root.right);
    }
    public static int getHeight(TreeNode root){
       if(root == null) return 0;
       int leftDepth = 0;
       int rightDepth = 0;
       if(root.left != null)
           leftDepth = getHeight(root.left);
       if(root.right != null)
           rightDepth = getHeight(root.right);

       return Math.max(leftDepth,rightDepth)+1;
    }
    public static void main(String[] args) {

    }
}
