package com.example.algorithm.leetcode.medium;

import java.util.*;

public class LetterCombinationsPhoneNumber {
    public static List<String> letterCombinations(String digits) {
       List<String> result = new ArrayList<>();
       if(digits.equals("")) return result;
        result.add("");
       List<String> map = new ArrayList<>();
       map.add("");
       map.add("1");
       map.add("abc");
       map.add("def");
       map.add("ghi");
       map.add("jkl");
       map.add("mno");
       map.add("pqrs");
       map.add("tuv");
       map.add("wxyz");

        for (char digit : digits.toCharArray()) {// 2
            List<String> tmp = new ArrayList<>();
            for (char ch : map.get(digit-'0').toCharArray()) {//a b c
                for (String res : result) {
                    tmp.add(res+ch);
                }
            }
            result = tmp;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
