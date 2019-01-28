package com.example.algorithm.tree;

import java.util.Random;
import java.util.Stack;
//https://www.cnblogs.com/hapjin/p/5679482.html
public class TreeDemo {
    private static final Random random = new Random();//insert left or right
    private static class Node{
        private int data;
        private Node left;
        private Node right;
        private boolean isVisited;

        public Node(int data) {
            this.data = data;
            left = right = null;
            isVisited = false;
        }
    }
    private Node root;//二叉树的根结点
    //随机构建二叉树
    public void buildTree(){
        int[] nodes = {3,0,7,4,9,10,45};
        for (int node:nodes) {
            insert(node);
        }
    }
    //插入节点
    public Node insert(int node) {
        return root = insert(root,node);
    }

    public Node insert(Node root, int node) {
        if(root == null){
            root = new Node(node);
            return root;
        }
        if(random.nextInt()%2 == 0)
            root.right = insert(root.right,node);
        else
            root.left = insert(root.left,node);
        return root;
    }
    //中序非递归遍历
    public void nonRecurInTraverse(){
        if(root == null)return;
        nonRecurInTraverse(root);
    }
    //中序非递归遍历
    public void nonRecurInTraverse(Node root) {
        Node current = root;
        Stack<Node> stack = new Stack<>();
        while (current != null || !stack.isEmpty()){
            while (current!=null){
                stack.push(current);
                current = current.left;
            }
            if(!stack.isEmpty()){
                Node tmp = stack.pop();
                System.out.println(tmp.data);
                current = tmp.right;
            }
        }
    }
    //中序递归遍历
    public void inorder(){
        inorder(root);
    }

    public void inorder(Node root) {
        if(root != null){
            inorder(root.left);
            System.out.println(root.data);
            inorder(root.right);
        }
    }
    //先序非递归遍历
    public void nonRecurPreTraverse(){
        if(root == null)
            return;
        nonRecurPreTraverse(root);
    }
    //先序非递归遍历
    public void nonRecurPreTraverse(Node root) {
        Node current = root;
        Stack<Node> stack = new Stack<>();
        while (current != null || !stack.empty()){
           while (current != null){
               System.out.println(current.data);
               stack.push(current);
               current = current.left;
           }
            if(!stack.isEmpty()){
               Node tmp = stack.pop();
                current = tmp.right;
            }
        }
    }
    //后序非递归遍历
    public void nonRecurPostTraverse(){
        if(root == null)
            return;
        nonRecurPostTraverse(root);
    }
    //后序非递归遍历
    public void nonRecurPostTraverse(Node root) {
        Node current = root;
        Stack<Node> stack = new Stack<>();
        while (current != null || !stack.isEmpty()){
            while (current != null){
                stack.push(current);
                current = current.left;
            }
            if(!stack.isEmpty()){
                Node first = stack.peek();
                if(first.isVisited == false){
                    first.isVisited = true;
                    current = current.right;
                }else {
                    Node tmp = stack.pop();
                    System.out.println(tmp.data);
                    current = current.right;
                }
            }
        }
    }
    //后序递归遍历
    public void postOrder(){
        postOrder(root);
    }
    //后序递归遍历
    public void postOrder(Node root) {
        if(root == null)return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data);
    }
}
