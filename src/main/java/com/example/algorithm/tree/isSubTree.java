package com.example.algorithm.tree;

import java.util.LinkedList;

//比较两棵二叉树--（比较两棵二叉树是否相同/判断一棵二叉树是否是另一棵二叉树的子树）
//http://www.cnblogs.com/hapjin/p/5559688.html
public class isSubTree {
    private static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    //判断 以root2为根的树是否是 root1 为根的树 的 子树
    public static boolean isSubTree(Node root1, Node root2){
        boolean result = false;
        if(root2 == null) return true;
        if(root1 == null) return false;

        if(root1 != null && root2 != null){
            result = hasSameNode(root1,root2);
            if(!result)
                result = isSubTree(root1.left,root2);
            if(!result)
                result = isSubTree(root1.right,root2);
        }
       return result;
    }
    //比较两棵树是否有相同的结点(也是判断root1和root2是否相同)  先序遍历
  private static boolean hasSameNode(Node root1, Node root2){
      if(root2 == null) return true;
      if(root1 == null) return false;

      if(root1.data != root2.data)
          return false;
      return hasSameNode(root1.left,root2.left) && hasSameNode(root1.right,root2.right);
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

        root.left = node2;
        root.right = node3;

        node2.left = node2;
        node2.right = node5;

        node2.left = node6;

        return root;
    }
    //按层打印树
    public static void printTree(Node root){
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);
        int current = 1;
        int next = 0;
        while (!queue.isEmpty()){
           Node tmp = queue.pop();
            System.out.print(tmp.data+" ");
            current--;
            if (tmp.left != null){
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

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        Node root1 = buildTree1(arr);
        Node root2 = buildTree2(arr);
        printTree(root1);
        System.out.println();
        printTree(root2);
        System.out.println(isSubTree(root1,root2));
    }


}
