package com.cug.demo;

import java.util.concurrent.ThreadPoolExecutor;

public class Test {
    public void test() {
        synchronized (this) {
            synchronized (this){
                System.out.println("world");
            }
            System.out.println("hello");
        }
    }
}


