package com.example.algorithm.primaryalgor;
/**
 * 插入排序
 * 插入排序相当于向一个排好序的数组中加入新值，使得数组再次有序
 * 当第一次遍历时，相当于将第二个值与第一个比较，较小的放在前面
 * 第二次遍历时，则是将第三个值加入前两个值中合适的位置，使得三个值有序
 * ...
 * 当将最后一个值加入到前面已经排好序的数组中时，遍历结束
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr={1,3,2,45,65,33,12};
        System.out.println("排序之前：");
        for(int num:arr){
            System.out.print(num+" ");
        }
        System.out.println("");
        insertSort(arr);
        System.out.println("排序之后：");
        for(int num:arr){
            System.out.print(num+" ");
        }
        System.out.println("");
    }
    public static void insertSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int tmp = arr[i];
            int j;
            for (j = i; j > 0 ; j--) {
                if(tmp < arr[j-1])
                    arr[j] = arr[j-1];//依次向后移动一个位置
                else break;
            }
            arr[j] = tmp;
        }
    }
}
