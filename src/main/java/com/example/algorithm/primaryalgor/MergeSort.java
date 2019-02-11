package com.example.algorithm.primaryalgor;

public class MergeSort {

    public static void main(String[] args) {
//        int[] arr = {9,8,7,6,5,4,3,2,1};
        int[] a={5,3,6,1,9,8,2,4,7};
        System.out.println("排序前：");
        for(int num : a){
            System.out.print(num+" ");
        }
        mergerSort(a);
        System.out.println();
        System.out.println("排序后：");
        for(int num : a){
            System.out.print(num+" ");
        }
    }
    public static void mergerSort(int[] arr){
        if(arr == null)return;
        if (arr.length == 0 || arr.length == 1)return;
        sort(arr,0,arr.length-1);
    }
    public static void sort(int[] arr, int low, int high){
        if (low < high){
            int mid = (low+high)/2;
            sort(arr,low,mid);
            sort(arr,mid+1,high);
            merge(arr,low,mid,high);
        }
    }
    public static void merge(int[] arr, int low, int mid, int high){
        int[] temp = new int[high-low+1];
        int i = low;
        int j = mid+1;
        int k = 0;
        while (i <= mid && j <= high){
            if(arr[i]<arr[j]){
                temp[k++] = arr[i++];
            }else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) temp[k++] = arr[i++];
        while (j<= high) temp[k++] = arr[j++];

        for (int l = 0; l < temp.length; l++) {
            arr[low+l] = temp[l];
        }
    }
}

