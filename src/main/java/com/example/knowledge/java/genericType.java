package com.example.knowledge.java;

public class genericType {
    public static void main(String[] args) {

//        Box<Integer> a = new Box<Integer>(712);
//        Box<Number> b = a;  // 1
//        Box<Float> f = new Box<Float>(3.14f);
//        b.setT(f);        // 2

        Box<String> name = new Box<String>("corn");
//        getUpperNumberData(name);//1
        Box<Integer> age = new Box<Integer>(712);
        getUpperNumberData(age);    // 2
        Box<Number> number = new Box<Number>(314);
        getUpperNumberData(number); // 3

        getData(name);
        getData(age);
        getData(number);

    }

    public static void getData(Box<?> data) {
        System.out.println("data :" + data.getT());
    }
    public static void getUpperNumberData(Box<? extends Number> box){
        System.out.println("data:"+box.getT());
    }
}
class Box<T>{
    T t;

    public Box() {
    }

    public Box(T t) {
        setT(t);
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
