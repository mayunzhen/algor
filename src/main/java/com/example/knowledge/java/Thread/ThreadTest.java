package com.example.knowledge.java.Thread;

public class ThreadTest {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 3) {
                Runnable myRunnable1 = new MyRunnable1();
                Thread thread = new MyThreadt(myRunnable1);
                thread.start();
            }
        }
    }
}

class MyRunnable1 implements Runnable {
    private int i = 0;

    @Override
    public void run() {
        System.out.println("in MyRunnable run");
        for (i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}

class MyThreadt extends Thread {

    private int i = 0;

    public MyThreadt(Runnable runnable){
        super(runnable);
    }

    @Override
    public void run() {
        System.out.println("in MyThread run");
        for (i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}