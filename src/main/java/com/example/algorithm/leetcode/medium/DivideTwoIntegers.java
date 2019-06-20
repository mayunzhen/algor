package com.example.algorithm.leetcode.medium;

public class DivideTwoIntegers {
    //两数相乘
    public static int multi(int a, int b){
        if(b > a ){
            int t = a;
            a = b;
            b = t;
        }
        int res = 0;
        while (b > 0){
            b--;
            res = a + res;
        }
        return res;
    }
    //两数相除
    public static int divide(int dividend, int divisor) {
        int ans = 0;
        int sign = (dividend < 0 ^ divisor < 0) ? -1 : 1;
        // corner case for the overflow
        if (divisor == 1) {
            return dividend;
        } else if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            } else {
                dividend = Integer.MAX_VALUE - Math.abs(divisor) + 1;
                ans ++;
            }
        }
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        while (dividend >= divisor) {
            int temp = divisor, shift = 0;
            // in case that the temp will overflow
            while (temp <= Integer.MAX_VALUE >> 1 && temp << 1 <= dividend) {
                temp = (temp << 1);
                shift ++;
            }
            ans += (1 << shift);
            dividend -= temp;
        }
        return sign * ans;
    }
    public static void main(String[] args) {
//        System.out.println(divide(2147483647,-1));
        System.out.println(multi(3,50));
    }
}
