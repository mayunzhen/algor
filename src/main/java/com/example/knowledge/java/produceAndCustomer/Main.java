package com.example.knowledge.java.produceAndCustomer;

public class Main {
    static class Value{
        public static String value = "";
    }
    static class Produce{
        private Object lock;

        public Produce(Object lock) {
            this.lock = lock;
        }
        public void Prod(){
            synchronized (this.lock){
                System.out.println("---生产者获得锁---");
                if(!Value.value.equals("")) {
                    try {
                        System.out.println("当前有货物，不需生产，释放锁,waiting----");
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("生产物品");
                Value.value = "mayunzhen1";

                lock.notifyAll();
            }
        }
    }
    static class Customer{
        private Object lock;

        public Customer(Object lock) {
            this.lock = lock;
        }
        public void Cust(){
            synchronized (this.lock){
                System.out.println("---消费者获得锁---");
                if(Value.value.equals("")){
                    System.out.println("当前没有货物，释放锁，waiting---");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("消费物品");
                Value.value = "";

                lock.notifyAll();
            }
        }
    }
    public static void main(String[] args) {
        Object lock = new Object();
        Produce produce = new Produce(lock);
        Customer customer = new Customer(lock);
        new Thread(()->{
            for (int i = 0; i < 2; i++) {
                produce.Prod();
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) { }
            }
        },"生产者线程").start();

        new Thread(()->{
            for (int i = 0; i < 2; i++) {
                customer.Cust();
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) { }
            }
        },"消费者线程").start();
    }
}
