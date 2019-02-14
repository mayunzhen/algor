package com.example.knowledge.java;
class A {
    public static B b;

    public void globalVariablePointerEscape() { // 给全局变量赋值，发生逃逸
        b = new B();
    }

    public B methodPointerEscape() { // 方法返回值，发生逃逸
        return new B();
    }

    public void instancePassPointerEscape() {
        methodPointerEscape().printClassName(this); // 实例引用传递，发生逃逸
    }
}

class B {
    public void printClassName(A a) {
        System.out.println(A.class.getName());
    }
}
    public class EscapeTest {

}
