package com.example.algorithm.primaryalgor;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr={1,3,2,45,65,33,12};
        System.out.println("交换之前：");
        for(int num:arr){
            System.out.print(num+" ");
        }
        System.out.println("--");
        SelectSort(arr);
        for(int num:arr){
            System.out.print(num+" ");
        }
        System.out.println("--");
        //选择排序的优化
        for (int i = 0; i < arr.length-1; i++) {// 做第i趟排序
            int k = i;
            for (int j = i; j < arr.length; j++) {// 选最小的记录
                if(arr[k]>arr[j]){
                    k = j;//记下目前找到的最小值所在的位置
                }
            }
            //在内层循环结束，也就是找到本轮循环的最小的数以后，再进行交换
            if(i!=k){//交换a[i]和a[k]
                int temp = arr[k];
                arr[k] = arr[i];
                arr[i] = temp;
            }
            System.out.println();
            System.out.println(i+"趟排序后：");
            for(int num:arr){
                System.out.print(num+" ");
            }
        }
        System.out.println();
        System.out.println("交换后：");
        for(int num:arr){
            System.out.print(num+" ");
        }
    }
    public static void SelectSort(int[] arr){
        for (int i = 0; i <=arr.length-1; i++) {
            int k = i;
            for (int j = i; j <=arr.length-1; j++) {
                if(arr[j] > arr[k]){
                    k = j;
                }
            }
            if(i!=k){
                int temp = arr[k];
                arr[k] =  arr[i];
                arr[i] = temp;
            }
        }
    }
}
