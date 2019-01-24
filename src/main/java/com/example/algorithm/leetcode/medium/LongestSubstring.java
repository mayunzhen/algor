package com.example.algorithm.leetcode.medium;

import java.util.HashMap;

/**
 * 3.Given a string, find the length of the longest substring without repeating characters.
 * Example 1:
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

//Runtime: 102 ms, faster than 16.05% of Java online submissions for Longest Substring Without Repeating Characters.
public class LongestSubstring {

    //Runtime: 25 ms, faster than 85.96% of Java online submissions for Longest Substring Without Repeating Characters.
    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        int maxLength = 0;
        int start = 0;
        for (int index = 0; index < chars.length; index++) {
            if(!map.containsKey(chars[index])) {
                map.put(chars[index], index);
                if(map.size()>maxLength){
                    maxLength = map.size();
                }
            }else {
                int chIndex = map.get(chars[index]);
                for (int i = start; i <= chIndex; i++) {
                    map.remove(chars[i]);
                }
                map.put(chars[index],index);
                start = chIndex+1;
                if(map.size()>maxLength){
                    maxLength = map.size();
                }
            }
        }
        return maxLength;
    }
//Java solution in 9 lines, beat 98%
    public static int lengthOfLongestSubstring1(String s) {
        int start = 0, max = 0;
        for (int i = 1;i < s.length();i++){
            char ch = s.charAt(i);
            int prev= s.indexOf(ch,start);
            if (prev < i && prev >=start){
                max = Math.max(max, i-start);
                start = prev + 1;
            }
        }
        return Math.max(max, s.length()-start);
    }
    public static void main(String[] args) {
        String s = " ";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
