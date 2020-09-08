package com.cug.multiThread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProCon2 {
    static volatile  int state=0;
    static Lock lock=new ReentrantLock();
    Condition notFull=lock.newCondition();
    Condition notEmpty=lock.newCondition();

    public void produce(){
        lock.lock();
        try{
            while(state==1)
                notFull.await();
            state++;
            System.out.println(Thread.currentThread().getName()+"\t 已生产一件商品");
            notEmpty.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void consumer(){
        lock.lock();
        try{
            while(state<1)
                notEmpty.await();
            state--;
            System.out.println(Thread.currentThread().getName()+"\t 已消费一件商品");
            notFull.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ProCon2 proCon = new ProCon2();
        new Thread(()->{

            while(true){
                proCon.produce();
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        },"AA").start();
        new Thread(()->{

            while(true){
                proCon.consumer();
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        },"BB").start();
    }
}
