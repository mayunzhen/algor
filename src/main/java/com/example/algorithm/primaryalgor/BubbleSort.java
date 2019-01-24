package com.example.algorithm.primaryalgor;

import com.example.algorithm.common.Utils;

public class BubbleSort {
    public static Integer[] bubbleSort(Integer[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if(arr[i]>arr[j]){
                    Utils.swap(i,j,arr);
                }
            }
        }
        return arr;
    }
}
