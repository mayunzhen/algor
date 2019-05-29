package com.example.algorithm.microsoft;

import java.util.ArrayList;
import java.util.LinkedList;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class TreePrint {
    public static void main(String[] args) {
        int[][] test = new int[5][5];
        test[0][0] = 1;
        test[0][1] = 2;
        System.out.print(test[0][0]);
    }

    public int[][] printTree(TreeNode root) {
        // 判断是否为空
        if (root == null) {
            throw new IllegalArgumentException();
        }
        // 暂存节点值
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode tmp = new TreeNode(0);
        // 载入根节点
        queue.add(root);
        // 本行末
        int last = queue.getFirst().val;
        // 下一行末
        int nlast = 0;
        // 打印信息
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> res_1 = new ArrayList<Integer>();

        while (!queue.isEmpty()) {
            // 根节点出队
            tmp = queue.removeFirst();
            res_1.add(tmp.val);
            if (tmp.left != null) {
                queue.add(tmp.left);
                nlast = queue.getLast().val;
            }
            if (tmp.right != null) {
                queue.add(tmp.right);
                nlast = queue.getLast().val;
            }
            // 到达行末
            if (tmp.val == last) {
                res.add(res_1);
                res_1 = new ArrayList<Integer>();
                last = nlast;
            }
        }
        int[][] printer = new int[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            printer[i] = new int[res.get(i).size()];
            for (int j = 0; j < printer[i].length; j++) {
                printer[i][j] = res.get(i).get(j);
            }
        }
        return printer;
    }
    }

