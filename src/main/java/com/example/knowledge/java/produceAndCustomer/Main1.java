package com.example.knowledge.java.produceAndCustomer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BoundedBuffer {
    final Lock lock = new ReentrantLock();//锁对象
    final Condition notFull  = lock.newCondition();//写线程条件
    final Condition notEmpty = lock.newCondition();//读线程条件

    final Object[] items = new Object[100];//缓存队列
    int putptr/*写索引*/, takeptr/*读索引*/, count/*队列中存在的数据个数*/;

    public void put(Object x) throws InterruptedException {
        lock.lock();
        try {
            System.out.println("---生产者获得锁----");
            while (count == items.length)//如果队列满了
            {
                System.out.println("队列已满，释放锁，awaiting--");
                notFull.await();//阻塞写线程
            }
            System.out.println("生产物品ing");
            items[putptr] = x;//赋值
            if (++putptr == items.length) putptr = 0;//如果写索引写到队列的最后一个位置了，那么置为0
            ++count;//个数++
            System.out.println("---生产完了end---");
            notEmpty.signal();//唤醒读线程
        } finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
        lock.lock();
        System.out.println("---消费者获得锁----");
        try {
            while (count == 0)//如果队列为空
            {
                System.out.println("队列为空，释放锁，awaiting--");
                notEmpty.await();//阻塞读线程
            }
            System.out.println("消费物品ing");
            Object x = items[takeptr];//取值
            if (++takeptr == items.length) takeptr = 0;//如果读索引读到队列的最后一个位置了，那么置为0
            --count;//个数--
            System.out.println("---消费完了end---");
            notFull.signal();//唤醒写线程
            return x;
        } finally {
            lock.unlock();
        }
    }
}
public class Main1 {
    public static void main(String[] args) {
        BoundedBuffer boundedBuffer = new BoundedBuffer();
        new Thread(()->{
            try {
                boundedBuffer.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"消费线程").start();

        new Thread(()->{
            try {
                boundedBuffer.put(new Object());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"生产线程").start();
    }
}
