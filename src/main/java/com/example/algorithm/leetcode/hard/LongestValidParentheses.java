package com.example.algorithm.leetcode.hard;

import java.util.Stack;

public class LongestValidParentheses {
    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        if (s.length() == 1)
            return 0;
        stack.push(-1);
        int maxAns = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')' && stack.peek() != -1 && s.charAt(stack.peek()) == '(') {
                stack.pop();
                maxAns = Math.max(maxAns, i - stack.peek());
            } else {
                stack.push(i);
            }
        }
        return maxAns;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses(")()())"));
    }
}
