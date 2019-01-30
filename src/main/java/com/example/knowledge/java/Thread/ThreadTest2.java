package com.example.knowledge.java.Thread;

public class ThreadTest2 {

    public static void main(String[] args) {
        Thread myThread = new MyThread2();
        for (int i = 0; i < 10; i++) {
            System.out.println("main thread i = " + i);
            if (i == 2) {
                myThread.setDaemon(true);
                myThread.start();
            }
        }
    }

}

class MyThread2 extends Thread {

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("i = " + i);
            try {
                Thread.sleep(1000000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
