package com.example.algorithm.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//根据先序遍历和中序遍历构建指定的树
public class BuildTreeByPreAndInOrder {

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
        int[] preList={1,2,4,6,7,8,5,3};//先序遍历
        int[] inList = {7,6,8,4,2,5,1,3};//中序遍历
        Node root = buildTree(preList,inList);
        printTree(root);
    }
    //按层遍历打印
    private static void printTree(Node root) {
        if(root == null)return;
        Queue<Node> queue = new LinkedList();
        queue.offer(root);
        int current = 1;
        int next = 0;
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
                System.out.println();
                current = next;
                next = 0;
            }
        }
    }
    public static Node buildTree(int[] preList,int[] inList){
        if(preList.length == 0 || inList.length == 0)
            return null;
        Node root = new Node(preList[0]);
        int index = search(0, inList.length, inList, root.data);
        root.left = buildTree(Arrays.copyOfRange(preList, 1, index + 1),Arrays.copyOfRange(inList, 0, index));
        root.right = buildTree(Arrays.copyOfRange(preList, index + 1, preList.length),Arrays.copyOfRange(inList, index + 1, inList.length));
       return root;
    }

    public static int search(int start, int end, int[] inList, int data) {
        for (int i = start; i < end; i++) {
            if(data == inList[i])
                return i;
        }
        return -1;
    }
}

