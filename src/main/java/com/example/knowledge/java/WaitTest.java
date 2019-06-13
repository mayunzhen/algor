package com.example.knowledge.java;

public class WaitTest {
    static class ThreadA extends Thread{
        public ThreadA(String name) {
            super(name);
        }

        @Override
        public void run(){

            synchronized (this) {
                try {
                    ThreadA.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" call notify()");
                notify();
            }
        }
    }

    public static void main(String[] args) throws Exception{
        ThreadA threadA = new ThreadA("threadA");
        synchronized (threadA){
            System.out.println("threadA start--");
            threadA.start();

            System.out.println(Thread.currentThread().getName()+" wait()");
            threadA.wait();
            System.out.println(Thread.currentThread().getName()+" continue");
        }


    }
}
