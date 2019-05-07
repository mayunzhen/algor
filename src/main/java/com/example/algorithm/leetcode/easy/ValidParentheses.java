package com.example.algorithm.leetcode.easy;

import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
        if(s.equals(""))
            return true;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '[' || c == '{' || c == '('){//正向
                stack.push(c);
            }else if(c == ']' || c == '}' || c == ')'){//反向
                if(stack.isEmpty()) return false;
                char st = stack.pop();
                if(st != '[' && c == ']') return false;
                if(st != '{' && c == '}') return false;
                if(st != '(' && c == ')') return false;
            }
        }

        if(stack.isEmpty())
            return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
    }
}
