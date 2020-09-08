package com.cug.multiThread;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.*;

public class demo1 implements Runnable {
    public static ExecutorService threadPool = Executors.newFixedThreadPool(10);
    public static CountDownLatch countDownLatch = new CountDownLatch(3);//计数器
    public static CyclicBarrier cyclicBarrier = new CyclicBarrier(4,new demo1());//屏障
    public static Semaphore semaphore = new Semaphore(2);//信号量
    public static  ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
    public static void main(String[] args) {
        //countDownTest();
        cycBarrierDemo();
        
    }

    private static void cycBarrierDemo() {
        System.out.println("主线程开始工作。。。。。。。");
        threadPool.execute(()->{
            try {
                System.out.println("线程"+Thread.currentThread().getName()+"开始");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            concurrentHashMap.put("数学","72");
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        threadPool.execute(()->{
            try {
                System.out.println("线程"+Thread.currentThread().getName()+"开始");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            concurrentHashMap.put("语文","90");
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        threadPool.execute(()->{
            try {
                System.out.println("线程"+Thread.currentThread().getName()+"开始");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            concurrentHashMap.put("英语","100");
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        });

        try {
            System.out.println("主线程屏障处。。。。。");
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        threadPool.shutdown();

        System.out.println("重新回到主线程");


        System.out.println("主线程结束。。。。。。。。。。。");
    }

    private static void countDownTest() {
        System.out.println("主线程开始工作。。。。。。。");
        threadPool.execute(()->{
            try {
                System.out.println("线程"+Thread.currentThread().getName()+"开始");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            concurrentHashMap.put("数学","72");
            countDownLatch.countDown();
        });
        threadPool.execute(()->{
            try {
                System.out.println("线程"+Thread.currentThread().getName()+"开始");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            concurrentHashMap.put("语文","90");
            countDownLatch.countDown();
        });
        threadPool.execute(()->{
            try {
                System.out.println("线程"+Thread.currentThread().getName()+"开始");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            concurrentHashMap.put("英语","100");
            countDownLatch.countDown();
        });
        threadPool.shutdown();
        try {
            countDownLatch.await();
            System.out.println("重新回到主线程");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Set<Map.Entry<String, String>> entrySet = concurrentHashMap.entrySet();
        int count=0;
        for (Map.Entry<String, String> entry : entrySet) {
            count+=Integer.parseInt(entry.getValue());
        }
        System.out.println("总得分为："+count+".........");


        System.out.println("主线程结束。。。。。。。。。。。");
    }

    @Override
    public void run() {
        System.out.println("来到屏障设置的先执行线程任务");
        System.out.println("线程"+Thread.currentThread().getName()+"开始");
        Set<Map.Entry<String, String>> entrySet = concurrentHashMap.entrySet();
        int count=0;
        for (Map.Entry<String, String> entry : entrySet) {
            count+=Integer.parseInt(entry.getValue());
        }
        System.out.println("总得分为："+count+".........");
    }
}
