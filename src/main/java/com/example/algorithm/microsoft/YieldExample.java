package com.example.algorithm.microsoft;

import java.util.ArrayList;

public class YieldExample {
    private ArrayList list = new ArrayList();

    private void add() throws Exception {
        synchronized (this) {
            while (list.size() >= 5) {
                wait();
            }
            list.add(new Object());
            System.out.println("notifyAll add---list.size=" + list.size());
            notifyAll();
        }
    }

    private void dec() throws Exception {
        synchronized (this) {
            while (list.size() < 5) {
                wait();
            }
            list.remove(0);
            System.out.println("notifyAll dec---list.size=" + list.size());
            notifyAll();
        }
    }

    public static void main(String[] args) throws Exception {
        YieldExample yieldExample = new YieldExample();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        yieldExample.add();
                        Thread.sleep(1000);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        yieldExample.dec();
                        Thread.sleep(1000);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}


