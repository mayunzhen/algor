package com.example.knowledge.java.waitAndnotify;

import java.util.ArrayList;
import java.util.List;

public class syncAndwait {
    static class Mycontainer{
        volatile List<Object> list = new ArrayList<>();

        public void add(Object o){
            list.add(o);
        }
        public int getSize(){
            return list.size();
        }
    }

    public static void main(String[] args) {
        Mycontainer mycontainer = new Mycontainer();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                mycontainer.add(new Object());
                System.out.println("mycontainer.size = "+mycontainer.getSize());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t1").start();

        new Thread(()->{
            while (true){
                if(mycontainer.getSize() == 5) {
                    System.out.println("list size is 5, break");
                    break;
                }
            }
        }).start();
    }
}
