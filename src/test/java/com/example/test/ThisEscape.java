package com.example.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class MyService {
   private ReentrantLock lock = new ReentrantLock();
   Condition condition = lock.newCondition();
   private int count = 0;
   public void set(){
       lock.lock();
       try {
           while (count > 0)
            condition.await();
           System.out.println("生产++");
           count++;
           condition.signalAll();
       } catch (InterruptedException e) {
           e.printStackTrace();
       }finally {
           lock.unlock();
           System.out.println("finally 生产- 锁释放了！");
       }
   }
    public void get(){
        lock.lock();
        try {
            while (count == 0)
                condition.await();
            System.out.println("消费--");
            count --;
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
            System.out.println("finally 消费 - 锁释放了！");
        }
    }
}

class Producer extends Thread {

  private MyService service;
  public Producer(MyService service){
      this.service = service;
  }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            service.set();
        }

    }
}
class Consumer extends Thread {

    private MyService service;
    public Consumer(MyService service){
        this.service = service;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            service.get();
        }
    }
}
public class ThisEscape{
    public static void main(String[] args) throws Exception{
        MyService service = new MyService();
        Producer producer = new Producer(service);
        Consumer consumer = new Consumer(service);
        producer.start();
        consumer.start();
    }
}