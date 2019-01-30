package com.example.knowledge.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Java8内置的四大核心函数式接口：
 * Consumer<T>:消费型接口</T>
 * <p>
 * <p>
 * Supplier<T>供给型接口</T>
 * <p>
 * Function<T,R>函数型接口</T,R>
 * <p>
 * <p>
 * Predicate<T>段言型接口</T>
 * boolean test（T t）
 */
public class TestLamda3 {
    @Test
    public void test1() {
        happy(10000, (m) -> System.out.println("这次消费了" + m + "元"));
    }

    @Test
    public void test2() {
        List<Integer> list = getNumList(5, () -> {
            return 100;
        });

        list.forEach(System.out::println);
    }

    //函数式接口
    @Test
    public void test4() {
        String newStr = strHandle("\t\t\t woshi nide ", (str) -> str.trim());
        System.out.println(newStr);
    }

    //段言型接口;将满足条件的字符串放入集合中
    @Test
    public void test5() {

        List<String> list1 = Arrays.asList("nihao", "hiehei", "woai", "ni");
        List<String> list = filterStr(list1, (s) -> s.length() > 3);
        for (String s : list) {
            System.out.println(s);
        }
    }

    public List<String> filterStr(List<String> strings, Predicate<String> predicate) {
        List<String> results = new ArrayList<>();
        for (int i = 0; i < strings.size(); i++) {
            if (predicate.test(strings.get(i)))
                results.add(strings.get(i));
        }
        return results;
    }

    public String strHandle(String str, Function<String, String> stringFunction) {
        return stringFunction.apply(str);
    }

    public List<Integer> getNumList(int n, Supplier<Integer> supplier) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Integer integer = supplier.get();
            list.add(integer);
        }
        return list;
    }

    public void happy(int num, Consumer consumer) {
        consumer.accept(num);
    }
}
