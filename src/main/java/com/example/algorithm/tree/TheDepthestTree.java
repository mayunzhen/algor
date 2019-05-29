package com.example.algorithm.tree;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class TheDepthestTree {
    public static int maxDepth(TreeNode root){
        if(root == null) return 0;
        int leftTree = 0;
        int rightTree = 0;
        if(root.left != null)
            leftTree = maxDepth(root.left);
        if(root.right != null)
            rightTree = maxDepth(root.right);
        return 1 + Math.max(leftTree,rightTree);
    }
    public static void main(String[] args) {

    }
}
