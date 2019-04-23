package com.example.algorithm.leetcode.medium;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s){
        char[] chs = s.toCharArray();
        int N = chs.length;
        HashSet<Character> set = new HashSet<>();
        int i = 0,l = 0;
        int maxLen = 0;
        while (i < N){
            while (set.contains(chs[i])){
                set.remove(chs[l]);
                l++;
            }
            set.add(chs[i]);
            maxLen = Math.max(maxLen,set.size());
            i++;
        }
        return maxLen;
    }
    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
