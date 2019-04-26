package com.example.algorithm.leetcode.medium;

/**
  Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
  Example 1:

 Input: "babad"
 Output: "bab"
 Note: "aba" is also a valid answer.

 Example 2:

 Input: "cbbd"
 Output: "bb"
 */
public class LongestPalindromicSubstring {
    //o(n^3)
    public static String longestPalindrome(String s) {
        if(s.length() == 1)
            return s;
        for (int i = s.length(); i > 0 ; i--) {//字串长度
            for (int j = 0; j <= s.length()-i; j++) {
                String sub = s.substring(j,i+j);//字串位置
                int count = 0;//计数 用来判断是否对称

                for (int k = 0; k < sub.length()/2; k++) {//左右对称判断
                    if(sub.charAt(k) == sub.charAt(sub.length()-k-1)){
                        count++;
                    }
                }
                if(count == sub.length()/2){
                        return sub;
                }
            }

        }
        return "";//表示字符串中无回文子串
    }
    //o(n^2)
    public static String longestPalindrome2(String s){
        if(s.length()<=1)
            return s;
        String ss ="";
        for (int i = 0; i < s.length(); i++) {
            String s1 = sublongestPalindromeStr(s,i,i);
            String s2 = sublongestPalindromeStr(s,i,i+1);
            ss = s1.length()>ss.length()?s1:ss;
            ss = s2.length()>ss.length()?s2:ss;
        }
        return ss;
    }
    public static String sublongestPalindromeStr(String s,int low,int high){
        while (low>=0 && high<s.length() && s.charAt(low) == s.charAt(high)){
            low--;
            high++;
        }
        return s.substring(low+1,high);
    }

    //o(n)
   public static String Manacher(String s){
        String t = "$#";
       for (int i = 0; i < s.length(); i++) {
           t+=s.charAt(i);
           t+="#";
       }
       t+="@";
       int[] p = new int[t.length()];
       int mx = 0, id = 0,resLen = 0,resCenter = 0;
       for (int i = 0; i < t.length()-1; i++) {
           p[i] = mx > i ? Math.min(p[2*id-i],mx-i):1;
            while ((i-p[i])>=0 && (i+p[i])< t.length() && (t.charAt(i-p[i]) == t.charAt(i+p[i])))
                ++p[i];
            if(mx < i+p[i]){
                mx = i+p[i];
                id = i;
            }
            if(resLen < p[i]){
                resLen = p[i];
                resCenter = i;
            }
       }
        return s.substring((resCenter-resLen)/2,(resCenter-resLen)/2+resLen-1);
   }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(Manacher(s));
    }
}
