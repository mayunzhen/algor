package com.example.algorithm.citi;

public class Solution1 {
    // x mod 3 余 1 ; x mod 4 余 2 ;求X
    // 3k+1 = X; 4m+2 = X
    public static int getX(){
        for (int k = 0; k < Integer.MAX_VALUE; k++) {
            int X = 3*k+1;
            if(X%4 == 2)
                return X;
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(getX());
    }
}
