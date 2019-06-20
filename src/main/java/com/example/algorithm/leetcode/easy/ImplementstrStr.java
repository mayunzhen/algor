package com.example.algorithm.leetcode.easy;
//https://www.cnblogs.com/kingofkai/p/6178773.html
//给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
public class ImplementstrStr {

    //朴素实现方法
    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        int m = haystack.length();
        int n = needle.length();
        if (n > m) return -1;
        for (int i = 0; i <= m - n; i++) {
            int j = 0;
            for (; j < n; j++) {
                if (haystack.charAt(i+j) != needle.charAt(j))
                    break;
            }
            if (j == n) return i;
        }
        return -1;
    }


    //KMP算法实现
    private static void KMP(String source, String pattern) {
        int[] N=getN(pattern);
        int res=0;
        int sourceLength=source.length();
        int patternLength=pattern.length();
        for(int i=0;i<=(sourceLength-patternLength);){
            res++;
            String str=source.substring(i, i+patternLength);//要比较的字符串
            p(str);
            int count=getNext(pattern, str,N);
            p("移动"+count+"步");
            if(count==0){
                p("KMP：匹配成功");
                break;
            }
            i=i+count;
        }
        p("KMP：一共匹配"+res+"次数");
    }
    private static int[] getN(String pattern) {
        char[] pat = pattern.toCharArray();
        int j = pattern.length()-1;
        int[] N=new int[j+1];
        for(int i=j;i>=2;i--){
            N[i-1]=getK(i,pat);
        }
        for(int a:N)
            p(a);
        return N;
    }
    private static int getK(int j, char[] pat) {
        int x=j-2;
        int y=1;
        while (x>=0 && compare(pat, 0, x, y, j-1)) {
            x--;
            y++;
        }
        return x+1;
    }
    private static boolean compare(char[] pat,int b1,int e1,int b2,int e2){
        int n = e1-b1+1;
        while (n-- != 0) {
            if (pat[b1] != pat[b2]){
                return true;
            }
            b1++;
            b2++;
        }
        return false;
    }
    /**
     * 得到下一次要移动的次数
     *
     * @param pattern
     * @param str
     * @param N
     * @return 0,字符串匹配；
     */
    private static int getNext(String pattern,String str,int[] N) {
        int n = pattern.length();
        char v1[] = str.toCharArray();
        char v2[] = pattern.toCharArray();
        int x = 0;
        while (n-- != 0) {
            if (v1[x] != v2[x]){
                if(x==0){
                    return 1;//如果第一个不相同，移动1步
                }
                return x-N[x-1];//x:第一次出现不同的索引的位置，即j
            }
            x++;
        }
        return 0;
    }

    public static void p(Object str){
        System.out.println(str);
    }
    public static void main(String[] args) {
        String haystack = "ab";
        String needle = "ab";
        System.out.println(strStr(haystack,needle));
    }
}
