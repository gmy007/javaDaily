package com.cug.multiThread;

public class DeadLock {
    public static void main(String[] args) {
        new Thread(()->{
            synchronized (DeadLock.class){
                try {
                    Thread.sleep(500);
                    System.out.println(Thread.currentThread().getName()+"\t dead.class");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (Object.class){
                    System.out.println(Thread.currentThread().getName()+"\t Obj.class");
                }
            }
        }).start();
        new Thread(()->{
            synchronized (Object.class){
                try {
                    Thread.sleep(500);
                    System.out.println(Thread.currentThread().getName()+"\t Obj.class");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (DeadLock.class){
                    System.out.println(Thread.currentThread().getName()+"\t dead.class");
                }
            }
        }).start();
    }


}
