package com.example.algorithm.tree;

public class BinarySearchTree {
   private static class Node{
        int data;
        Node left;
        Node right;

       public Node(int data) {
           this.data = data;
       }
   }
   public static Node findMax(Node root){
       if(root == null)
           return null;
       if(root.right == null)
           return root;
       else
           return findMax(root.right);
   }
   public static Node findMin(Node root){
       if(root == null)return null;
       if(root.left == null)
           return root;
       else
           return findMin(root.left);
   }
   public static Node insert(Node root ,int data){
       if(root == null)
           return new Node(data);
       if(root.data > data)
           root.left = insert(root.left,data);
       else if(root.data < data)
          root.right = insert(root.right,data);
       return root;
   }
   private static int getHeight(Node root){
       if(root == null)// 叶子节点的高度为0,空树的高度为1
           return -1;
       return Math.max(getHeight(root.left)+1, getHeight(root.right)+1);
   }
}
