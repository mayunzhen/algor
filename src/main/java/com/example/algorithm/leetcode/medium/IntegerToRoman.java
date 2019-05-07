package com.example.algorithm.leetcode.medium;
// I 1
// V 5
// X 10
// L 50
// C 100
// D 500
// M 1000
// IV 4
//IZ 9
// ZL 40
// ZC 90
public class IntegerToRoman {
    public static String intToRoman(int num) {
        StringBuffer stringBuffer = new StringBuffer();
    int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    String[] numerals = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        for (int i = 0; i < values.length ; i++) {
            while (num >= values[i]) {
                num -= values[i];
                stringBuffer.append(numerals[i]);
            }
        }
    return stringBuffer.toString();
    }
    public static int romanToInt(String num) {
        int res = 0;
        if(num.contains("CM")) res -= 200;
        if(num.contains("CD")) res -= 200;
        if(num.contains("XC")) res -= 20;
        if(num.contains("XL")) res -= 20;
        if(num.contains("IX")) res -= 2;
        if(num.contains("IV")) res -= 2;
        for (char c: num.toCharArray()){
            if(c == 'M') res +=1000;
            if(c == 'D') res +=500;
            if(c == 'C') res +=100;
            if(c == 'L') res +=50;
            if(c == 'X') res +=10;
            if(c == 'V') res +=5;
            if(c == 'I') res +=1;
        }
        return res;
    }
    public static void main(String[] args) {
        int data = 445;
        System.out.println(intToRoman(data));
        System.out.println("------------------------");
        System.out.println(romanToInt("MCMXCIV"));
    }
}
