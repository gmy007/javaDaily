package com.cug.demo0315;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public class SoftReferenceDemo {

    /**
     * -Xms40m -Xmx40m -XX:+PrintGCDetails
     */
    public static void softRef_Memory_NotEnough(){
        Object o1=new Object();
        SoftReference<Object> softReference = new SoftReference<>(o1);

        o1=null;
        try{
            byte[] bytes = new byte[50*1024*1024];//-xms40m -xmx40m 弱引用内存不足 自动回收

        }catch (Throwable e){
            e.printStackTrace();
        }finally {
            System.out.println("-----------------------");
            System.out.println(o1);
            System.out.println(softReference.get());
            System.out.println("-----------------------");
        }
    }


    public  static  void weakRef_Memory_Enough(){
        Object o1=new Object();
        WeakReference<Object> weakReference = new WeakReference<>(o1);
        System.out.println(o1);
        System.out.println(weakReference.get());
        o1=null;

        System.gc();
        System.out.println("----System.gc---------");
        System.out.println(weakReference.get());
    }
    /**
     * weakHashMap
     * 假如一个应用需要加载大量本地图片，将图片放入内存会加快读取进度，但是大量图片进入会触发OOM内存溢出异常
     * 设计思路：用一个软引用，缓存图片，当jvm内存不足则进行回收。
     */
    public static  void myWeakHashMap(){

        WeakHashMap<String, String> weakHashMap = new WeakHashMap<>();
        String s=new String("gmy");
        String value=new String("NB");
        weakHashMap.put(s,value);
        s=null;
        System.out.println(weakHashMap);
        System.gc();//回收
        System.out.println(weakHashMap+"\t" +weakHashMap.size());


    }
    public static  void Phantom_Memory_Enough(){
        Object o1 = new Object();
        ReferenceQueue<Object> referenceQueue=new ReferenceQueue<>();
        PhantomReference<Object> phantomReference = new PhantomReference<>(o1, referenceQueue);
        System.out.println(o1);
        System.out.println(phantomReference.get());//虚引用的get永远返回null
        System.out.println(referenceQueue.poll());

        System.out.println("-----------------");
        o1=null;
        System.gc();
        System.out.println(o1);
        System.out.println(phantomReference.get());
        System.out.println(referenceQueue.poll());//GC后虚引用添加到引用队列中，相当于判死缓，提供一些信息的通知。


    }
    public static void main(String[] args) {
        //softRef_Memory_NotEnough(); 不够则回收
        //weakRef_Memory_Enough();    如果GC肯定回收
//        myWeakHashMap();
        Phantom_Memory_Enough();
    }
}
