package com.example.knowledge.java.FutureAndCallable;
//https://www.cnblogs.com/dolphin0520/p/3949310.html
import java.util.concurrent.*;

//1.使用Callable+Future获取执行结果
public class Test {
    static class Task implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            System.out.println("子线程在进行计算");
            Thread.sleep(10000);
            int sum = 0;
            for(int i=0;i<100;i++)
                sum += i;
            return sum;
        }
    }
    public static void main(String[] args) {
        /*
        子线程在进行计算
        主线程在执行任务
        task运行结果4950
        所有任务执行完毕
         */
        ExecutorService executor = Executors.newCachedThreadPool();
        Task task = new Task();
        Future<Integer> result = executor.submit(task);
        executor.shutdown();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        System.out.println("主线程在执行任务");

        try {
            System.out.println("task运行结果"+result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("所有任务执行完毕");
    }
}
