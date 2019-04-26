package com.example.algorithm.leetcode.hard;

public class RegularExpressionMatching {
    public static boolean isMatch(String s, String p) {
        boolean[][] match = new boolean[s.length()+1][p.length()+1];
        match[0][0] = true;
        //当S为空""，P不为空字符串
        for (int i = 1; i <= p.length(); i++){
            if(p.charAt(i-1) == '*')
                match[0][i] = match[0][i-2];
        }

        for (int si = 1; si <= s.length(); si++) {
            for (int pi = 1; pi <= p.length(); pi++) {
                if(s.charAt(si-1) == p.charAt(pi-1) || p.charAt(pi-1) == '.'){
                    match[si][pi] = match[si-1][pi-1];
                }else if(p.charAt(pi-1) == '*'){
                    if(p.charAt(pi-2) != '.' && p.charAt(pi-2) != s.charAt(si-1)){
                        match[si][pi] = match[si][pi-2];
                    }else {
                        match[si][pi] = match[si][pi-2] || match[si-1][pi];
//                        match[si][pi] = match[si][pi-2] || match[si-1][pi]|| match[si][pi-1];
                    }
                }
            }
        }
        return match[s.length()][p.length()];
    }
    public static void main(String[] args) {

        System.out.println(isMatch("mississippi","mis*is*ip*."));
    }
}
