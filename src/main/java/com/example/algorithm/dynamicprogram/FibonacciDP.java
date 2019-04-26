package com.example.algorithm.dynamicprogram;

public class FibonacciDP {
    public static int dp_fibonacci(int n){
        if(n <= 0)
            return n;
        int[] m = new int[n+1];
        m[0] = 0;
        m[1] = 1;
        for (int i = 2; i < m.length; i++) {
            m[i] = m[i-1]+m[i-2];
        }
        return m[n];
    }
    public static int rec_fibonacci(int n){
        if(n <= 0 )
            return 0;
        if(n == 1 || n == 2)
            return 1;
        return rec_fibonacci(n-1)+rec_fibonacci(n-2);
    }
    public static void main(String[] args) {
        System.out.println(rec_fibonacci(5));
        System.out.println(dp_fibonacci(5));
    }
}
