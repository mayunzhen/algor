package com.example.algorithm.primaryalgor;
//http://www.cnblogs.com/skywang12345/p/3597597.html
public class ShellSort {
    public static void main(String[] args) {
        int a[] = {80,30,60,40,20,10,50,70};
        System.out.println("before sort:");
         for (int i=0; i<a.length; i++){
             System.out.print(a[i]+" ");
         }
        System.out.println();
        shellSort(a);
        System.out.println("after sort:");
        for (int i=0; i<a.length; i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    public static void shellSort(int[] a) {
        // gap为步长，每次减为原来的一半。
        for (int gap = a.length/2; gap > 0 ; gap/=2) {
            // 共gap个组，对每一组都执行直接插入排序
            for (int i = 0; i < gap; i++) {
                for (int j = i+gap; j < a.length; j+=gap) {
                    // 如果a[j] < a[j-gap]，则寻找a[j]位置，并将后面数据的位置都后移。
                    if(a[j] < a[j-gap]){
                        int tmp = a[j];
//                        int k = j-gap;
//                        while (k >= 0 && a[k] > tmp){
//                            a[k+gap] = a[k];
//                            k -= gap;
//                        }
                        int l;
                        for (l = j-gap; l >=0 && a[l]>tmp; l-=gap) {
                            a[l+gap] = a[l];
                        }
                        a[l + gap] = tmp;
                    }
                }
            }
        }
    }
}
