package com.example.knowledge.java.Thread;

class MyRunnable implements Runnable {
    private int i = 0;
    @Override
    public void run() {
        while (i<10){
            System.out.println(Thread.currentThread().getName() + " " + i);
            i++;
        }
    }
}
public class Thread2 {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
    }
}
