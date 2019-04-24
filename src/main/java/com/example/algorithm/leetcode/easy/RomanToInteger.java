package com.example.algorithm.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RomanToInteger {
    public static int romanToInt(String s) {
        Character[] priChar = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        List<Character> roman = new ArrayList<Character>(Arrays.asList(priChar));
        Integer[] n = {1, 5, 10, 50, 100, 500, 1000};
        List<Integer> nums = new ArrayList<>(Arrays.asList(n));


        return 0;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("IV"));
    }
}
