package com.example.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class BalanceBinaryTree {
    private static Random random = new Random();

    private static class Node {
        public int data;
        public Node left;
        public Node right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    private Node root;

    public void buildTree() {
        int[] nodes = {3, 0, 7, 4, 8};
        for (int node : nodes) {
            insert(node);
        }
    }

    public Node insert(int node) {
        return root = insert(root, node);
    }

    public Node insert(Node root, int node) {
        if (root == null) {
            return new Node(node);
        }
        if (random.nextInt() % 2 == 0)
            root.left = insert(root.left, node);
        else
            root.right = insert(root.right, node);
        return root;
    }

    //求解二叉树的高度
    public int getHeight(Node root) {
        if (root == null) return 0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    //判断二叉树是否为平衡二叉树
    public boolean isBalance() {
        return isBalance(root);
    }

    public boolean isBalance(Node root) {
        if (root == null) return true;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        } else {
            return isBalance(root.right) && isBalance(root.left);
        }
    }

    //print binary tree in level
    public void printTree() {
        if (root == null)
            return;
        printTree(root);
    }

    //按层打印二叉树,每行打印一层
    private static void printTree(Node root) {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int current = 1;//当前层 还未打印的结点个数
        int next = 0;//下一层结点个数
        while (!queue.isEmpty()){
            Node node = queue.poll();
            System.out.print(node.data+" ");
            current--;

            if(node.left != null){
                queue.offer(node.left);
                next++;
            }
            if(node.right != null){
                queue.offer(node.right);
                next++;
            }
            if(current == 0){
                System.out.println();
                current = next;
                next = 0;
            }
        }
    }

    public static void main(String[] args) {
        BalanceBinaryTree balanceBinaryTree = new BalanceBinaryTree();
        balanceBinaryTree.buildTree();
        balanceBinaryTree.printTree();
    }


}
