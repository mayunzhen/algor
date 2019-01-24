package com.example.algorithm.common;

public class Utils {
    public static <T> void swap(int i, int j, T[] arr){
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
