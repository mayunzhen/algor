package com.example.algorithm.primaryalgor;

public class MergeSort {
    public static int[] mergeSort(int[] arr){
        int mid = (0+arr.length)/2;

        return arr;
    }

    public static void main(String[] args) {
//        int[] arr = {9,8,7,6,5,4,3,2,1};
        int[] a={5,3,6,1,9,8,2,4,7};
        System.out.println("排序前：");
        for(int num : a){
            System.out.print(num+" ");
        }
        System.out.println();
        for (int i = 0; i < a.length-1; i++) {
            for (int j = 0; j < a.length-1-i; j++) {
                if(a[j]>a[j+1]){
                    int e = a[j+1];
                    a[j+1] = a[j];
                    a[j] = e;
                }
            }
        }
        System.out.println("排序后：");
        for(int num : a){
            System.out.print(num+" ");
        }
        System.out.println();

        //二分查找 8
        int index = binarySearch(a,8);
        System.out.println(index);
    }
    public static int binarySearch(int[] a,int data){
        int left = 0;
        int right = a.length-1;
        while (left <= right){
            int mid = (left+right)/2;
            if(a[mid] > data){
                right = mid+1;
            }else if(a[mid] < data){
                left = mid+1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}

