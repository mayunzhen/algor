package com.example.algorithm.swordoffer;
/*
1.问题：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
  请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class TwoDimArray {
    public static boolean find(int target, int [][] array) {

        //1.判断行和列的长度
        if(array.length == 0 || array[0].length == 0){
            return false;
        }

        //2.获取行和列的长度
        int rowLen = array.length;
        int colLen = array[0].length;

        //3.开始遍历查找，从左下角开始查找，大于指定的整数：上移，小于指定的整数：下移
        for(int i = rowLen-1,j = 0; i >= 0 && j < colLen ; ){
            int arr = array[i][j];
            if(arr == target){
                return true;
            }else if(arr > target){
                i--;
            }else{
                j++;
            }
        }

        //4.最后说明没有找到
        return false;
    }
    public static boolean findByDesc(int target,int[][] a){
        if(a == null || a.length == 0|| a[0].length == 0)
            return false;
        int i = 0;
        int j = a[0].length-1;
        while (i <= a.length-1 && j >= 0) {
            if(a[i][j] == target)
                return true;
            else if(a[i][j] < target)
                i++;
            else if(a[i][j] > target)
                j--;
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        System.out.println(findByDesc(5,arr));
    }
}
