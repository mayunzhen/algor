package com.example.algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> listList = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < len-2; i++) {
           if(nums[i] + nums[i+1] + nums[i+2] > 0)break;

        }
        return listList;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> listList = threeSum(nums);
        for (int i = 0; i < listList.size(); i++) {
            List<Integer> integerList = new ArrayList<>();
            for (int j = 0; j < integerList.size(); j++) {
                System.out.print(integerList.get(j)+",");
            }
        }
    }
}
