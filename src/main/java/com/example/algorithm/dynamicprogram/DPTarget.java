package com.example.algorithm.dynamicprogram;
//https://www.bilibili.com/video/av18512769/?spm_id_from=333.788.videocard.0
//从给定数组中判断能否找出加和为target的数
public class DPTarget {
    public static boolean rec_subset(int[] arr,int i, int target){
        if(target == 0 )
            return true;
        if(i == 0)
            return target == arr[0];
        if(arr[i] > target)
            return rec_subset(arr,i-1,target);
        boolean a1 = rec_subset(arr,i-1,target-arr[i]);
        boolean a2 = rec_subset(arr,i-1,target);
        return a1 || a2;
    }

    public static boolean db_subset(int[] arr ,int target){
        boolean[][] dp = new boolean[arr.length][target+1];
        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = true;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < target+1; j++) {
                if(j == arr[i])
                    dp[i][j] = true;
            }
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < target+1; j++) {
                if(arr[i] > j){
                    dp[i][j] = dp[i-1][j];
                }else {
                    boolean a1 = dp[i-1][j-arr[i]];
                    boolean a2 = dp[i-1][j];
                    dp[i][j] = a1 || a2;
                }
            }
        }
        return dp[arr.length-1][target];
    }
    public static void main(String[] args) {
        int[] arr = {3,34,4,12,5,2};
        int target  = 9;
        System.out.println(rec_subset(arr,arr.length-1,target));
        System.out.println(db_subset(arr,13));
    }
}
