package com.example.knowledge.java;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

interface Vehicle {
    default void print(){
        System.out.println("我是一辆车!");
    }
    // 静态方法
    static void blowHorn(){
        System.out.println("按喇叭!!!");
    }
}
interface FourWheeler {
    default void print(){
        System.out.println("我是一辆四轮车!");
    }
}
class Car implements Vehicle, FourWheeler {
    public void print(){
        System.out.println("我是一辆四轮汽车!");
    }
}

class Car1 implements Vehicle, FourWheeler {
    public void print() {
        Vehicle.super.print();
    }
}
class Car2 implements Vehicle, FourWheeler {
    public void print(){
        Vehicle.super.print();
        FourWheeler.super.print();
        Vehicle.blowHorn();
        System.out.println("我是一辆汽车!");
    }
}
public class Java8Test1 {
    public static void main(String[] args) {
//        Car car = new Car();
//        car.print();
//        Car1 car1 = new Car1();
//        car1.print();

//        Vehicle vehicle = new Car();
//        vehicle.print();

        Car2 car2 = new Car2();
        car2.print();
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
//        list.add("dss");
        Predicate<Integer> predicate = n -> n>3;
        list.stream().filter(predicate).forEach(System.out::println);
    }
    private static void eval(List<Integer> list, Predicate<Integer> predicate) {
        list.stream().filter(predicate).forEach(System.out::println);
    }
}

