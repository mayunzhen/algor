package com.example.algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        helper("",res,n,0,0);
        return res;
    }
    public static void helper(String current,List<String> res,int n,int left,int right){
        if(left < right)
            return;
        if(left == n && right == n){
            res.add(current);
            return;
        }
        if(left < n){
            helper(current+"(",res,n,left+1,right);
        }
        if(right < n){
            helper(current+")",res,n,left,right+1);
        }

    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
