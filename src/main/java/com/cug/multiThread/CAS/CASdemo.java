package com.cug.multiThread.CAS;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class CASdemo {
    AtomicReference<Thread> ar=new AtomicReference<Thread>();

    public void lock(){
        
        while(!ar.compareAndSet(null,Thread.currentThread())){}
        System.out.println(Thread.currentThread().getName()+"\t come in");
    }
    public void unlock(){

        while(!ar.compareAndSet(Thread.currentThread(),null)){};
        System.out.println(Thread.currentThread().getName()+"\t  go away");
    }

    public static void main(String[] args) {
        CASdemo caSdemo = new CASdemo();
        new Thread(()->{
            caSdemo.lock();
            try{TimeUnit.SECONDS.sleep(3);}catch (InterruptedException e){e.printStackTrace();}
            caSdemo.unlock();
        },"t1").start();
        try{TimeUnit.SECONDS.sleep(1);}catch (InterruptedException e){e.printStackTrace();}
        new Thread(()->{
            caSdemo.lock();
            try{TimeUnit.SECONDS.sleep(1);}catch (InterruptedException e){e.printStackTrace();}
            caSdemo.unlock();
        },"t2").start();
    }
}
