package com.example.algorithm.primaryalgor;

public class QuickSort {
    public static int[] quickSort(int[] arr){
        if(arr == null)return arr;
        if(arr.length == 0 || arr.length == 1) return arr;
        sort(arr,0,arr.length-1);
        return arr;
    }
    public static void sort(int[] arr, int low, int high){
       //算法递归出口
        if(low>high)return;
        int i = low;
        int j = high;
        while (i < j){
            while (arr[low] > arr[j]) j--;
            while (arr[low] < arr[i]) i++;
            if (i<j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i];
        arr[i] = arr[low];
        arr[low] = arr[i];
        sort(arr,low,i-1);
        sort(arr,i+1,high);
    }

    public static void main(String[] args) {
        int[] arr={6,3,8,2,9,1};
        System.out.println("排序前数组为：");
        for(int num:arr){
            System.out.print(num+" ");
        }
        System.out.println();
        quickSort(arr);
        for(int num:arr){
            System.out.print(num+" ");
        }
        System.out.println();
    }
}
