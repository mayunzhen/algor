package com.example.algorithm.leetcode.hard;

/**
 4.Median of Two Sorted Arrays
 There are two sorted arrays nums1 and nums2 of size m and n respectively.
 Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 You may assume nums1 and nums2 cannot be both empty.
 Example 1:
 nums1 = [1, 3]
 nums2 = [2]
 The median is 2.0

 Example 2:
 nums1 = [1, 2]
 nums2 = [3, 4]
 The median is (2 + 3)/2 = 2.5
 https://blog.csdn.net/xu2645318400/article/details/73924591
 */
public class FindMedianSortedArrays {

    //(m+n)log(m+n)
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double res = 0;
        int N = nums1.length+nums2.length;
        int[] sums = new int[N];
        int i =0, j = 0, k = 0;

        while (i<nums1.length && j<nums2.length){
            if(nums1[i] < nums2[j]){
                sums[k] = nums1[i];
                i++;
                k++;
            }else {
                sums[k] = nums2[j];
                j++;
                k++;
            }
        }
        while (i < nums1.length){
            sums[k] = nums1[i];
            i++;
            k++;
        }
        while (j < nums2.length){
            sums[k] = nums2[j];
            j++;
            k++;
        }
        if(N%2 != 0){//奇数
            res = (double) sums[N/2];
        }else {//偶数
            res = (double)(sums[N/2]+sums[N/2-1])/(double)2;
        }
        return res;
    }

    //log(m+n)
    public static double findMedianSortedArrayss(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int total = len1 + len2;
        if(total%2 != 0){
            //奇数
            return findKth(nums1,0,len1-1,nums2,0,len2-1,total/2+1);
        }else {
            //偶数
            double res1 = findKth(nums1,0,len1-1,nums2,0,len2-1,total/2);
            double res2 = findKth(nums1,0,len1-1,nums2,0,len2-1,total/2+1);
            return  (res1+res2)/(double)2;
        }
    }
    public static double findKth(int[] array1, int start1, int end1, int[] array2, int start2, int end2, int k){
        int length1 = end1 - start1 + 1;
        int length2 = end2 - start2 + 1;
        if(length1 > length2){
            return findKth(array2, start2, end2, array1, start1, end1, k);
        }
        if(length1 == 0)
            return array2[start2 + k - 1];//由于array1的长度总是小于array2的长度
        if(k == 1)
            return Math.min(array1[start1] , array2[start2]);

        int p1 = Math.min(k/2,length1);
        int p2 = k - p1;
        if(array1[start1 + p1 - 1] < array2[start2 + p2 - 1]){
            return findKth(array1,start1+p1, end1, array2, start2, end2,k-p1);

        }else if(array1[start1 + p1 - 1] > array2[start1 + p2-1]){
            return findKth(array1,start1,end1,array2,start2+p2,end2,k-p2);
        }else
            return array1[start1+p1-1];//返回二者之一皆可
    }
    public static void main(String[] args) {
        int[] nums1 = {1,2,3};
        int[] nums2 = {4,5,6};
        System.out.println(findMedianSortedArrayss(nums1,nums2));
    }
}
