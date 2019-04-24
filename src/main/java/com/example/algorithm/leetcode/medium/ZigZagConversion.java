package com.example.algorithm.leetcode.medium;

public class ZigZagConversion {
    public static String convert(String s, int numRows) {
        StringBuffer[] sbs = new StringBuffer[numRows];
        for (int i = 0; i < numRows; i++) {
            sbs[i] = new StringBuffer();
        }

        int i = 0;
        while (i< s.length()){
            for (int idx = 0; idx < numRows && i < s.length(); idx++) {
                sbs[idx].append(s.charAt(i++));
            }
            for (int idx = numRows-2; idx >= 1 && i < s.length() ; idx--) {
                sbs[idx].append(s.charAt(i++));
            }
        }
        for (int j = 1; j < numRows; j++) {
            sbs[0].append(sbs[j]);
        }
        return sbs[0].toString();
    }
    public static void main(String[] args) {
        String s = "ABCDEFGHIJ";
        int numRows = 4;
        System.out.println(convert(s,numRows));
    }
}
