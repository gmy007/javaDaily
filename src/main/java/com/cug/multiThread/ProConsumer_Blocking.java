package com.cug.multiThread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ProConsumer_Blocking {
    public static void main(String[] args) {

        MyResource_Blocking resource = new MyResource_Blocking(new ArrayBlockingQueue(5));
        new Thread(()->{
            try {
                resource.produce();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"producer").start();
        new Thread(()->{
            try {
                resource.consumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"consumer").start();
        try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }

        System.out.println("\t生产叫停\t");
        System.out.println();
        resource.stop();
    }

}
class MyResource_Blocking{
    volatile boolean flag=true;
    AtomicInteger ati=new AtomicInteger();
    BlockingQueue<String >blockingQueue=null;
    MyResource_Blocking(BlockingQueue blockingQueue){
        this.blockingQueue=blockingQueue;
    }
    public  void produce() throws Exception{
        String result=null;
        while(flag){
            result= ati.incrementAndGet() + "";
            boolean offer = blockingQueue.offer(result,2L,TimeUnit.SECONDS);
            if(offer)
                System.out.println(Thread.currentThread().getName()+"\t 生产"+result+"成功");
            else System.out.println(Thread.currentThread().getName()+"\t 生产"+result+"失败");
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName()+"\t 停止工作");
    }
    public void consumer()throws Exception{
        String data=null;
        while(flag){
            data=blockingQueue.poll(2L, TimeUnit.SECONDS);
            if(null==data||data.equals("")){
                flag=false;
                System.out.println(Thread.currentThread().getName()+"等待超时，停止消费");
            }

            System.out.println(Thread.currentThread().getName()+"\t 消费"+data+"成功");
            TimeUnit.SECONDS.sleep(1);

        }
        System.out.println(Thread.currentThread().getName()+"\t 停止工作");
    }

    public void stop() {
        this.flag=false;
    }
}
