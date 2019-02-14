package com.example.knowledge.java;

//http://www.cnblogs.com/Mainz/p/3556430.html volatile  只有可见性，不具有原子性
public class volitaleTest {
    private static volatile long _longVal = 0;

    private static class LoopVolatile implements Runnable {
        public void run() {
            long val = 0;
            while (val < 10000000L) {
                _longVal++;
                val++;
            }
        }
    }
    private static class LoopVolatile2 implements Runnable {
        public void run() {
            long val = 0;
            while (val < 10000000L) {
                _longVal++;
                val++;
            }
        }
    }
    public static  void main(String[] args){
        Thread t1 = new Thread(new LoopVolatile());
        t1.start();

        Thread t2 = new Thread(new LoopVolatile2());
        t2.start();

        while (t1.isAlive() || t2.isAlive()) {
        }

        System.out.println("final val is: " + _longVal);
    }
}
