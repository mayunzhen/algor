package com.example.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

public class isSameTree {
    private static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    public static Node buildTree1(int[] arr) {
        Node root = new Node(arr[0]);
        Node node2 = new Node(arr[1]);
        Node node3 = new Node(arr[2]);
        Node node4 = new Node(arr[3]);
        Node node5 = new Node(arr[4]);
        Node node6 = new Node(arr[5]);
        Node node7 = new Node(arr[6]);
        Node node8 = new Node(arr[7]);
        root.left = node2;
        root.right = node3;

        node2.left = node4;
        node2.right = node5;

        node4.left = node6;

        node6.left = node7;
        node6.right = node8;

        return root;
    }
    public static Node buildTree2(int[] arr) {
        Node root = new Node(arr[0]);
        Node node2 = new Node(arr[1]);
        Node node3 = new Node(arr[2]);
        Node node4 = new Node(arr[3]);
        Node node5 = new Node(arr[4]);
        Node node6 = new Node(arr[5]);
        Node node7 = new Node(arr[6]);
        Node node8 = new Node(arr[7]);
        root.left = node2;
        root.right = node3;

        node2.left = node4;
        node2.right = node5;

        node4.left = node6;

        node6.left = node7;
        node6.right = node8;

        return root;
    }
    public static Node buildTree3(int[] arr) {
        Node root = new Node(arr[0]);
        Node node2 = new Node(arr[1]);
        Node node3 = new Node(arr[2]);
        Node node4 = new Node(arr[3]);
        Node node5 = new Node(arr[4]);
        Node node6 = new Node(arr[5]);
        Node node7 = new Node(arr[6]);
        Node node8 = new Node(arr[7]);
        Node node9 = new Node(arr[8]);
        root.left = node2;
        root.right = node3;

        node2.left = node4;
        node2.right = node5;

        node4.left = node6;
        node4.right = node9;

        node6.left = node7;
        node6.right = node8;

        return root;
    }
    //按层打印树
    private void printTree(Node root){
        if(root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int current = 1;
        int next = 0;
        while (!queue.isEmpty()){
            Node tmp = queue.poll();
            System.out.print(tmp.data+" ");
            current--;
            if(tmp.left != null){
                queue.offer(tmp.left);
                next++;
            }
            if(tmp.right != null){
                queue.offer(tmp.right);
                next++;
            }
            if(current == 0){
                System.out.println();//换行
                current = next;
                next = 0;
            }
        }
    }
    private static boolean isSameTree(Node root1, Node root2){
        //树的结构不一致
        if((root1 != null && root2 == null) || (root1 == null && root2 != null))
            return false;
        //两棵树最终递归到终点时
        if(root1 == null && root2 == null) return true;
        if(root1.data != root2.data){
            return false;
        }else {
            return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        buildTree1(arr);
        int[] arr3 = {1, 2, 3, 4, 5, 6, 7, 8,9};
        Node root1 = buildTree1(arr);
//        Node root2 = buildTree2(arr);
        Node root3 = buildTree3(arr3);
//        System.out.println(isSameTree(root1,root2));
        System.out.println(isSameTree(root1,root3));
    }
}
