package com.example.knowledge.java;


import java.util.function.Function;

//@FunctionalInterface
//interface Function<T,R> {
//    R apply(T t);
//}
@FunctionalInterface
interface Function1<T> {
    void print(T t);
}
class Person{
    int age;
    int gender;
}
public class Java8Tester2 {
    public static void main(String[] args) throws Exception{
        Class<Person> clazz = Person.class;
        Class.forName("").newInstance();
        Person person = clazz.newInstance();
        Function<String, Integer> function = (String str) -> {
            System.out.println(str);
            return 500;
        };
        Function1<Integer> function1 = (Integer i) ->
                System.out.println(i);
        function.apply("df");
        function1.print(43);
    }
}