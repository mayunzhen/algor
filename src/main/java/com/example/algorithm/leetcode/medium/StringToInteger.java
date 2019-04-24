package com.example.algorithm.leetcode.medium;

public class StringToInteger {
    public static int myAtoi(String str) {
        int sign = 1,i = 0,r = 0;
        str = str.trim();
        if(str.equals("")){
            return 0;
        }else if(str.charAt(i) == '-'){
            i++;
            sign = -1;
        }else if(str.charAt(i) == '+'){
            i++;
        }
        while (i < str.length() && Character.isDigit(str.charAt(i))){
            int d = str.charAt(i)-'0';
            if(r > (Integer.MAX_VALUE-d)/10)
                return sign == 1? Integer.MAX_VALUE:Integer.MIN_VALUE;
            r = r*10+d;
            i++;
        }
        return r*sign;
    }
    public static void main(String[] args) {
        System.out.println(myAtoi("-123"));
    }
}
