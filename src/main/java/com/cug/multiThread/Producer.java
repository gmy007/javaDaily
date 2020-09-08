package com.cug.multiThread;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MyResource {
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    int state = 0;

    public void consume() throws Exception {
        lock.lock();
        try {
            while (state != 1) {//多线程需要用while循环判断，否则会出现虚假唤醒
                condition.await();//释放锁，构造成节点加入等待队列
            }
            state--;
            System.out.println(Thread.currentThread().getName() + "消费了资源-1");
            condition.signalAll();//对等待队列的每一个节点使用signal方法，从等待队列加入到AQS同步队列
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void produce() throws Exception {
        lock.lock();
        try {
            while (state != 0)
                condition.await();
            state++;
            System.out.println(Thread.currentThread().getName() + "生产了资源+1");
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class Producer {
    public static void main(String[] args) {
        MyResource resource = new MyResource();
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    resource.produce();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"AA").start();
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    resource.consume();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"BB").start();
    }
}
