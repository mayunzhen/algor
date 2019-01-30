package com.example.knowledge.java.Thread;

class MyThread extends Thread{
    int i=100;
    @Override
    public void run() {
        while (i>90) {
            System.out.println(i);
            i--;
        }
    }
}
public class Thread1 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }
}
