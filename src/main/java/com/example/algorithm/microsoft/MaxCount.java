package com.example.algorithm.microsoft;

public class MaxCount {
    public static int findMaxSubArySum1(int[] arr){
        int sum = 0;
        int max = 0;

        //最大子数组的开始位置
        int startPos = 0;
        //最大子数组的结束位置
        int endPos = 0;

        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
            if(sum < 0){
                sum = 0;
                startPos = i+1;
            }
            if(sum > max){
                max = sum;
                endPos = i+1;
            }
        }
        System.out.println("startPos="+startPos+",endPos="+endPos);
        return max;
    }
    public static void main(String[] args) {
        int[] array = {-1,2,-3,12,-5,-1,9,-2};
        int amx = findMaxSubArySum1(array);
        System.out.println(amx);
    }
}
