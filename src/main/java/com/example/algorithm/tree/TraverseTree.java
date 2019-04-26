package com.example.algorithm.tree;

import java.util.LinkedList;
import java.util.Stack;

class Nodex{
    int data;
    Nodex left = null;
    Nodex right = null;

    public Nodex(int data) {
        this.data = data;
    }
}

public class TraverseTree {
   public static Nodex CreateTree(int[] arr){
       LinkedList<Nodex> linkedList = new LinkedList<>();
       for (int i = 0; i < arr.length; i++) {
        linkedList.add(new Nodex(arr[i]));
       }
       //最后一个父节点在数组中的索引
       int lastParentIndex = arr.length/2-1;
       for (int i = 0; i < lastParentIndex; i++) {
            linkedList.get(i).left = linkedList.get(2*i+1);
            linkedList.get(i).right = linkedList.get(2*i+2);
       }
       // 最后一个父节点:因为最后一个父节点可能没有右孩子，所以单独拿出来处理
       // 左孩子
       linkedList.get(lastParentIndex).left = linkedList.get(2*lastParentIndex+1);
       if(arr.length%2 == 1)
           linkedList.get(lastParentIndex).right = linkedList.get(2*lastParentIndex+2);
    return linkedList.get(0);
   }
   //前序遍历  深度遍历
   //中序遍历  深度遍历
   //后序遍历  深度遍历
   public static void preTraverse(Nodex root){
       if(root == null) return;
            System.out.print(root.data+" ");
       if(root.left != null)
           preTraverse(root.left);
       if(root.right != null)
           preTraverse(root.right);
   }
   public static void noRecTraverse(Nodex root){
       if(root == null)return;
       Nodex t = root;
       Stack<Nodex> stack = new Stack<>();
        while (t != null){
            System.out.println(t.data);
            stack.push(t);
            

        }
   }
   //层次遍历
    public static void levelTraverse(Nodex root){

    }

   public static int getTreeHeight(Nodex root){
       if(root == null)return 0;
       if(root.left == null && root.right == null)
           return 1;
       int leftheight = 0;
       int rightheight = 0;
       if(root.left != null)
           leftheight = getTreeHeight(root.left);
       if(root.right != null)
           rightheight = getTreeHeight(root.right);
       return 1+Math.max(leftheight,rightheight);
   }
    public static void main(String[] args) {
       int[] arr = {1,2,3,4,5,6,7,8,9};
       Nodex root = CreateTree(arr);
        preTraverse(root);
        System.out.println();
        System.out.println(getTreeHeight(root));

    }
}
