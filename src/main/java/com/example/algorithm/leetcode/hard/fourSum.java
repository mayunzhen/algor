package com.example.algorithm.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class fourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target){
        List<List<Integer>> res = new ArrayList<>();  // 注意不能是new List<>(); List是接口

        if (nums == null || nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int sum = -nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == sum) {
                    ArrayList<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[left]);
                    triplet.add(nums[right]);
                    res.add(triplet);

                    while (left < right && nums[left++] == nums[left]) {}
                    while (left < right && nums[right--] == nums[right]) {}

                } else if (nums[left] + nums[right] < sum) {
                    while (left < right && nums[left++] == nums[left]) {}

                } else {
                    while (left < right && nums[right--] == nums[right]) {}
                }
            }
        }

        return res;
    }
    public static void main(String[] args) {

    }
}
