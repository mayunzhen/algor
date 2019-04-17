package com.example.algorithm.primaryalgor;

public class Test {
    public static void main(String[] args) {
        int a[] = {80,30,60,40,20,10,50,70};
//        selectSort(a);
        quickSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
    //快排
    public static void quickSort(int[] arr){
        if(arr == null || arr.length == 0 || arr.length == 1)
            return;
        qsort(arr,0,arr.length-1);
    }
    public static void qsort(int[] arr, int low, int high){
        if(low > high) return;
        int i = low;
        int j = high;
        while (i < j){
            while (arr[low] < arr[i]) i++;
            while (arr[low] > arr[j]) j--;
            if(i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        qsort(arr,low,i-1);
        qsort(arr,i+1,high);
    }
    //end
    //选择排序
    public static void selectSort(int[] arr){
        for (int i = 0; i <= arr.length-1; i++) {
            int k = i;
            for (int j = i+1; j <= arr.length-1; j++) {
                if(arr[k] > arr[j]){
                    k = j;
                }
            }
            if(k!=i){
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
            }
        }
    }
    //end
}
