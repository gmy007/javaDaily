package com.cug.multiThread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class demo2 implements Runnable {
    static AtomicInteger a=new AtomicInteger(0);
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            a.incrementAndGet();
        }

    }

    public static void main(String[] args) {
        demo2 run = new demo2();
        new Thread(run).start();
        new Thread(run).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(a);
    }
}
