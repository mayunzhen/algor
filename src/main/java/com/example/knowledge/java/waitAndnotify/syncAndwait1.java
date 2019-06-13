package com.example.knowledge.java.waitAndnotify;

import java.util.ArrayList;
import java.util.List;
//https://blog.csdn.net/weixin_42486373/article/details/83963088
public class syncAndwait1 {
    static class Mycontainer{
        List<Object> list = new ArrayList<>();
        public void add(Object o){
            list.add(o);
        }

        public int getSize(){
            return list.size();
        }
    }
    public static void main(String[] args) {
        Mycontainer mycontainer = new Mycontainer();

        final Object lock = new Object();

        new Thread(()->{
                synchronized (lock){
                    System.out.println("thread 2 start...");
                    if(mycontainer.getSize() != 5){
                        try {
                            lock.wait();
                            System.out.println("thread 2 end.");
                            Thread.sleep(30000);
                        }catch (Exception e){}

                        lock.notifyAll();
                    }
            }
        },"t2").start();


        new Thread(()->{
            synchronized (lock){
                for (int i = 0; i < 10; i++) {
                    System.out.println("thread 1, add " + i);
                    mycontainer.add(new Object());
                    if(mycontainer.getSize() == 5){
                        lock.notifyAll();
                        try {
                            lock.wait();
                        }catch (Exception e){}

                    }
                }
            }
        },"t1").start();
    }
}
