package com.example.algorithm.tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
//https://www.cnblogs.com/hapjin/p/5565221.html
public class ExpectedSumPath {
    private static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        Node root = buildTree(arr);
        //按层打印
        printTree(root);
        findExpectedSumPath(root,8);

    }
    public static void findExpectedSumPath(Node root, int target){
        if(root == null)return;
        LinkedList<Node> stack = new LinkedList<>();
        int currentSum = 0;
        findExpectedSumPath(root,target,currentSum,stack);
    }

    public static void findExpectedSumPath(Node root, int target, int currentSum, LinkedList<Node> stack) {
        currentSum += root.data;
        stack.push(root);
        boolean isLeaf = root.left == null && root.right == null;

        if(currentSum == target && isLeaf){
            Iterator<Node> iterator = stack.descendingIterator();
            while (iterator.hasNext()){
                System.out.print(iterator.next().data+" ");
            }
            System.out.println();
        }

        //当currentSum > expectedSum时 再往下递归没有意义了
        if(currentSum < target) {
            if (root.left != null)
                findExpectedSumPath(root.left, target, currentSum, stack);
            if (root.right != null)
                findExpectedSumPath(root.right, target, currentSum, stack);
        }
        stack.pop();//当某结点左右孩子均为null时, 回退
    }

    public static Node buildTree(int[] arr) {
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
    private static void printTree(Node root) {
        if(root == null)return;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int current = 1;//当前层还没遍历的节点个数
        int next = 0;//下一层需要遍历的节点个数
        while (!queue.isEmpty()){
            Node tmp = queue.poll();
            System.out.print(tmp.data+" ");
            current --;

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
}
