package com.example.algorithm.dynamicprogram;
/*
    动态规划-1
    问题：给定一个整数，求解该整数最少能用多少个Fib数字相加得到
        Fib数列，就是如： 1，1，2，3，5，8，13....
        Fib数列，满足条件：Fib(n)=Fib(n-1)+Fib(n-2)   Fib(0)=1   Fib(1)=1；Fib数字，就是Fib数列中的某个数。
        比如70 = 55+13+2，即一共用了3个fib数字得到
   1.求出所有小于等于N的Fib数字
   2.可以转化为一个"完全0-1背包问题"。
   而对于DP，是先寻找子问题的最优解，然后再做选择。
 */
//https://www.cnblogs.com/hapjin/p/5571352.html 没懂
import java.util.ArrayList;

public class greedyDP {
    //找出fibs中比n小的数
    private static ArrayList<Integer> getFibs(int n) {
        ArrayList<Integer> fibs = new ArrayList<>();
        if(n < 2) return fibs;
        int fib1 = 1;
        int fib2 = 1;
        int fibn;
        fibs.add(fib1);
        fibs.add(fib2);
        while ((fibn = fib1+fib2)<n){
            fibs.add(fibn);
            fib1 = fib2;
            fib2 = fibn;
        }
        return fibs;
    }
}
