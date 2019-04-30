package com.example.algorithm.leetcode.easy;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length <= 0) return "";

        for (int i = 0; i < strs[0].length(); i++) {//flower
            for (int j = 1; j < strs.length; j++) {// flight
                if(i >= strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i))
                    return strs[j].substring(0,i);
            }
        }
        return strs[0];
    }



    public static void main(String[] args) {
        String[] strs ={"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}
