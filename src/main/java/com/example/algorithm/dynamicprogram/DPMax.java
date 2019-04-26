package com.example.algorithm.dynamicprogram;
//找出数组中，不相邻的数组成的和最大
public class DPMax {
    public static int dp_max(int[] arr){
        if(arr.length <= 0)
            return 0;
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0],arr[1]);
        for (int i = 2; i < arr.length; i++) {
            int max1 = dp[i-2]+arr[i];
            int max2 = dp[i-1];
            dp[i] = Math.max(max1,max2);
        }
        return dp[arr.length-1];
    }
    public static int rec_max(int[] arr,int i){
        if(arr.length <= 0)
            return 0;
        if(i == 0)
            return arr[0];
        if(i == 1)
            return Math.max(arr[i],arr[i-1]);
        int max1 = rec_max(arr,i-2)+arr[i];
        int max2 = rec_max(arr,i-1);
        return Math.max(max1,max2);
    }

    public static void main(String[] args) {
        int[] arr ={1,2,3,4,5,6};
        System.out.println(rec_max(arr,arr.length-1));
        System.out.println(dp_max(arr));
    }
}
