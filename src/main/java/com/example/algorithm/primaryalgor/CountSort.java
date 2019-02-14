package com.example.algorithm.primaryalgor;
//计数排序  桶排序是计数排序的升级版  https://www.cnblogs.com/developerY/p/3166462.html
public class CountSort {
    public static void comparisonCountingSort(int[] A) {
        int[] temp = new int[A.length];
        int[] count = new int[A.length];

        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] < A[j])
                    count[j]++;
                else
                    count[i]++;
            }
        }
        for(int i = 0;i < A.length;i++)
            temp[count[i]] = A[i];
        for(int i = 0;i < A.length;i++)
            A[i] = temp[i];
        return;
    }

    public static void main(String[] args) {
        int[] A = {2,5,3,0,2,3,0,3};
//        int[] A = {8,8,8,8,8};
        comparisonCountingSort(A);
        for(int i = 0;i < A.length;i++)
            System.out.print(A[i]+" ");
        System.out.println();
    }
}
