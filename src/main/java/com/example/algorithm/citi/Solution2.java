package com.example.algorithm.citi;

import java.util.HashMap;
import java.util.LinkedHashMap;

//求给定字符串中第一个不重复的字符
public class Solution2 {
    public static char getUniqueChar1(String str){
        int[] cnt = new int[256];
        for (int i = 0; i < str.length(); i++) {
            cnt[str.charAt(i)]++;
        }
        for (int i = 0; i < cnt.length; i++) {
            if(cnt[i] == 1)
                return (char)i;
        }
        return (char)0;
    }
    public static char getUniqueChar2(String str){
        HashMap<Character, Boolean> dup = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            dup.put(ch,dup.containsKey(ch));
        }
        for (int i = 0; i < str.length(); i++) {
            if(dup.get(str.charAt(i)) == false){
                return str.charAt(i);
            }
        }
        return (char)0;
    }
    public static char getUniqueChar3(String str){
        LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(map.containsKey(ch)){
               num = map.get(ch)+1;
            }else {
                num = 1;
            }
            map.put(ch,num);
        }
        for(char ch : map.keySet()){
            if(map.get(ch) == 1)
                return ch;
        }
        return (char)0;
    }

    public static void main(String[] args) {
//        System.out.println(getUniqueChar1("ababacadec"));//d
//        System.out.println(getUniqueChar2("ababcefgh"));
        System.out.println(getUniqueChar3("ababcefgh"));
    }
}
