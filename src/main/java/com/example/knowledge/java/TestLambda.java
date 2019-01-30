package com.example.knowledge.java;

public class TestLambda implements NoFunc {
    public static void main(String[] args) {
        String string = "chy";
        Demo demo = new Demo();
        demo.sayDemo((String str) -> {
            System.out.println("lalal--"+string);
            return 0;
        });
        System.out.println("-----------------");
        TestLambda testLambda = new TestLambda();
        testLambda.run();
        System.out.println("-----------------------");
        NoFunc noFunc = ()->{
            System.out.println("lamda expression !");
        };
        noFunc.run();
        System.out.println("---------------------------------------------------------------------");
        Func func = ()->{
            System.out.println("func test !");
        };
        testLambda.test(3,func);
        System.out.println("-----------------------");
        testLambda.test(4,testLambda::Print);
    }

    @Override
    public void run() {
        System.out.println("run Method");
    }
    public void test(int x , Func func){
        System.out.println("test Method, x= "+x);
        func.run();
    }
    public void Print(){
        System.out.println("Print Method!");
    }
}

@FunctionalInterface
interface HelloService {
    Integer sayHello(String msg);

    default void sayHello(Integer msg) {
        System.out.println("msg");
    }
}

@FunctionalInterface
interface Func {
    boolean equals(Object o);//Object 的public 方法，可以有;

    void run();
//    Object clone();//Object类的 protect方法，所以不能再这有
}

@FunctionalInterface
interface NoFunc {
    void run();

    default void roo() {
        System.out.println("roo Method");
    }

    default void rcc() {
        System.out.println("rcc Method");
    }
}

class Demo {
    void sayDemo(HelloService helloService) {
        Integer integer = helloService.sayHello("mayunzhen Test");
        System.out.println("integer:" + integer);
        System.out.println("sayDemo Method");

    }
}