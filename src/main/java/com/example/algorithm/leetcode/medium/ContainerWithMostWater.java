package com.example.algorithm.leetcode.medium;

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int start = 0,end = height.length-1;
        int resMax = 0;
        while (start < end){
            resMax = Math.max(resMax,(end - start)*Math.min(height[end],height[start]));
            if(height[start] < height[end]){
                start++;
            }else {
                end--;
            }
        }
        return resMax;
    }
    public static void main(String[] args) {
        int[] arrr = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(arrr));
    }
}
