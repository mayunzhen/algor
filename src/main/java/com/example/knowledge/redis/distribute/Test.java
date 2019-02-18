package com.example.knowledge.redis.distribute;

public class Test {
    public static void main(String[] args) {
        String hello = "Hello", lo = "lo";
        System.out.println((hello == "Hello") + " ");
        System.out.println((Other.hello == hello) + " ");
        System.out.println((com.example.knowledge.redis.distribute.other.Other.hello == hello) + " ");
        System.out.println((hello == ("Hel"+"lo")) + " ");
        System.out.println((hello == ("Hel"+lo)) + " ");
        System.out.println(hello == ("Hel"+lo).intern());
    }
}
class Other {
    static String hello = "Hello";
}
