package com.example.algorithm.leetcode.easy;

/**
 1.Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
 Example:
 Given nums = [2, 7, 11, 15], target = 9,
 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] indices = new int[2];
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            int expectVal = target - nums[i];
            for (int j = i+1; j < nums.length; j++) {
                if (expectVal == nums[j]){
                    indices[0] = i;
                    indices[1] = j;
                    flag = true;
                    break;
                }

            }
            if (flag == true){
                break;
            }
        }
        return indices;
    }
    public static void main(String[] args) {
        int[] nums = {11,2, 7,7, 15};
        int target = 9;
        int[] indices = twoSum(nums,target);
        System.out.println(indices[0]+","+indices[1]);
    }
}
