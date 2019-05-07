package com.example.algorithm.leetcode.easy;

/**
 Given a 32-bit signed integer, reverse digits of an integer.

 Example 1:

 Input: 123
 Output: 321
 Example 2:

 Input: -123
 Output: -321
 Example 3:

 Input: 120
 Output: 21
 */
public class ReverseInteger {
    public static int reverse(int number) {
        int rev = 0;
        while (number != 0){
            int newrev = rev*10 + number%10;
            if((newrev - number%10)/10 != rev) return 0;
            rev = newrev;
            number/=10;
        }
        return rev;
    }
    public static void main(String[] args) {
        int number = -123;
        System.out.println(reverse(number));
    }
}
