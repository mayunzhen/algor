package com.example.algorithm.primaryalgor;
/**
 * 思路:根据给出来的数字,查看最大的数,并根据最大的数创建数组长度(最大数+1)
 * 数组初始值都是0,并且数字的值对应出现的次数,如a[5] 的值为2,证明 a[5] 这个位置出现两次5这个数
 */
public class BucketSort {
    public static void main(String[] args) {
        int[] sortArr = {1, 5, 9, 3, 2, 4, 5, 10, 0};
        int[] arr = new int[11];
        for (int i : sortArr) {
            arr[i]++;//i为桶的序号，arr[i]为这个桶里存储i的个数
        }

        //升序
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j <= arr[i]; j++) {
                System.out.print(" " + i);
            }
        }
        System.out.println();
        //降序
        for (int i = arr.length-1; i >= 0; i--) {
            for (int j = 1; j <= arr[i]; j++) {
                System.out.print(" " + i);
            }
        }
        System.out.println();
    }
    public static void bucket(int[] arr){
        int[] count = new int[11];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]] ++;
        }
        for (int i = 0; i < count.length; i++) {
            for (int j = 1;j<=count[i];j++){
                System.out.print(i+" ");
            }
        }
    }
}
