package com.example.algorithm.leetcode.easy;

public class RemoveDuplicatesfromSortedArray {
    //只出现一次
    public static int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
           if(nums[i] != nums[index]){
               index = index+1;
               nums[index] = nums[i];
           }
        }
        return index+1;
    }
    //只出现k次
    public static int getKnums(int[] nums, int k){
        int index = 0, cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i == 0){
                cnt++;
                nums[index] = nums[i];
                continue;
            }
            if(nums[i] == nums[index]){
                if(cnt < k){
                    cnt++;
                    index = index+1;
                    nums[index] = nums[i];
                }
            }else {
                cnt = 1;
                index = index+1;
                nums[index] = nums[i];
            }
        }
        return index+1;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,1,2,2,3,3,3,3,3,4,5,6,6,6,6};
        int index = removeDuplicates(nums);
//        int index = getKnums(nums,3);
        System.out.println();
        for (int i = 0; i < index; i++) {
            System.out.print(nums[i]+" ");
        }
        System.out.println();
    }
}
