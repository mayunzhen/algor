package com.example.algorithm.leetcode.easy;

public class RemoveElement {
    //移除指定的元素，返回数组长度，并且空间复杂度为O(1)
    public static int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i <nums.length; i++) {
            if(nums[i] != val){
                nums[index] = nums[i];
                index = index + 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int len = removeElement(nums,2);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i]+ " ");
        }
        System.out.println();
    }
}
