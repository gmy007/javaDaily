package com.cug.multiThread;

import java.util.Random;
import java.util.concurrent.*;

public class ThreadPoolDemo {
    static class MyTask implements Callable<String>{
        @Override
        public String call() throws Exception {
            System.out.println("This is my task running ,return random string");
            int i = new Random().nextInt(100);
            return String.valueOf(i);
        }
    }
    static class MyExceptionTask implements Callable<String>{
        @Override
        public String call() throws Exception {
            throw new RuntimeException("Exception happens");
        }
    }
    public static void main(String[] args) {

        ExecutorService pool = Executors.newFixedThreadPool(3);
        Future<String> future = pool.submit(new MyTask());
        Future<String> future1 = pool.submit(new MyExceptionTask());

        try {
            System.out.println(future.get());
            System.out.println(future1.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("catch the Exception");
        } catch (ExecutionException e) {
            e.printStackTrace();
            pool.shutdown();
            System.out.println("remove threadPool");
        }
    }

}
