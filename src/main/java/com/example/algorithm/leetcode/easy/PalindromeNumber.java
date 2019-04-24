package com.example.algorithm.leetcode.easy;

public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        String str = String.valueOf(x);
        for (int i = 0; i <= (str.length()-1)/2; i++) {
            if(str.charAt(i) != str.charAt(str.length()-1-i)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome(101));
    }
}
