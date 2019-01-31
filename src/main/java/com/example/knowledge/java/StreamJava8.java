package com.example.knowledge.java;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamJava8 {
    public static void main(String[] args) {
        System.out.println("使用 Java 8: ");
        long count;
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        System.out.println("列表: " +strings);

         count = strings.stream().filter(string->string.isEmpty()).count();
        System.out.println("空字符串数量为: " + count);

        count = strings.stream().filter(string -> string.length() == 3).count();
        System.out.println("字符串长度为 3 的数量为: " + count);

        List<String> filtered;
        filtered = strings.stream().filter(string ->!string.isEmpty()).collect(Collectors.toList());
        System.out.println("筛选后的列表: " + filtered);

        String mergedString;
        mergedString = strings.stream().filter(string ->!string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("合并字符串: " + mergedString);

//        List<String> squaresList;
//        squaresList = numbers.stream().map( i ->i*i).distinct().collect(Collectors.toList());
//        System.out.println("Squares List: " + squaresList);
//        System.out.println("列表: " +integers);
    }
}
